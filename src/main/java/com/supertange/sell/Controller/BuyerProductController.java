package com.supertange.sell.Controller;

import com.supertange.sell.Utils.ResultVoUtil;
import com.supertange.sell.VO.ProductInfoVo;
import com.supertange.sell.VO.ProductVo;
import com.supertange.sell.VO.ResultVo;
import com.supertange.sell.dataObject.ProductCategory;
import com.supertange.sell.dataObject.ProductInfo;
import com.supertange.sell.service.CategoryService;
import com.supertange.sell.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lyj on 2017/10/13.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVo list(){
        //1.查询所有的上架商品
        List<ProductInfo> productInfoList=productService.findUpAll();

        //2.查询类目（一次性查询）
//        List<Integer> categoryTypeList=new ArrayList<>();
//        //传统方法
//        for(ProductInfo productInfo:productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法（java8,lambda）
        List<Integer> categoryTypeList= productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        System.out.println(categoryTypeList);
        List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装lo
        List<ProductVo> productVoList=new ArrayList<>();
        for (ProductCategory productCategory:productCategoryList){
            ProductVo productVo=new ProductVo();
            productVo.setCategoryType(productCategory.getCategoryType());
            productVo.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVo> productInfoVoList=new ArrayList<>();
            for (ProductInfo productInfo:productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }

//        ResultVo resultVo=new ResultVo();

//        ProductVo productVo=new ProductVo();
//        ProductInfoVo productInfoVo=new ProductInfoVo();
//
//        productVo.setProductInfoVoList(Arrays.asList(productInfoVo));
//        resultVo.setData(Arrays.asList(productVo));
//        resultVo.setData(productVoList);
//        resultVo.setCode(0);
//        resultVo.setMsg("成功");

        return ResultVoUtil.success(productVoList);

//        return resultVo;
    }

}
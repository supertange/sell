package com.supertange.sell.Controller;

import com.supertange.sell.Utils.ResultVoUtil;
import com.supertange.sell.VO.ResultVo;
import com.supertange.sell.converter.OrderForm2OrderDTOConverter;
import com.supertange.sell.dto.OrderDTO;
import com.supertange.sell.exception.ResultEnum;
import com.supertange.sell.exception.SellException;
import com.supertange.sell.form.OrderForm;
import com.supertange.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;
    //创建订单
    @PostMapping("/create")
    public ResultVo<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("创建订单参数不正确",orderForm);
            throw  new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());

        }
        OrderDTO orderDTO= OrderForm2OrderDTOConverter.convert(orderForm);
        if (org.springframework.util.CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("创建的购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult=orderService.create(orderDTO);
        Map<String,String> map=new HashMap<>();
        map.put("orderId",createResult.getOrderId());

        return ResultVoUtil.success(map);
    }



    //查询订单
    @GetMapping("list")
    public ResultVo<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0")Integer page,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size){
        if (StringUtils.isEmpty(openid)){
            log.error("订单列表openid为🈳空");
            throw  new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request=new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage=orderService.findList(openid,request);
        return ResultVoUtil.success(orderDTOPage.getContent());
    }

    /**
     * 订单详情
     * @param openid
     * @param orderId
     * @return
     */
    @PostMapping("detail")
    public ResultVo<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){

        //检查是否是自己的订单
        //OrderDTO orderDTO=buyerService.findOrderOne(openid,orderId);

         OrderDTO orderDTO=orderService.findOne(orderId);
        return ResultVoUtil.success(orderDTO);
    }

    /**
     * 取消订单
     * @param openid
     * @param orderId
     * @return
     */
    @PostMapping("cancel")
    public ResultVo cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId){

        //取消操作
        //buyerService.ordercancel(openid,orderId);
        OrderDTO orderDTO=orderService.findOne(orderId);
        orderService.cancel(orderDTO);

        return ResultVoUtil.success();

    }



}

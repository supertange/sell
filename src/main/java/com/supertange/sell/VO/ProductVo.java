package com.supertange.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductVo {
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("food")
    private List<ProductInfoVo> productInfoVoList;

}

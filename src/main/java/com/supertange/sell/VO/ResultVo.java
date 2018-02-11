package com.supertange.sell.VO;

import lombok.Data;

/**
 * http返回的最外层对象
 */

@Data
public class ResultVo<T> {
    //错误码
    private  Integer code;
    //提示信息
    private  String msg="";
    //返回的具体内容
    private  T data;

}

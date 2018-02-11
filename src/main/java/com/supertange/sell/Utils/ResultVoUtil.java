package com.supertange.sell.Utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.supertange.sell.VO.ResultVo;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVoUtil {
    public static ResultVo success(Object object){
        ResultVo resultVo=new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(object);
        return resultVo;
    }

    public static ResultVo success(){
        return success(null);
    }

    public static ResultVo error(Integer code,String msg){
        ResultVo resultVo=new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }

}

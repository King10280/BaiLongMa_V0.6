package com.uek.bigdata.exception;

/**
 * @author 优逸客大数据研发部
 * @className: CartyException
 * @description: 异常处理类
 * @date: 2020/11/26 12:38
 * @version: 1.0
 */
public class CartyException extends Exception {

    /**
     * @Param :  
     * @return 
     * @description
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:30 
     */
    public CartyException() {
        super("图书库存不足!");
    }

    /**
     * @Param message:  
     * @return 
     * @description
     * @author 优逸客大数据研发部
     * @date 2020/11/27 11:38
     */
    public CartyException(String message) {
        super(message);
    }

}
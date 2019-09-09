package com.Firefly.forR3.exception;


/**
 * @author：XudongHu 继承运行时异常, 并将自己的枚举异常类添加进来
 * 这样不需要try catch自己想抛就抛
 */
public class MyExceptions extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Integer code;

    public MyExceptions(EnumExceptions exceptionsEnum) {
        super(exceptionsEnum.getMessage());

        this.code = exceptionsEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

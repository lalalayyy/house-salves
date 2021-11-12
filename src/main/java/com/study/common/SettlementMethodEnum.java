package com.study.common;

/**
* @author       wangqingfu
* @date         2021/11/10
* @description  计息方式枚举类
*/
public enum SettlementMethodEnum {

    EQUAL_PRINCIPAL(1, "等额本金"),
    EQUAL_INSTALLMENTS_OF_PRINCIPAL_AND_INTEREST(2, "等额本金");

    private int type;

    private String name;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    SettlementMethodEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }
}

package com.study.bs.mortgage.entity;

import lombok.Data;

/**
* @author       wangqingfu
* @date         2021/11/12
* @description  房贷计算器 请求参数
*/
@Data
public class MortgageReq {
    /**
     * 贷款类别
     * 1、商贷
     * 2、公积金贷款
     * 3、组合贷
     */
    private Integer loanCategory;
    /**
     * 贷款总额 单位：万元
     */
    private Integer totalLoan;
    /**
     * 贷款年限
     */
    private Integer loanYear;
    /**
     * 贷款利率
     */
    private Double lendingRates;
    /**
     * 还款方式
     */
    private Integer repayment;
}

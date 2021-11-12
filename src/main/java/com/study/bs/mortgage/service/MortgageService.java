package com.study.bs.mortgage.service;

import com.study.bs.mortgage.entity.MortgageReq;

/**
* @author       wangqingfu
* @date         2021/11/12
* @description  计算器接口类
*/
public interface MortgageService {

    void mortgageCalc(MortgageReq req);
}

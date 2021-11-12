package com.study.bs.mortgage;

import cn.hutool.json.JSONUtil;
import com.study.bs.mortgage.entity.MortgageReq;
import com.study.bs.mortgage.service.MortgageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* @author       wangqingfu
* @date         2021/11/12
* @description  房贷计算器 入口
*/
@RestController
@Slf4j
public class MortgageController {

    @Resource
    private MortgageService mortgageService;

    @PutMapping("/calcMortgage")
    public String calc(@RequestBody MortgageReq req) {

        log.debug("房贷计算器，请求参数 ==> {}", JSONUtil.toJsonStr(req));

        String checkStr = preCheck(req);

        if (null != checkStr) {
            return checkStr;
        }

        mortgageService.mortgageCalc(req);

        return null;
    }

    private String preCheck(MortgageReq req) {
        if (null == req) {
            return "the param can not be empty!";
        }

        if (null == req.getLendingRates() || req.getLendingRates() < 3 || req.getLendingRates() >= 10) {
            return "lending rates is not a available number!";
        }

        if (null == req.getLoanCategory()) {
            return "loan category can not be empty!";
        }

        if (null == req.getRepayment()) {
            return "repayment can not be empty!";
        }

        return null;
    }
}

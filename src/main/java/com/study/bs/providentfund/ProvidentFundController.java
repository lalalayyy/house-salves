package com.study.bs.providentfund;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Arrays;

/**
* @author       wangqingfu
* @date         2021/11/10
* @description  公积金贷款
*/
@RestController
@Slf4j
public class ProvidentFundController {

    public static void main(String[] args) {

        String[] strings = calculateEqualPrincipalAndInterest(100, 360, 4.9);

        log.info("打印 ==> {}", Arrays.toString(strings));
    }


    /**
     * 计算等额本息还款
     *
     * @param principal 贷款总额
     * @param months    贷款期限
     * @param rate      贷款利率
     * @return
     */
    public static String[] calculateEqualPrincipalAndInterest(double principal, int months, double rate) {
        ArrayList<String> data = new ArrayList<String>();
        // 月利率
        double monthRate = rate / (100 * 12);
        // 每月还款金额
        double preLoan = (principal * monthRate * Math.pow((1 + monthRate), months)) / (Math.pow((1 + monthRate), months) - 1);
        // 还款总额
        double totalMoney = preLoan * months;
        // 还款总利息
        double interest = totalMoney - principal;
        // 还款总额
        data.add("\n还款总额 ==> {}" + totalMoney);
        // 贷款总额
        data.add("\n贷款总额 ==> " + principal);
        // 还款总利息
        data.add("\n还款总利息 ==> " + interest);
        // 每月还款金额
        data.add("\n每月还款金额 ==> " + preLoan);
        // 还款期限
        data.add(String.valueOf(months));
        return data.toArray(new String[data.size()]);
    }
}

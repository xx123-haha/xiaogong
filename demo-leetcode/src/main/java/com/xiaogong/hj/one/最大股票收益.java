package com.xiaogong.hj.one;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-08-13
 */
public class 最大股票收益 {

    public static void main(String[] args) {
        String[] prices = {"2Y", "3S", "4S", "6Y", "8S"};
        System.out.println(maxProfit(prices));
    }

public static int maxProfit(String[] prices) {
    if (prices == null || prices.length <= 1) {
        return 0;
    }

    int maxMoney = 0;
    int previousValue = 0;

    for (int i = 0; i < prices.length; i++) {
        String price = prices[i];
        char lastChar = price.charAt(price.length() - 1);

        // 去除最后一个字符
        String numericPart = price.substring(0, price.length() - 1);

        // 根据最后一个字符决定乘以 7 或直接添加
        int currentValue = lastChar == 'Y' ? Integer.parseInt(numericPart) : Integer.parseInt(numericPart) * 7;

        // 如果是第一个元素，设置为当前值
        if (i == 0) {
            previousValue = currentValue;
            continue;
        }

        // 计算利润
        int profit = currentValue - previousValue;
        if (profit > 0) {
            maxMoney += profit;
        }

        // 更新前一个值
        previousValue = currentValue;
    }

    return maxMoney;
}


}

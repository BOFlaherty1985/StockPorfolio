package service;

import functionalinterface.CalculateStockPERatio;

import java.math.BigDecimal;

public class StockFundamentalServiceImpl {

    public Double calculatePERatio(double stockPrice, double earningsPerShare) {

        CalculateStockPERatio calculate = (a, b) -> stockPrice / earningsPerShare;
        Double peRatio = calculate.calculateStockPERatio(stockPrice, earningsPerShare);

        return new BigDecimal(peRatio).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}

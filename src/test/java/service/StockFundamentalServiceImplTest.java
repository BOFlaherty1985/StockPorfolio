package service;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StockFundamentalServiceImplTest {

    private StockFundamentalServiceImpl service = new StockFundamentalServiceImpl();

    @Test
    public void calculatePERatio_givenStockPriceAndEarningsPerShare_peRatioEquals8141() {

        double stockPrice = 13.84;
        double earningsPerShare = 0.17;

        Double peRatio = service.calculatePERatio(stockPrice, earningsPerShare);
        assertEquals(81.41D, peRatio.doubleValue(), 0);
    }

    @Test
    public void calculatePERatio_givenStockPriceAndEarningsPerShare_peRatioEquals1257() {

        double stockPrice = 4.65;
        double earningsPerShare = 0.37;

        Double peRatio = service.calculatePERatio(stockPrice, earningsPerShare);
        assertEquals(12.57D, peRatio.doubleValue(), 0);

    }

}

package service;

import domain.Stock;

/**
 * Created by Benjamin on 15/05/2016.
 */
public class StockPortfolioServiceImpl {

    private final FtseApiService ftseApiService;

    public StockPortfolioServiceImpl(FtseApiService ftseApiService) {
        this.ftseApiService = ftseApiService;
    }

    public Stock retrieveStockDetailsByTicket() {

        final Stock stock = new Stock();
        stock.setCompanyName("abc");
        stock.setTicker("xxx");
        stock.setCurrentPrice("123");
        stock.setPriceChange("-1");

        getFtseApiService();

        return stock;
    }

    protected FtseApiService getFtseApiService() {
        return ftseApiService;
    }
}

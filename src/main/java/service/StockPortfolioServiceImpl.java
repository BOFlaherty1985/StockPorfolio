package service;

import domain.Stock;

/**
 * Created by Benjamin on 15/05/2016.
 */
public class StockPortfolioServiceImpl {

    private FtseApiService ftseApiService;

    public StockPortfolioServiceImpl(FtseApiService ftseApiService) {
        this.ftseApiService = ftseApiService;
    }

    public Stock retrieveStockDetailsByTicker(String stockTicker) {
        return ftseApiService.getStockDetailsByTicker(stockTicker);
    }

}

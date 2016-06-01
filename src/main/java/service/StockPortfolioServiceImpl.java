package service;

import domain.Stock;

public class StockPortfolioServiceImpl {

    private FtseApiService ftseApiService;

    public StockPortfolioServiceImpl(FtseApiService ftseApiService) {
        this.ftseApiService = ftseApiService;
    }

    public Stock retrieveStockDetailsByTicker(String stockTicker) {
        return ftseApiService.getStockDetailsByTicker(stockTicker).get();
    }

}

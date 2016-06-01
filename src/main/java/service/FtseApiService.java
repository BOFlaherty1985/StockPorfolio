package service;

import domain.Stock;

import java.util.Optional;

public interface FtseApiService {

    Optional<Stock> getStockDetailsByTicker(String stockTicker);

}

package service;

import domain.Stock;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

public class FtseApiServiceImpl implements FtseApiService {

    public Optional<Stock> getStockDetailsByTicker(String stockTicker) {

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:8080/stockTicker/" + stockTicker, String.class);

        Stock stock = new Stock();
        stock.setCompanyName(result);
        stock.setTicker(stockTicker);

        return Optional.of(stock);
    }
}

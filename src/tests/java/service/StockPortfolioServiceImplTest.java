package service;

import domain.Stock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Benjamin on 15/05/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class StockPortfolioServiceImplTest {

    @Mock
    private FtseApiService ftseApiService;

    @InjectMocks
    private final StockPortfolioServiceImpl service = new StockPortfolioServiceImpl(ftseApiService);

    private static final String STOCK_TICKER = "ABC";

    @Test
    public void retrieveStockDetailsByTicker_methodReturn_notEqualToNull() {

        setupMockStockObject();

        assertNotNull(service.retrieveStockDetailsByTicker("ABC"));
    }

    @Test
    public void retrieveStockDetailsByTicker_stockReturned_containsCompanyName() {

        setupMockStockObject();

        Stock stock = service.retrieveStockDetailsByTicker("ABC");
        assertNotNull(stock.getCompanyName());
    }

    @Test
    public void retrieveStockDetailsByTicker_stockReturned_containsTicker() {

        setupMockStockObject();

        Stock stock = service.retrieveStockDetailsByTicker("ABC");
        assertNotNull(stock.getTicker());
    }

    @Test
    public void retrieveStockDetailsByTicker_stockReturned_containsCurrentPrice() {

        setupMockStockObject();

        Stock stock = service.retrieveStockDetailsByTicker("ABC");
        assertNotNull(stock.getCurrentPrice());
    }

    @Test
    public void retrieveStockDetailsByTicker_stockReturned_containsPriceChange() {

        setupMockStockObject();

        Stock stock = service.retrieveStockDetailsByTicker("ABC");
        assertNotNull(stock.getPriceChange());
    }

    @Test
    public void retrieveStockDetailsByTicker_verifyFtseApi_calledOnce() {

        setupMockStockObject();

        service.retrieveStockDetailsByTicker("ABC");
        verify(ftseApiService, times(1)).getStockDetailsByTicker(STOCK_TICKER);
    }

    @Test
    public void retrieveStockDetailsByTicker_stockTickerABCProvided_stockDetailsReturned() {

        setupMockStockObject();

        Stock stock =  service.retrieveStockDetailsByTicker(STOCK_TICKER);
        assertEquals("ABC", stock.getTicker());
    }

    private Stock createStubStock(String stockTicker) {
        final Stock stock = new Stock();
        stock.setCompanyName("abc");
        stock.setTicker(stockTicker);
        stock.setCurrentPrice("123");
        stock.setPriceChange("-1");

        return stock;
    }

    private void setupMockStockObject() {
        when(ftseApiService.getStockDetailsByTicker(STOCK_TICKER)).thenReturn(createStubStock(STOCK_TICKER));
    }
}

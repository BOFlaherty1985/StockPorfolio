package service;

import domain.Stock;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Benjamin on 15/05/2016.
 */
public class StockPortfolioServiceImplTest {

    private final FtseApiService ftseApiService = new FtseApiService();
    private final StockPortfolioServiceImpl service = new StockPortfolioServiceImpl(ftseApiService);

    @Test
    public void retrieveStockDetailsByTicker_methodReturn_notEqualToNull() {
        assertNotNull(service.retrieveStockDetailsByTicket());
    }

    @Test
    public void retrieveStockDetailsByTicker_stockReturned_containsCompanyName() {
        Stock stock = service.retrieveStockDetailsByTicket();
        assertNotNull(stock.getCompanyName());
    }

    @Test
    public void retrieveStockDetailsByTicker_stockReturned_containsTicker() {
        Stock stock = service.retrieveStockDetailsByTicket();
        assertNotNull(stock.getTicker());
    }

    @Test
    public void retrieveStockDetailsByTicker_stockReturned_containsCurrentPrice() {
        Stock stock = service.retrieveStockDetailsByTicket();
        assertNotNull(stock.getCurrentPrice());
    }

    @Test
    public void retrieveStockDetailsByTicker_stockReturned_containsPriceChange() {
        Stock stock = service.retrieveStockDetailsByTicket();
        assertNotNull(stock.getPriceChange());
    }

    @Test
    public void retrieveStockDetailsByTicket_ftseAPIService_calledOnce() {
        TestableStockPortfolioImpl service = new TestableStockPortfolioImpl(new FtseApiService());
        service.retrieveStockDetailsByTicket();
        assertTrue(service.getFtseApiServiceCalled());
    }

    public class TestableStockPortfolioImpl extends StockPortfolioServiceImpl {

        private boolean isFtseApiServiceCalled;

        public TestableStockPortfolioImpl(FtseApiService ftseApiService) {
            super(ftseApiService);
        }

        @Override
        protected FtseApiService getFtseApiService() {
            isFtseApiServiceCalled = true;
            return ftseApiService;
        }

        public boolean getFtseApiServiceCalled() {
            return isFtseApiServiceCalled;
        }

    }

}

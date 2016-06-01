import domain.Stock;
import service.FtseApiServiceImpl;
import service.StockPortfolioServiceImpl;

/**
 * Created by Benjamin on 31/05/2016.
 */
public class MainApp {

    public static void main(String[] args) {

        FtseApiServiceImpl apiService = new FtseApiServiceImpl();

        StockPortfolioServiceImpl service = new StockPortfolioServiceImpl(apiService);
        Stock result = service.retrieveStockDetailsByTicker("ABC");

        System.out.println(result.toString());

    }

}

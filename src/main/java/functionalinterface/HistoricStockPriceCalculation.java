package functionalinterface;

@FunctionalInterface
public interface HistoricStockPriceCalculation {

    int calculateHistoricStockPrice(int oldPrice, int newPrice);

    default int futureProjection(int oldPrice, int newPrice) {
        return (oldPrice + newPrice) * 100;
    }

}

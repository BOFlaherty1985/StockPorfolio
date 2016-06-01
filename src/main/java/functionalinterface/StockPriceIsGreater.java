package functionalinterface;

@FunctionalInterface
public interface StockPriceIsGreater {

    boolean isStockPriceGreater(int stockOne, int stockTwo);

}

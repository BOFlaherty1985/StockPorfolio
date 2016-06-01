package functionalinterface;

@FunctionalInterface
public interface CalculateStockPERatio {

    double calculateStockPERatio(double stockPrice, double earningsPerShare);

}

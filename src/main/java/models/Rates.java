package models;

/**
 * Created by aleksandrkorablev on 14.01.17.
 */
public class Rates {

    private Currency toCurrency;
    private Currency fromCurrency;

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    @Override
    public String toString() {
        return "Rates{" +
                ", toCurrency=" + toCurrency +
                ", fromCurrency=" + fromCurrency + "\n" +
                '}';
    }
}

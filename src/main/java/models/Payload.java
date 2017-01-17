package models;

import java.util.List;

/**
 * Created by aleksandrkorablev on 16.01.17.
 */
public class Payload {
    private UpdateDate lastUpdate;
    private List<Rates> rates;

    public UpdateDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(UpdateDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Rates> getRates() {
        return rates;
    }

    public void setRates(List<Rates> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "lastUpdate=" + lastUpdate +
                ", rates=" + rates +
                '}' + "\n";
    }
}

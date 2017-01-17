package models;

/**
 * Created by aleksandrkorablev on 16.01.17.
 */
public class UpdateDate {
    private Long milliseconds;

    public Long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(Long milliseconds) {
        this.milliseconds = milliseconds;
    }

    @Override
    public String toString() {
        return "UpdateDate{" +
                "milliseconds=" + milliseconds +
                '}';
    }
}

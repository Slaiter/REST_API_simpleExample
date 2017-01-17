package models;

/**
 * Created by aleksandrkorablev on 16.01.17.
 */
public class Response {
    private String resultCode;
    private Payload payload;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Response{" +
                "resultCode='" + resultCode + '\'' + "\n" +
                ", payload=" + payload + "\n" +
                '}';
    }
}

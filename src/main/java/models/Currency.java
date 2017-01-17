package models;

/**
 * Created by aleksandrkorablev on 16.01.17.
 */
public class Currency {
    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}

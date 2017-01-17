import models.Currency;
import models.Rates;
import models.Response;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;


/**
 * Created by aleksandrkorablev on 17.01.17.
 */
public class ToCurrencyTest {

    @Test
    public void testCurrencyTest() {
        RestTemplate restTemplate = new RestTemplate();
        Response response = restTemplate.getForObject("https://www.tinkoff.ru/api/v1/currency_rates", Response.class);

        //Сравниваем у json объекта “toCurrency” значения «code» и «name» для параметра RUB
        for (Rates rate : response.getPayload().getRates()) {
            checkCurrency(rate.getToCurrency());
        }
    }

    private void checkCurrency(Currency currency) {

        if ("RUB".equals(currency.getName())) {
            boolean RUB = currency.getCode() == 643;
            System.out.println(String.format("%s %s = %s", currency.toString(), String.valueOf(currency.getCode()), String.valueOf(RUB)));
            Assert.assertTrue(RUB);

        }
    }
}

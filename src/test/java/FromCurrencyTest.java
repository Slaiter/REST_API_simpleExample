import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import models.Currency;
import models.Rates;
import models.Response;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Comparator;


/**
 * Created by aleksandrkorablev on 17.01.17.
 */
public class FromCurrencyTest {

    @Test
    public void TestFromCurrencyTest() {
        RestTemplate restTemplate = new RestTemplate();
        Response response = restTemplate.getForObject("https://www.tinkoff.ru/api/v1/currency_rates", Response.class);

        //Этот метод упорядочивает по имени вывод значений на экран.
        Collections.sort(response.getPayload().getRates(), new Comparator<Rates>() {
            @Override
            public int compare(Rates o1, Rates o2) {
                return o1.getFromCurrency().getName().compareTo(o2.getFromCurrency().getName());
            }
        });

        //Сравниваем у json объектов “fromCurrency” и “toCurrency” значения «code» и «name» для параметров GBR, EUR, USD
        for (Rates rate : response.getPayload().getRates()) {
            checkCurrency(rate.getFromCurrency());
        }
    }

    private void checkCurrency(Currency currency) {

        if ("GBP".equals(currency.getName())) {
            boolean GBR = currency.getCode() == 826;
            System.out.println(String.format("%s %s = %s", currency.toString(), String.valueOf(currency.getCode()), String.valueOf(GBR)));
            Assert.assertTrue(GBR);

        }

        if ("EUR".equals(currency.getName())) {
            boolean EUR = currency.getCode() == 978;
            System.out.println(String.format("%s %s = %s", currency.toString(), String.valueOf(currency.getCode()), String.valueOf(EUR)));
            Assert.assertTrue(EUR);

        }

        if ("USD".equals(currency.getName())) {
            boolean USD = currency.getCode() == 840;
            System.out.println(String.format("%s %s = %s", currency.toString(), String.valueOf(currency.getCode()), String.valueOf(USD)));
            Assert.assertTrue(USD);

        }
    }
}



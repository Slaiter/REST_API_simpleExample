import models.Currency;
import models.Rates;
import models.Response;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

/**
 * Created by aleksandrkorablev on 12.01.17.
 */
public class SampleTestCase {

    //Пробный тест

    /* Задание

    Написать автотест для публичного метода api (https://www.tinkoff.ru/api/v1/currency_rates/) проверяющий,
            // что для каждого json-объекта “fromCurrency” и “toCurrency” значения «code»
            // и «name» соответствовали следующим правилам:

            1. При code=643, name=RUB

            2. При code=840, name=USD

            3. При code=978, name=EUR

            4. При code=826, name=GBP Требования к реализации

            Язык программирования Java/С#, тестовый фреймворк желательно xUnit */


    @Test
    public void TestResponce() {
        RestTemplate restTemplate = new RestTemplate();
        Response response = restTemplate.getForObject("https://www.tinkoff.ru/api/v1/currency_rates", Response.class);
        System.out.println(response);

        //Сравниваем у json объектов “fromCurrency” и “toCurrency” значения «code» и «name»
        for (Rates rate : response.getPayload().getRates()) {
            checkCurrency(rate.getFromCurrency());
            checkCurrency(rate.getToCurrency());
        }

        //Попытка использования метода выше с помощью потока stream
        /*response.getPayload().getRates().stream()
                .flatMap(rate -> Stream.of(rate.getFromCurrency(), rate.getToCurrency()))
                .forEach(this::checkCurrency);*/
    }

    private void checkCurrency(Currency currency) {
        boolean success = (
                ("RUB".equals(currency.getName()) && 643 == currency.getCode()) ||
                ("EUR".equals(currency.getName()) && 978 == currency.getCode()) ||
                ("USD".equals(currency.getName()) && 840 == currency.getCode()) ||
                ("GBP".equals(currency.getName()) && 826 == currency.getCode())
        );
        //System.out.println(success);
        Assert.assertTrue(success);
    }

}

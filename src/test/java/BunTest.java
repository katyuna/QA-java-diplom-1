import com.github.javafaker.Faker;
import org.junit.Test;
import praktikum.Bun;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BunTest {

    //ARRANGE
    //Сгенерировать тестовые данные - имя и цену булочки
    Faker faker = new Faker();
    Random random = new Random();
    String name = faker.food().toString();
    Float price = random.nextFloat();

    //ACT
    //Создать объект Bun
    Bun bun = new Bun(name, price);

    @Test
    public void testBunNameIs() {
        //Вызвать тестируемый метод
        String actual = bun.getName();
        String expected = name;
        //ASSERT
        //Проверить, что метод вызван с заданными параметрами
        assertEquals("Ошибка в работе метода bun.getName()", expected, actual);
    }

    @Test
    public void testBunPriceIs() {
        //Вызвать тестируемый метод
        float actual = bun.getPrice();
        float expected = price;
        //ASSERT
        //Проверить, что метод вызван с заданными параметрами
        assertEquals("Ошибка в работе метода bun.getPrice()", expected, actual, 0);
    }
}

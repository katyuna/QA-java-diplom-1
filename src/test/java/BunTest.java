import com.github.javafaker.Faker;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BunTest {

    //ARRANGE
    //Сгенерировать тестовые данные - имя и цену булочки
    Faker faker = new Faker();
    Random random = new Random();
    String name = faker.food().toString();
    Float price = random.nextFloat();
    //Создать объект Bun
    Bun bun = new Bun(name, price);

    @Test
    public void testBunGetName() {
        //ACT
        //Вызвать тестируемый метод
        String actual = bun.getName();
        String expected = name;
        //ASSERT
        //Проверить, что метод вызван с заданными параметрами
        assertEquals("Ошибка в работе метода bun.getName(). Имя не соответсвует ожидаемому.", expected, actual);
    }

    @Test
    public void testBunGetPrice() {
        //ACT
        //Вызвать тестируемый метод
        float actual = bun.getPrice();
        float expected = price;
        //ASSERT
        //Проверить, что метод вызван с заданными параметрами
        assertEquals("Ошибка в работе метода bun.getPrice(). Цена не соответсвует ожидаемой.", expected, actual, 0);
    }
}

import com.github.javafaker.Faker;
import org.junit.Test;

import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    //ARRANGE
    //Сгенерировать тестовые данные - имя и цену ингредиента
    Faker faker = new Faker();
    Random random = new Random();
    String name = faker.food().toString();
    Float price = random.nextFloat();
    //Создать объект Ingredient
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);

    @Test
    public void testGetPrice(){
        //ACT
        //Вызвать тестируемый метод
        float actual = ingredient.getPrice();
        float expected = price;
        //ASSERT
        //Проверить, что метод вызван с заданными параметрами
        assertEquals("Ошибка в работе метода ingredient.getPrice(). Цена не соответсвует ожидаемой.", expected, actual, 0);
    }

    @Test
    public void testGetName(){
        //ACT
        //Вызвать тестируемый метод
        String actual = ingredient.getName();
        String expected = name;
        //ASSERT
        //Проверить, что метод вызван с заданными параметрами
        assertEquals("Ошибка в работе метода ingredient.getName(). Имя не соответсвует ожидаемому.", expected, actual);
    }

    @Test
    public void testGetType(){
        //ACT
        //Вызвать тестируемый метод
        IngredientType actual =  ingredient.getType();
        IngredientType expected = IngredientType.SAUCE;
        //ASSERT
        //Проверить, что метод вызван с заданными параметрами
        assertEquals("Ошибка в работе метода ingredient.getType(). Тип ингредиента на соответствет ожидаемому.", expected, actual);
    }
}

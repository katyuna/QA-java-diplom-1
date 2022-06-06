import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    //ARRANGE
    //Тип ингридиента из перечисления
    private final IngredientType ingredientType;
    //Ожидаемый тип ингридиента
    private final String expectedIngredientType;
    //Конструктор
    public IngredientTypeTest(String expectedIngredientName, IngredientType ingredientType) {
        this.ingredientType = ingredientType;
        this.expectedIngredientType = expectedIngredientName;
    }

    //Параметризация: передаем строку - тип ингредиента
    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {"SAUCE", IngredientType.SAUCE},
                {"FILLING", IngredientType.FILLING}
        };
    }

    @Test
    public void testIngredientType() {
        //ACT
        //Получить тип ингридиента из перечисления в виде строки
        String actualIngredientName = ingredientType.name();
        //ASSERT
        assertEquals("Не удалось получить ингридиент из перечисления.", expectedIngredientType, actualIngredientName.toString());
        }
}


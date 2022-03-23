import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    //ARRANGE
    //Тип ингридиента
    private final IngredientType ingredientType;
    //Порядковый номер ингредиента в перечислении
    private final int expectedIngredientNumber;
    //Конструктор
    public IngredientTypeTest(IngredientType ingredientType, int expectedIngredientNumber) {
        this.ingredientType = ingredientType;
        this.expectedIngredientNumber = expectedIngredientNumber;
    }
    //Параметризация: передаем ингридиент -> получаем номер ингредиента в перечислении
    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {IngredientType.SAUCE, 0},
                {IngredientType.FILLING, 1}
        };
    }

    @Test
    public void testIngredientType() {
        //ACT
        int actualIngredientNumber = ingredientType.ordinal();
        //ASSERT
        assertEquals("Не удалось получить ингридиент из перечисления.", expectedIngredientNumber, actualIngredientNumber);
        }
}


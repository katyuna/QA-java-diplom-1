import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest {

    //ARRANGE
    //Бургер состоит из булочек и ингредиентов (начинка или соус)
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    //Создать бургер
    Burger burger = new Burger();
    //Создать тестовый ингридиент
    Ingredient testIngredient = new Ingredient(SAUCE, "test", 100);
    //Создать тестовую булочку
    Bun testBun = new Bun("testBun", 200);

    @Test
    public void testBurgerSetBun() {
        //ACT
        //Выбрать булочку
        burger.setBuns(bun);
        //ASSERT
        //Проверить, что булочка выбрана
        assertEquals("Ошибка в работе метода burger.setBuns(). Булочка не выбрана.", burger.bun, bun);
    }

    @Test
    public void testBurgerAddIngredient() {
        //ACT
        //Добавить ингредиент
        burger.addIngredient(ingredient);
        //ASSERT
        //Проверить, что ингридиенты в бургере есть
        assertNotNull("Ошибка в работе метода burger.addIngredient(ingredient). Ингредиент не добавлен.", burger.ingredients);
    }

    @Test
    public void testBurgerRemoveIngredient() {
        //ACT
        //Добавить ингредиент
        burger.addIngredient(ingredient);
        //Удалить ингредиент
        burger.removeIngredient(0);
        //ASSERT
        //Проверить, что ингридиентов в бургере нет
        assertTrue("Ошибка в работе метода burger.removeIngredient(). Ингредиент не удален.", burger.ingredients.isEmpty());
    }

    @Test
    public void testBurgerMoveIngredient() {
        //ACT
        //Добавить мок-ингредиент
        burger.addIngredient(ingredient);
        //Добавить тестогвый-ингредиент
        burger.addIngredient(testIngredient);
        //Переместить ингридиент с индекмсом 0 (мок-ингиридиент) на позицию с индексом 1
        burger.moveIngredient(0, 1);
        //ASSERT
        //Проверить, что на позиции 0 теперь находится тестовый ингридиент
        assertEquals("Ошибка в работе метода burger.moveIngredient(). Ингридиент не перемещен.", "test", testIngredient.name);
    }

    @Test
    public void testBurgerGetPrice() {
        //ACT
        //Добавить булочку
        burger.setBuns(testBun);
        //Добавить ингредиент
        burger.addIngredient(testIngredient);
        //Получить цену бургера
        Float actualPrice = burger.getPrice();
        Float expectedPrice = testBun.price * 2 + testIngredient.price;
        //ASSERT
        //
        assertEquals("Ошибка в работе метода burger.getPrice(). Полученная цена не совпадает с ожидаемой", expectedPrice, actualPrice);
    }

    @Test
    public void testBurgerGetReceipt() {
        //ACT
        //Добавить булочку
        burger.setBuns(testBun);
        //Добавить ингредиент
        burger.addIngredient(testIngredient);
        //Получить чек
        String actualReceipt = burger.getReceipt();
        String finalPrice = String.format("%.6f", burger.getPrice());

        String expectedReceipt = String.format(
                        "(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %s%n",
                        testBun.name,
                        testIngredient.type.toString().toLowerCase(),
                        testIngredient.name,
                        testBun.name,
                        finalPrice);
        //ASSERT
       assertEquals("Ошибка в работе метода burger.getReceipt(). Рецепт не соответсвует шаблону.", expectedReceipt, actualReceipt);
    }
}

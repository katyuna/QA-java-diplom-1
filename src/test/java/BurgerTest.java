import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;

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
    public void testSetBun() {
        //ACT
        //Выбрать булочку
        burger.setBuns(bun);
        //ASSERT
        //Проверить, что булочка выбрана
        assertEquals("Ошибка в работе метода burger.setBuns(). Булочка не выбрана.", burger.bun, bun);
    }

    @Test
    public void testAddIngredient() {
        //ACT
        //Добавить ингредиент
        burger.addIngredient(ingredient);
        //ASSERT
        //Проверить, что ингридиенты в бургере есть
        assertNotNull("Ошибка в работе метода burger.addIngredient(ingredient). Ингредиент не добавлен.", burger.ingredients);
    }

    @Test
    public void testRemoveIngredient() {
        //ACT
        //Добавить ингредиент
        burger.addIngredient(ingredient);
        //Удалить ингредиент
        burger.removeIngredient(0);
        //ASSERT
        //Проверить, что ингридиентов в бургере нет
        assertNull("Ошибка в работе метода burger.removeIngredient(). Ингредиент не удален.", burger.ingredients);
    }

    @Test
    public void testMoveIngredient() {
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
    public void testGetPrice(){
        //ACT
        //Добавить булочку
        burger.setBuns(testBun);
        //Добавить ингредиент
        burger.addIngredient(testIngredient);
        //Получить цену бургера
        Float actualPrice = burger.getPrice();
        Float expectedPrice = testBun.price*2+testIngredient.price;
        //ASSERT
        //
        assertEquals("Ошибка в работе метода getPrice. Полученная цена не совпадает с ожидаемой", expectedPrice, actualPrice);
    }
}

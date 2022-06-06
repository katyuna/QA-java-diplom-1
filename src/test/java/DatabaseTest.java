import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class DatabaseTest {

    Database database = new Database();
    @Test
    public void testAvailableBuns(){
        List<Bun> actual = database.availableBuns();
        assertNotNull("Нет доступных булок в базе данных.", actual);
    }

    @Test
    public void testAvailableIngredients(){
        List<Ingredient> actual = database.availableIngredients();
        assertNotNull("Нет доступных ингредиентов в базе данных.", actual);
    }
}

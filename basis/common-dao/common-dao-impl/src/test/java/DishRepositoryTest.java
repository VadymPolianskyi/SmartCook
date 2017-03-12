import com.polyanski.common.dao.api.entities.DishEntity;
import com.polyanski.common.dao.api.entities.IngredientEntity;
import com.polyanski.common.dao.impl.configuration.CommonDaoAppCfg;
import com.polyanski.common.dao.impl.repositories.DishRepository;
import com.polyanski.common.dao.impl.repositories.IngredientRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {CommonDaoAppCfg.class})
public class DishRepositoryTest {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    private int id;

    @Before
    public void setUp() throws Exception {
        DishEntity dishEntity= new DishEntity();
        DishEntity dishEntity1= new DishEntity();

        dishEntity.setDishName("someDish");
        dishEntity1.setDishName("someDish1");

        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setIngredient("ingredient");
        ingredientEntity.setPortion("100");

        IngredientEntity ingredientEntity1 = new IngredientEntity();
        ingredientEntity1.setIngredient("ingredient1");
        ingredientEntity1.setPortion("101");

        dishRepository.save(dishEntity);
        dishRepository.save(dishEntity1);

        ingredientRepository.save(ingredientEntity);
        ingredientRepository.save(ingredientEntity1);

        dishEntity.setIngredientEntities(Arrays.asList(ingredientEntity));
        dishEntity1.setIngredientEntities(Arrays.asList(ingredientEntity1));
        dishEntity.setImgName("fdfd");
        dishEntity1.setImgName("fdfd");


        dishRepository.save(dishEntity);
        dishRepository.save(dishEntity1);
        assertNotNull(dishEntity.getId());
        assertNotNull(dishEntity1.getId());

        this.id = dishEntity.getId();
    }

    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        DishEntity dishEntity = dishRepository.findOne( this.id);
        assertNotNull(dishEntity);
        assertEquals("fdfd", dishEntity.getImgName());

        IngredientEntity ingredient = dishEntity.getIngredientEntities().get(0);

        assertNotNull(ingredient);
    }
}

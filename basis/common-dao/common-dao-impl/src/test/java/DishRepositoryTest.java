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

    private String id;

    @Before
    public void setUp() throws Exception {
        DishEntity dishEntity= new DishEntity();
        DishEntity dishEntity1= new DishEntity();

        dishEntity.setDishName("Пирожки");
        dishEntity.setRefference("ffi03fsd.com");
        dishEntity.setImgName("foiwefs4092ksjd.jpg");
        dishEntity1.setDishName("равіолі");
        dishEntity1.setRefference("hgfe3493kf.com");
        dishEntity1.setImgName("fhjdshf2fh82e9wf9hf.jpg");

//        IngredientEntity ingredientEntity = new IngredientEntity();
//        ingredientEntity.setIngredient("ingredient");
//        ingredientEntity.setPortion("100");
//
//        IngredientEntity ingredientEntity1 = new IngredientEntity();
//        ingredientEntity1.setIngredient("ingredient1");
//        ingredientEntity1.setPortion("101");

        dishRepository.save(dishEntity);
        dishRepository.save(dishEntity1);

//        ingredientRepository.save(ingredientEntity);
//        ingredientRepository.save(ingredientEntity1);

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
        DishEntity dishEntity = dishRepository.findById(this.id);
        assertNotNull(dishEntity);
        assertEquals("fdfd", dishEntity.getImgName());

    }
}

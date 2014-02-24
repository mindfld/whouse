import org.junit.Test;
import ua.mind.warehouse.domain.entities.storage.Category;
import ua.mind.warehouse.domain.entities.storage.Commodity;
import ua.mind.warehouse.domain.entities.storage.MeasurementUnit;
import ua.mind.warehouse.persistance.dao.CommodityDao;
import ua.mind.warehouse.persistance.dao.impl.JPACommodityDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергій on 20.02.14.
 */
public class CommodityDaoTest {

    CommodityDao commodityDao = new JPACommodityDao();

    @Test
    public void testCategoryCreate(){
        Category category = new Category();
        category.setName("TestCategory");
        Commodity commodity = new Commodity();
        commodity.setMeasurementUnit(MeasurementUnit.pcs);
        commodity.setDescription("This is simply test commodity");
        commodity.setName("TestItem1");
        commodity.setCategory(category);

        List<Commodity> items = new ArrayList<Commodity>();
        items.add(commodity);
        category.setCommodityList(items);
        commodityDao.addCategory(category);
    }
}

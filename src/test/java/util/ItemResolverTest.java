package util;

import exceptions.ItemDoesntExistException;
import model.Item;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ItemResolverTest {

    @Test
    public void itemsResolve_ok() throws Exception{
        String[] itemNames = new String[]{"Apples", "Apples", "Soup", "Soup", "Milk", "Bread"};
        List<Item> items = ItemResolver.resolveItemsFromCommandLine(itemNames);

        Assert.assertEquals(6, items.size());
    }

    @Test(expected = ItemDoesntExistException.class)
    public void itemsResolve_wrongNames() throws Exception{
        String[] itemNames = new String[]{"Apples", "banana"};
        ItemResolver.resolveItemsFromCommandLine(itemNames);
    }
}

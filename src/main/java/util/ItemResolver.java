package util;

import exceptions.ItemDoesntExistException;
import model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemResolver {
    public static List<Item> resolveItemsFromCommandLine(String[] itemNames) throws ItemDoesntExistException {
        List<Item> items = new ArrayList<>();

        for(String name : itemNames){
            Item item = Item.getByName(name);

            if (item == null){
                throw new ItemDoesntExistException(name);
            }

            items.add(item);
        }

        return items;
    }
}

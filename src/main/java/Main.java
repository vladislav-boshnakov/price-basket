import exceptions.ItemDoesntExistException;
import model.Basket;
import model.Item;
import util.ItemResolver;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){

        if(args.length < 1){
            System.out.println("You need to provide a list of items for the basket.");
            System.exit(0);
        }

        try {
            List<Item> itemsInBasket = ItemResolver.resolveItemsFromCommandLine(args);
            Basket b = new Basket(itemsInBasket);
            System.out.println(b.toString());
        }catch (ItemDoesntExistException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}

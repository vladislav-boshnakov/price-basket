package exceptions;

public class ItemDoesntExistException extends Exception {

    public ItemDoesntExistException(String itemName){
        super(String.format("Invalid item type: %s.", itemName));
    }
}

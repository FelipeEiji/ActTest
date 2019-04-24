package actjavadeveloperpracticum;

import java.util.HashMap;

/**
 * Menu that stores the dishes that can be served to the customer.
 * 
 * @author Felipe
 */
public class Menu {
    
    private HashMap<Integer, Dish> servedDishes = new HashMap<>();

    /**
     * Add dishes to the menu.
     * If a dish from a certain type already exist in the menu,
     * it will be replaced by the new one.
     * @param newDish 
     */
    public void addDish(Dish newDish)
    {
        Dish.Type type = newDish.getType();
        switch(type)
        {
            case ENTREE:
                if(servedDishes.get(1) == null)
                    servedDishes.put(1, newDish);
                else
                    servedDishes.replace(1, newDish);
                break;
                
            case SIDE:
                if(servedDishes.get(2) == null)
                    servedDishes.put(2, newDish);
                else
                    servedDishes.replace(2, newDish);
                break;
                
            case DRINK:
                if(servedDishes.get(3) == null)
                    servedDishes.put(3, newDish);
                else
                    servedDishes.replace(3, newDish);
                break;
                
            case DESSERT:
                if(servedDishes.get(4) == null)
                    servedDishes.put(4, newDish);
                else
                    servedDishes.replace(4, newDish);
                break;
        }
    }
    
    /**
     * Return a dish by key
     * @param dishKey
     * @return dish from the menu
     */
    public Dish getDish(int dishKey)
    {
        return servedDishes.get(dishKey);
    }
}

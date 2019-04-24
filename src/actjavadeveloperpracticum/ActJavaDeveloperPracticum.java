package actjavadeveloperpracticum;

import java.util.Scanner;

/**
 *
 * @author Felipe
 */
public class ActJavaDeveloperPracticum {

    public static void main(String[] args) {
        Menu currentMenu = null;
        Menu morningMenu = new Menu();
        Menu nightMenu = new Menu();
        String[] orderInput;
        Scanner scanner = new Scanner(System.in);
        
        //Creating dishes and setting up the menus.
        morningMenu.addDish(new Dish("eggs", false, Dish.Type.ENTREE));
        morningMenu.addDish(new Dish("toast", false, Dish.Type.SIDE));
        morningMenu.addDish(new Dish("coffee", true, Dish.Type.DRINK));
        nightMenu.addDish(new Dish("steak", false, Dish.Type.ENTREE));
        nightMenu.addDish(new Dish("potato", true, Dish.Type.SIDE));
        nightMenu.addDish(new Dish("wine", false, Dish.Type.DRINK));
        nightMenu.addDish(new Dish("cake", false, Dish.Type.DESSERT));
        
        //Receiving the order by user input.
        String consoleInput = scanner.nextLine().replace(" ", "");
        orderInput = consoleInput.split(",");
        orderInput[0] = orderInput[0].toLowerCase();
        
        if(orderInput[0].equals("morning"))
            currentMenu = morningMenu;
         else if(orderInput[0].equals("night"))
            currentMenu = nightMenu;
         
        //Creating object Order to manage the customer order.
        Order order = new Order(currentMenu);
            
        //Passing the customer order to Order object.
        for(int i = 1; i<orderInput.length; i++)
        {
            if(!order.receiveOrder(Integer.parseInt(orderInput[i])))
                break;
        }
        
        System.out.println(order);
    }
    
}

package actjavadeveloperpracticum;

import java.util.HashMap;

/**
 * Responsible for taking customer orders.
 *
 * @author Felipe
 */
public class Order {

    /**
     * The menu on which the order is based.
     */
    private final Menu menu;

    /**
     * Store the orders received from the customer.
     */
    private HashMap<Integer, Integer> receivedOrder = new HashMap<>();

    /**
     * If a given order is not found in the menu, this variable will shift to
     * true.
     */
    private boolean error;

    public Order(Menu menu) {
        this.menu = menu;
        this.error = false;
    }

    /**
     * Receive an int to
     *
     * @param dishNumber
     * @return
     */
    public boolean receiveOrder(int dishNumber) {
        Dish dish = menu.getDish(dishNumber);
        if (dish != null) {
            if (receivedOrder.get(dishNumber) != null) {
                if (dish.isRepeatable()) {
                    Integer value = receivedOrder.get(dishNumber);
                    receivedOrder.replace(dishNumber, value + 1);
                } else {
                    error = true;
                    return false;
                }
            } else {
                receivedOrder.put(dishNumber, 1);
            }
        } else {
            error = true;
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String orderAsString = "";
        boolean firstIteration = true;

        for (HashMap.Entry<Integer, Integer> entry : receivedOrder.entrySet()) {
            if (entry.getValue() == 1) {
                if (firstIteration) {
                    orderAsString += menu.getDish(entry.getKey()).getName();
                    firstIteration = false;
                } else {
                    orderAsString += ", ";
                    orderAsString += menu.getDish(entry.getKey()).getName();
                }
            } else {
                if (firstIteration) {
                    orderAsString += menu.getDish(entry.getKey()).getName() + "(x" + entry.getValue().toString() + ')';
                    firstIteration = false;
                } else {
                    orderAsString += ", ";
                    orderAsString += menu.getDish(entry.getKey()).getName() + "(x" + entry.getValue().toString() + ')';
                }
            }
        }

        if (error) {
            if (firstIteration) {
                orderAsString += "error";
            } else {
                orderAsString += ", error";
            }
        }

        return orderAsString;
    }

}

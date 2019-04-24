package actjavadeveloperpracticum;

/**
 * Represent the dishes.
 * @author Felipe
 */
public class Dish {
    
    public enum Type{ENTREE, SIDE, DRINK, DESSERT;}
    
    private final String name;
    private final Type type;
    /**
     * Tell if the dish can be ordered multiple times.
     */
    private final boolean repeatable;
    
    public Dish(String name, boolean repeatable, Type type)
    {
        this.name = name;
        this.repeatable = repeatable;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    
    public boolean isRepeatable() {
        return repeatable;
    }

    public Type getType() {
        return type;
    }
    
    
}

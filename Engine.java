import java.io.Serializable;
import java.util.LinkedList;
public class Engine implements Serializable {
    private double size;
    private int cylinders;
    private int horsepower;

    LinkedList<String> errors = new LinkedList<>();

    //a constructor to initializes the engine
    public Engine(double size, int cylinders, int HP) throws EngineExceptions {
        setSize(size);
        setCylinders(cylinders);
        setHP(HP);
        if (!errors.isEmpty()) throw new EngineExceptions(errors);
    }

    //getters and setters:
    
    public double getSize() {return size;}

    public void setSize(double s) {
         if (s < 1 || s > 10) errors.add("Size must be a number between 1 and 10.");
         size = s;
    }

    public int getCylinders() {return cylinders;}

    public void setCylinders(int c) {
        if (c < 4 || c > 16) errors.add("Cylinders must be a number between 4 and 16.");
        cylinders = c;
    }

    public int getHP() {return horsepower;}
    
    public void setHP(int hp) {
        if (hp < 50 || hp > 2000) errors.add("Horsepower must be a number between 50 and 2000.");
        horsepower = hp;
    }
}

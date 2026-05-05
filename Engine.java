import java.io.Serializable;
public class Engine implements Serializable {
    private double size;
    private int cylinders;
    private int horsepower;

    //a constructor to initializes the engine
    public Engine(double size, int cylinders, int HP, LinkedList<String> errors)  {
        setSize(size, errors);
        setCylinders(cylinders, errors);
        setHP(HP, errors);
    }

    //getters and setters:
    
    public double getSize() {return size;}

    private void setSize(double s, LinkedList<String> errors) {
         if (s < 1 || s > 10) errors.addLast("Size must be a number between 1 and 10.");
         else
         size = s;
    }

    public int getCylinders() {return cylinders;}

    private void setCylinders(int c, LinkedList<String> errors) {
        if (c < 4 || c > 16) errors.addLast("Cylinders must be a number between 4 and 16.");
        else
        cylinders = c;
    }

    public int getHP() {return horsepower;}
    
    private void setHP(int hp, LinkedList<String> errors) {
        if (hp < 50 || hp > 2000) errors.addLast("Horsepower must be a number between 50 and 2000.");
        else
        horsepower = hp;
    }
}

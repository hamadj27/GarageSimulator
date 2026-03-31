public class Engine {
    private double size;
    private int cylinders;
    private int horsepower;

    //a constructor to initializes the engine
    public Engine(double size, int cylinders, int HP) {
        setSize(size);
        setCylinders(cylinders);
        setHP(HP);
    }

    //getters and setters:
    
    public double getSize() {return size;}

    public void setSize(double s) {
        if (s < 1 && s > 10) throw new IllegalArgumentException("Size must be a number between 1 and 10.");
        else size = s;
    }

    public int getCylinders() {return cylinders;}

    public void setCylinders(int c) {
        if (c < 4 && c > 16) throw new IllegalArgumentException("Cylinders must be a number between 4 and 16.");
        else cylinders = c;
    }

    public int getHP() {return horsepower;}
    
    public void setHP(int hp) {
        if (hp < 50 && hp > 2000) throw new IllegalArgumentException("Horsepower must be a number between 50 and 2000.");
        else horsepower = hp;
    }
}

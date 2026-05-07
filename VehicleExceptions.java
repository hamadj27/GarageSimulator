// exception carrying one or more vehicle validation errors
public class VehicleExceptions extends RuntimeException {
    private LinkedList<String> errors;
    public VehicleExceptions(LinkedList<String> errors) {
        this.errors = errors;
    }
    public VehicleExceptions(String msg) {super(msg);}

    public LinkedList<String> getErrors() {
        return errors;
    }
}
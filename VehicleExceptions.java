public class VehicleExceptions extends RuntimeException {
    private LinkedList<String> errors;
    public VehicleExceptions(LinkedList<String> errors) {
        this.errors = errors;
    }

    public LinkedList<String> getErrors() {
        return errors;
    }
}
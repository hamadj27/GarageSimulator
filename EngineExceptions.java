import java.util.LinkedList;
public class EngineExceptions extends RuntimeException {
    private LinkedList<String> errors;
    public EngineExceptions(LinkedList<String> errors) {
        this.errors = errors;
    }

    public LinkedList<String> getErrors() {
        return errors;
    }
}
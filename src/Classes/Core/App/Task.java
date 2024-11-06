package Classes.Core.App;

public class Task {
    private final int id;
    private final String message;
    
    public Task(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}

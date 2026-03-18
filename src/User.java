import java.time.LocalDateTime;
import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String email;

    protected long createdAt;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt=System.currentTimeMillis();
    }
}

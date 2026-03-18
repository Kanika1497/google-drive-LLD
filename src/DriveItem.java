import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public abstract class DriveItem {
    protected String id;
    protected String name;
    protected User owner;
    protected Folder parent; // this is for composite design pattern where
    // system will see the file and folder as same thing

    protected long createdAt;

    public abstract int getSize();

    public DriveItem(String id, String name, User owner) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.createdAt = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public Folder getParent() {
        return parent;
    }
}

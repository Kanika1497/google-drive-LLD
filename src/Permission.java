public class Permission {
    private User user;
    private PermissionType type;

    public Permission(User user, PermissionType type) {
        this.user = user;
        this.type = type;
    }
}

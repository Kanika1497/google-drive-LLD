public class ShareLink {
    private String token;
    private DriveItem item;
    private long expiryTime;
    private PermissionType permission;

    public ShareLink(String token, DriveItem item, long expiryTime, PermissionType permission) {
        this.token = token;
        this.item = item;
        this.expiryTime = expiryTime;
        this.permission = permission;
    }

    public String getToken() {
        return token;
    }

    public DriveItem getItem() {
        return item;
    }

    public long getExpiryTime() {
        return expiryTime;
    }

    public PermissionType getPermission() {
        return permission;
    }
}

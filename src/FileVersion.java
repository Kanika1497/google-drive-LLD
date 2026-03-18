public class FileVersion {
    public String id;
    public String storageUrl;
    public int size;
    public long createdAt;

    public FileVersion(String id, String storageUrl, int size) {
        this.id = id;
        this.storageUrl = storageUrl;
        this.size = size;
        this.createdAt =System.currentTimeMillis();
    }


    public int getSize(){
        return size;
    }

    public String getStorageUrl(){
        return storageUrl;
    }





}

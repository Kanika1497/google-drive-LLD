import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class S3StorageService implements StorageService{

    private final Map<String ,byte[]> s3store=new HashMap<>();

    private final String bucketUrl = "https://s3.amazonaws.com/google-drive/";
    @Override
    public String upload(byte[] data,String fileName) {
        String fileId = UUID.randomUUID().toString();
        String fileUrl= bucketUrl+fileId+" - "+fileName;
        s3store.put(fileUrl,data);
        System.out.println("File uploaded to S3: " + fileUrl);
        return fileUrl;
    }
    @Override
    public byte[] download(String url) {
        if (!s3store.containsKey(url)) {
            throw new RuntimeException("File not found in S3");
        }

        System.out.println("Downloading file from S3: " + url);
         return s3store.get(url);

    }

    @Override
    public void delete(String url) {
        if (!s3store.containsKey(url)) {
            throw new RuntimeException("File not found in S3");
        }
        s3store.remove(url);
        System.out.println("Deleting file from S3: " + url);
    }
}

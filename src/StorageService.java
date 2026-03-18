public interface StorageService {
    public String upload(byte[] data, String filename);
    public byte[] download(String url);
    public void delete(String url);

}

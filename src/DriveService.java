import java.util.*;

public class DriveService {
        //upload file
        //create folder
        //delete file/folder
        //shareItem
   private StorageService storageService;
   private Map<String,DriveItem> items=new HashMap<>();
   private Map<String,ShareLink> shareLinks=new HashMap<>();
   private Map<String, List<Permission>> permissionMap=new HashMap<>();
    public DriveService(StorageService storageService) {
        this.storageService = storageService;
    }

    public File uploadFile(User user , Folder parent , byte [] data , String filename){
       String storageUrl= storageService.upload(data,filename);
       FileVersion version=new FileVersion(UUID.randomUUID().toString(),storageUrl,data.length);
       File file=new File(UUID.randomUUID().toString(),filename,user);
       file.addFileVersion(version);
       parent.addItem(file);
       items.put(file.getId(),file);

       return file;

    }

    public Folder createFolder(User user , Folder parent, String foldername){
        Folder folder = new Folder(UUID.randomUUID().toString(),foldername,user);

        if(parent !=null){
            parent.addItem(folder);
        }
        items.put(folder.getId(),folder);
        return folder;
    }

    public byte[] downloadFile(File file){
        FileVersion latest=file.getLatestFileVersion();

        return storageService.download(latest.getStorageUrl());

    }

    public void deleteItem(Folder parent , DriveItem item ){
        parent.removeItem(item);
        items.remove(item.getId());

        if(item instanceof File){
            File file=(File) item;

            for(FileVersion version : file.getFileVersions()){
                storageService.delete(version.getStorageUrl());
            }
        }
    }

    public ShareLink createShareLink(DriveItem item , long expiryTime){
        String token=UUID.randomUUID().toString();

        ShareLink link = new ShareLink(token, item , expiryTime, PermissionType.READ);

        shareLinks.put(token,link);
        return link;
    }

    public void shareItem(DriveItem item,User user , PermissionType type){
        Permission permission =new Permission(user ,type);

        permissionMap.computeIfAbsent(item.getId(), k-> new ArrayList<>()).add(permission);
    }

    public void printFolderStructure(Folder folder,int level){
        for(DriveItem child : folder.getChildren()){
            for(int i=0;i<level;i++){
                System.out.println(" ");
            }
            System.out.println("- " + child.getName());
            if(child instanceof Folder){
                printFolderStructure((Folder) child,level+1);
            }
        }
    }




}

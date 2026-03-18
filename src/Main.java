// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        StorageService storageService = new S3StorageService();

        DriveService driveService = new DriveService(storageService);

        User user = new User("1", "Kanika", "kanika@gmail.com");

        // create root folder
        Folder root = driveService.createFolder(user, null, "root");

        // create sub folder
        Folder docs = driveService.createFolder(user, root, "documents");


        // upload file
        File file1 = driveService.uploadFile(
                user,
                docs,
                "My Resume".getBytes(),
                "resume.pdf"

        );

        // upload another file
        File file2 = driveService.uploadFile(
                user,
                docs,
                "Interview notes".getBytes(),
                "notes.txt"

        );

        // share file
        driveService.shareItem(file1, user, PermissionType.READ);

        // create share link
        ShareLink link = driveService.createShareLink(
                file1,
                System.currentTimeMillis() + 86400000
        );

        System.out.println("Share link token: " + link.getToken());

        // download file
        byte[] downloaded = driveService.downloadFile(file1);

        System.out.println("Downloaded content: " + new String(downloaded));

        // print folder structure
        System.out.println("\nFolder Structure:");
        driveService.printFolderStructure(root, 1);
    }
}
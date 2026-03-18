import java.util.ArrayList;
import java.util.List;

public class File extends DriveItem{
    private final List<FileVersion> versions=new ArrayList<>();

    public File( String id ,String name, User owner) {
        super(id, name,owner);
    }

    public void addFileVersion(FileVersion version){
        versions.add(version);
    }

    public List<FileVersion> getFileVersions(){
        return versions;
    }

    public FileVersion getLatestFileVersion(){
        return versions.get(versions.size()-1);
    }
    @Override
    public int getSize() {
        return getLatestFileVersion().getSize();
    }


}

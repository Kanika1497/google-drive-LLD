import java.util.ArrayList;
import java.util.List;

public class Folder extends DriveItem {

    public List<DriveItem> children =new ArrayList<>();
    public Folder(String id, String name, User owner) {
        super(id, name, owner);
    }

    @Override
    public int getSize() {
        int totalsize=0;
        for(DriveItem item : children){
            totalsize+=item.getSize();
        }
        return totalsize;
    }

    public void addItem(DriveItem item){
        children.add(item);
    }
    public void removeItem(DriveItem item){
        children.remove(item);
    }
    public List<DriveItem> getChildren(){
        return children;
    }

}

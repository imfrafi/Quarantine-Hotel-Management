import java.util.ArrayList;

public class NeedList {
    private ArrayList<Need> needList;

    public NeedList(){
        needList = new ArrayList<>();
    }

    public ArrayList<Need> getNeedList(){
        return needList;
    }

    public String getInfo(){
        String info="";
        for( Need need: needList ){
            info += need.getInfo();
        }
        info += String .format( "\n" );
        return info;
    }
}

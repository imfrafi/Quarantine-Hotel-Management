import java.util.ArrayList;

public class WorkerList {
    private ArrayList<Worker> workerList;
    private String departmentName;

    public WorkerList( String departmentName ){
        this.departmentName = departmentName;
        workerList = new ArrayList<>();
    }

    public String getDepartmentName(){
        return departmentName;
    }
    public ArrayList<Worker> getWorkerList(){
        return workerList;
    }

    public void addWorker( Worker worker ){
        workerList.add( worker );
    }
}

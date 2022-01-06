public class Worker extends Person {
    private  String department;
    private boolean vaccinated;
    private int workerID;

    public Worker( String name, int workerID, String department, boolean vaccinated){
        super( name );
        this.department = department;
        this.workerID = workerID;
        this.vaccinated = vaccinated;
    }

    public int getWorkerID(){
        return workerID;
    }
    public String getDepartment(){
        return department;  
    }
    public boolean getVaccinated(){
        return vaccinated;
    }
    
    public String getInfo(){
        String info = "Name: " + name + ", ID: " + workerID + ", Vaccinated: " + vaccinated + "\n";
        return info;
    }
}

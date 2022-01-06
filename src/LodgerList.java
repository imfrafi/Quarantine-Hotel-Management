import java.util.ArrayList;

public class LodgerList {
	private ArrayList<Lodger> lodgerList;

	public LodgerList() {
		lodgerList = new ArrayList<>();
	}

	public ArrayList<Lodger> getLodgerList() {
		return lodgerList;
	}

	public void addLodger(Lodger lodger) {
		lodgerList.add(lodger);
	}
	
	public void checkOut(Lodger lodger) {
		lodgerList.remove(lodger);
	}

	public String getInfo() {
		String info="";
		for(Lodger lodger:lodgerList) {
			info+=lodger.getInfo();
		}
		info+="\n";
		return info;
	}
}

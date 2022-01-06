import java.util.ArrayList;

public class Hotel {
	private String hotelName, address, hospitalName;
	private ArrayList<String> roomnumber, waitingCleaningRoom;
	private LodgerList l;
	private OrderList orderList;
	private NeedList needList;
	private ArrayList<WorkerList> departments;

	public Hotel(String hotelName, String address, String hospitalName) {
		this.hotelName = hotelName;
		this.address = address;
		this.hospitalName = hospitalName;
		roomnumber = new ArrayList<>();
		waitingCleaningRoom = new ArrayList<>();
		l = new LodgerList();
		orderList = new OrderList();
		needList = new NeedList();

		departments = new ArrayList<>();
		WorkerList cleaning = new WorkerList("cleaning");
		WorkerList service = new WorkerList("service");
		WorkerList f_b = new WorkerList("f&b");
		WorkerList fin = new WorkerList("finance");
		departments.add(cleaning);
		departments.add(service);
		departments.add(f_b);
		departments.add(fin);
		String str = "";
		for (int i = 1; i <= 9; i++) {
			for (int k = 1; k <= 15; k++) {
				if (k < 10) {
					String num = String.valueOf(i);
					str = num + 0 + k;
				} else {
					String num = String.valueOf(i);
					str = num + k;
				}
				roomnumber.add(str);
			}
		}

	}

	public String getHotelName() {
		return hotelName;
	}

	public String getAddress() {
		return address;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public WorkerList getCleaningList() {
		return departments.get(0);
	}

	public WorkerList getServiceList() {
		return departments.get(1);
	}

	public WorkerList getF_BList() {
		return departments.get(2);
	}

	public WorkerList getFinList() {
		return departments.get(3);
	}

	public ArrayList<String> getRoomNumberList() {
		return roomnumber;
	}

	public ArrayList<String> getWaitingCleaningRoom(){
		return waitingCleaningRoom;
	}

	public LodgerList getLodgerList() {
		return l;
	}

	public OrderList getOrderList() {
		return orderList;
	}

	public NeedList getNeedList() {
		return needList;
	}

	public ArrayList<String> getRoomNumber() {
		return roomnumber;
	}

	public String getInfo() {
		String info = "";
		for (WorkerList workerList : departments) {
			if (workerList.getWorkerList().size() > 0) {
				info += String.format(workerList.getDepartmentName() + ":\n");
				for (Worker worker : workerList.getWorkerList()) {
					info += String.format(worker.getInfo() + "\n");
				}
			}
		}
		return info;
	}

}

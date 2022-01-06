
public class Lodger extends Person {
	private String taxinumber;
	private String country;
	private String roomnumber;

	public Lodger(String name, String taxinumber, String country, String roomnumber) {
		super(name);
		this.taxinumber = taxinumber;
		this.country = country;
		this.roomnumber = roomnumber;
	}

	public String getCountry() {
		return country;
	}

	public String getTaxinumber() {
		return taxinumber;
	}

	public String getRoom() {
		return this.roomnumber;
	}

	public String getInfo() {

		String str = String.format("Name:%s\nROOM:%s \nThe taxi lodger took:%s\n\n", this.name, this.roomnumber, this.taxinumber);
		return str;

	}

}

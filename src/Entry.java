import java.util.*;

public class Entry {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HotelList hotelList = new HotelList();
		String hotelName, address, hospitalName;

		while (true) {

			// Enter the hotel, and check whether it's existed or not
			System.out.println("Please enter the hotel name: (q for quit, i for info)");
			hotelName = sc.nextLine();
			if (hotelName.equals("q"))
				break;

			if (hotelName.equals("i")) {
				System.out.println(hotelList.getInfo());
			}

			else {
				boolean newOne = true;
				for (Hotel hotel : hotelList.getHotelList()) {
					if (hotel.getHotelName().equals(hotelName)) {
						newOne = false;
						break;
					}
				}
				if (newOne) {
					System.out.println("Please enter the address of the hotel: ");
					address = sc.nextLine();
					System.out.println("Please enter the emergent hospital name of the hotel: ");
					hospitalName = sc.nextLine();
					System.out.println("Are you sure to register a new hotel with the information: ");
					System.out.println("Hotel: " + hotelName + "\nAddress: " + address + "\nEmergent Hospital: "
							+ hospitalName + "\n(y/n)");
					String YN = sc.nextLine();
					if (YN.toLowerCase().equals("y")) {
						Hotel hotel = new Hotel(hotelName, address, hospitalName);
						hotelList.addHotel(hotel);
					}
				}

				// worker register
				System.out.println("Are you the registered worker in " + hotelName + "? (y/n)");
				String YN = sc.nextLine();
				String department, workerName;
				int workerID;
				boolean vaccinated=false;
				System.out.println("Please enter the department: \n (service/cleaning/f&b/finance)");
				department = sc.nextLine();
				department = department.trim().toLowerCase();
				System.out.println("Please enter your name: ");
				workerName = sc.nextLine();
				System.out.println("Please enter your ID: ");
				workerID = Integer.parseInt(sc.nextLine());
				if( YN.toLowerCase().equals("n") ){
					System.out.println("Have you ever been vaccinated? (y/n)");
					String yn = sc.nextLine();
					if (yn.toLowerCase().equals("y")){
						vaccinated = true;
					}else{
						vaccinated = false;
					}
				}
				


				if (YN.toLowerCase().equals("n")) {
					Worker worker = new Worker(workerName, workerID, department, vaccinated);

					if (department.equals("cleaning")) {
						for (Hotel hotel : hotelList.getHotelList()) {
							if (hotel.getHotelName().equals(hotelName)) {
								hotel.getCleaningList().addWorker(worker);
							}
						}
					} else if (department.equals("service")) {
						for (Hotel hotel : hotelList.getHotelList()) {
							if (hotel.getHotelName().equals(hotelName)) {
								hotel.getServiceList().addWorker(worker);
							}
						}
					} else if (department.equals("f&b")) {
						for (Hotel hotel : hotelList.getHotelList()) {
							if (hotel.getHotelName().equals(hotelName)) {
								hotel.getF_BList().addWorker(worker);
							}
						}
					} else if (department.equals("finance")) {
						for (Hotel hotel : hotelList.getHotelList()) {
							if (hotel.getHotelName().equals(hotelName)) {
								hotel.getFinList().addWorker(worker);
							}
						}
					}
				}

				// worker after log in
				for (int i = 0; i < hotelList.getHotelList().size(); i++) {
					if (hotelList.getHotelList().get(i).getHotelName().equals(hotelName)) {// i=hotel;
						String lodgerName, country, taxiNumber;
						if (department.equals("service")) {
							System.out.printf("Please enter the lodger's information:(i for info)\n");
							System.out.printf("Name:");
							lodgerName = sc.nextLine();
							boolean flag = true;
							if(lodgerName.equals("i")) {
								flag = false;
								System.out.print(hotelList.getHotelList().get(i).getLodgerList().getInfo());
							}
							if( flag ){
								System.out.printf("Country:");
								country = sc.nextLine();
								System.out.printf("Taxi Number:");
								taxiNumber = sc.nextLine();

								String result = "";
								for (int k = 0; k < 3; k++) {
									result += hotelList.getHotelList().get(i).getRoomNumber().get(
											(int) (Math.random() * (hotelList.getHotelList().get(i).getRoomNumber().size())) )
											+ " ";
								}
								System.out.printf("You can choose among these three roomnumbers: %s\n", result);
								String choice = sc.nextLine();
								hotelList.getHotelList().get(i).getRoomNumber().remove(choice);
								hotelList.getHotelList().get(i).getWaitingCleaningRoom().add(choice);
								System.out.println("Are you sure to check in the lodger with the information?: ");
								System.out.println("Lodger Name: " + lodgerName + "\nCountry: " + country
										+ "\nTaxi Number: " + taxiNumber + "\nRoom number: " + choice + "\n(y/n)");
								YN = sc.nextLine();
								if (YN.toLowerCase().equals("y")) {
									Lodger lodger = new Lodger(lodgerName, country, taxiNumber, choice);
									hotelList.getHotelList().get(i).getLodgerList().getLodgerList().add(lodger);
								}
							}
						}

						if (department.equals("cleaning")){
							System.out.println( "Below is the rooms that need cleaning: " );
							for( String str: hotelList.getHotelList().get(i).getWaitingCleaningRoom() ){
								System.out.printf( "%s\n",str );
							}
							String choice = sc.nextLine();
							hotelList.getHotelList().get(i).getWaitingCleaningRoom().remove(choice);
							hotelList.getHotelList().get(i).getRoomNumber().add(choice);
						}

						String itemName;
						int itemAmount;

						if (department.equals("f&b")){
							System.out.println( "Please enter the order: ");
							System.out.print( "Item Name: (i for info)" );
							itemName = sc.nextLine();
							boolean flag = true;
							if(itemName.equals("i")) {
								flag = false;
								System.out.print(hotelList.getHotelList().get(i).getOrderList().getInfo());
							}
							if( flag ){
								System.out.print( "Amount: ");
								itemAmount = sc.nextInt();
								Order order = new Order( itemName, itemAmount );
								System.out.printf( "Are you sure to add a new order with the information?: \n%s(y/n)\n", order.getInfo());
								String yn = sc.nextLine();
								if (yn.toLowerCase().equals("y")){
									hotelList.getHotelList().get(i).getOrderList().getOrderList().add(order);
								}
							}
						}

						if (department.equals("finance")){
							System.out.println( "Please enter the need: ");
							System.out.print( "Item Name: (i for info)" );
							itemName = sc.nextLine();
							boolean flag = true;
							if(itemName.equals("i")) {
								flag = false;
								System.out.print(hotelList.getHotelList().get(i).getNeedList().getInfo());
							}
							if( flag ){
								System.out.print( "Amount: ");
								itemAmount = sc.nextInt();
								Need need = new Need( itemName, itemAmount );
								System.out.printf( "Are you sure to add a new need with the information?: \n%s(y/n)\n", need.getInfo());
								String yn = sc.nextLine();
								if (yn.toLowerCase().equals("y")){
									hotelList.getHotelList().get(i).getNeedList().getNeedList().add(need);
								}
							}
						}
					}
				}

			}

		}

		sc.close();
	}

}

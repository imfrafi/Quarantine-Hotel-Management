import java.util.ArrayList;

public class HotelList {
    private ArrayList<Hotel> hotelList;

    public HotelList(){
        hotelList = new ArrayList<>(); 
    }

    public ArrayList<Hotel> getHotelList(){
        return hotelList;
    }

    public void addHotel( Hotel hotel ){
        hotelList.add( hotel );
    }
    
    public String getInfo(){
        String info="";
        int i = 0;
        for( Hotel hotel: hotelList ){
            info += String.format( (++i) + ". " + hotel.getHotelName() + ": " + hotel.getAddress() + ". The emergent hospital is: " + hotel.getHospitalName() + '\n' );
            info += hotel.getInfo();
        }
        return info;
    }

}

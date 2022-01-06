import java.util.ArrayList;

public class OrderList {
    private ArrayList<Order> orderList;

    public OrderList(){
        orderList = new ArrayList<>();
    }

    public ArrayList<Order> getOrderList(){
        return orderList;
    }

    public String getInfo(){
        String info="";
        for( Order order: orderList ){
            info += order.getInfo();
        }
        info += String .format( "\n" );
        return info;
    }
}

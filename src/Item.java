
public class Item {
    private String name;
    private int amount;

    public Item( String name, int amount ){
        this.name = name;
        this.amount = amount;
    }

    public String getInfo(){
        return String.format( "%s : %d\n", name, amount );
    }
}

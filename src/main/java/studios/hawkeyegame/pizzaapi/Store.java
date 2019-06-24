package studios.hawkeyegame.pizzaapi;

public class Store {

    private String id;
    private String address;
    private boolean isOpen;
    private boolean isDelivery;
    private boolean isCarryout;

    public Store(String id, String address, boolean isOpen, boolean isDelivery, boolean isCarryout) {
        this.id = id;
        this.address = address;
        this.isOpen = isOpen;
        this.isDelivery = isDelivery;
        this.isCarryout = isCarryout;
    }

    public void print() {
        System.out.println("Store ID: " + id);
        System.out.println("Address: \n" + address);
        System.out.println("Is Open: " + isOpen);
        System.out.println("Allow Delivery: " + isDelivery);
        System.out.println("Allow Carryout: " + isCarryout);
    }
}

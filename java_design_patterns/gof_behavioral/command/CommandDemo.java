package java_design_patterns.gof_behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    private String name;
    private int quantity;

    public Stock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void buy(){
        System.out.println("Stock [ Name: "+name+"," +
                " Quantity: " + quantity +" ] bought");
    }

    public void sell(){
        System.out.println("Stock [ Name: "+name+"," +
                " Quantity: " + quantity + " ] sold");
    }
}


public interface Order {
    void execute();
}

public class SellStock implements Order {
    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}

public class BuyStock implements Order {
    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}

public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void addOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){

        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}

public class CommandDemo {
    public static void main(String[] args) {

        Stock stock1 = new Stock("Google", 10);

        BuyStock buyStock = new BuyStock(stock1);
        SellStock sellStock = new SellStock(stock1);

        Broker broker = new Broker();

        broker.addOrder(buyStock);
        broker.addOrder(buyStock);
        broker.addOrder(sellStock);

        broker.placeOrders();

    }
}

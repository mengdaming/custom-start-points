import java.util.Enumeration;
import java.util.Vector;

class Customer {

    private final String name;
    private final Vector<Order> orders = new Vector<>();

    Customer(String name) {
        this.name = name;
    }

    void printOwing(double previousAmount) {
        Enumeration<Order> e = orders.elements();
        double outstanding = previousAmount * 1.2;

        // TODO 1 - Extract "print banner" as a separate function

        // print banner
        System.out.println("*************************");
        System.out.println("***** Customer Owes *****");
        System.out.println("*************************");

        // TODO 3 - Extract "calculate outstanding" as a separate function

        // calculate outstanding
        while (e.hasMoreElements()) {
            Order each = e.nextElement();
            outstanding += each.getAmount();
        }

        // TODO 2 - Extract "print details" as a separate function

        // print details
        System.out.println("name: " + name);
        System.out.println("amount: " + outstanding);
    }

    void order(String description, double amount) {
        this.orders.add(new Order(description, amount));
    }
}

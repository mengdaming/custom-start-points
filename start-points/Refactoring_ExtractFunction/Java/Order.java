class Order {

    private final double amount;
    private final String description;

    Order(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    String getDescription() {
        return this.description;
    }

    double getAmount() {
        return this.amount;
    }
}

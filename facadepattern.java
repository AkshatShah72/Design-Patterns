import java.util.Scanner;

class Product {
    public void getProductDetails() {
        System.out.println("Fetching the Product Details");
    }
}

class Invoice {
    public void sendInvoice() {
        System.out.println("Invoice Sent Successfully");
    }
}

class Payment {
    public void makePayment() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the amount to pay: ");
        double amount = input.nextDouble();
        System.out.println("Payment of " + amount + " processed successfully");
    }
}

class OrderFacade {
    private Product product;
    private Payment payment;
    private Invoice invoice;

    public OrderFacade() {
        this.product = new Product();
        this.payment = new Payment();
        this.invoice = new Invoice();
    }

    public void placeOrder() {
        System.out.println("Place Order Started");
        product.getProductDetails();
        payment.makePayment();
        invoice.sendInvoice();
        System.out.println("Order Placed Successfully");
    }
}

class Main {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        Scanner input = new Scanner(System.in);
        System.out.println("Press any key to place your order...");
        input.nextLine();
        orderFacade.placeOrder();
    }
}

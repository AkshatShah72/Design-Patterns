/* the PizzaTopping class represents the product being built using the Builder pattern. 
The PizzaTopping.Builder class is used to construct the PizzaTopping object, by allowing the user to add toppings to it using the addTopping() method. 
The build() method is used to return the final PizzaTopping object.

In the Main class, a Scanner object is used to read user input for the toppings they want on their pizza. 
The addTopping() method is called for each topping entered, and the loop continues until the user types "done". 
Finally, the PizzaTopping object is built using the build() method and its printToppings() method is called to display the chosen toppings.
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Pizza Topping class using Builder Pattern
class PizzaTopping {
    private final List<String> toppings;

    public static class Builder {
        private List<String> toppings = new ArrayList<String>();

        public Builder addTopping(String topping) {
            toppings.add(topping);
            return this;
        }

        public PizzaTopping build() {
            return new PizzaTopping(this);
        }
    }

    private PizzaTopping(Builder builder) {
        this.toppings = builder.toppings;
    }

    public void printToppings() {
        System.out.print("Toppings: ");
        for (String topping : toppings) {
            System.out.print(topping + " ");
        }
        
    }
}

// Driver class for testing
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PizzaTopping.Builder builder = new PizzaTopping.Builder();

        System.out.println("Enter the toppings you want on your pizza (type 'done' when finished):");
        while (true) {
            String topping = scanner.nextLine();
            if (topping.equals("done")) {
                break;
            }
            builder.addTopping(topping);
        }

        PizzaTopping pizzaTopping = builder.build();
        pizzaTopping.printToppings();
    }
}

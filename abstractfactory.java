/* the CakeFactory interface defines the abstract factory, which has a method createCake() that returns a Cake object. 
The ChocolateCakeFactory and VanillaCakeFactory are concrete factories that implement the CakeFactory interface and create ChocolateCake and VanillaCake objects respectively.

The Cake interface defines the abstract product, which has methods bake() and frost(). 
The ChocolateCake and VanillaCake classes are concrete products that implement the Cake interface.

The CakeClient is the client that uses the abstract factory and abstract product to create concrete objects. 
It takes user input to determine which concrete factory to use and then creates a cake object using that factory. The Cake object is then baked and frosted.
*/

import java.util.Scanner;

// Abstract Factory
interface CakeFactory {
    Cake createCake();
}

// Concrete Factories
class ChocolateCakeFactory implements CakeFactory {
    public Cake createCake() {
        return new ChocolateCake();
    }
}

class VanillaCakeFactory implements CakeFactory {
    public Cake createCake() {
        return new VanillaCake();
    }
}

// Abstract Product
interface Cake {
    void bake();
    void frost();
}

// Concrete Products
class ChocolateCake implements Cake {
    public void bake() {
        System.out.println("Baking chocolate cake...");
    }
    
    public void frost() {
        System.out.println("Frosting chocolate cake...");
    }
}

class VanillaCake implements Cake {
    public void bake() {
        System.out.println("Baking vanilla cake...");
    }
    
    public void frost() {
        System.out.println("Frosting vanilla cake...");
    }
}

// Client
class CakeClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What type of cake would you like? (1) Chocolate or (2) Vanilla?");
        int choice = scanner.nextInt();
        
        CakeFactory factory;
        if (choice == 1) {
            factory = new ChocolateCakeFactory();
        } else {
            factory = new VanillaCakeFactory();
        }
        
        Cake cake = factory.createCake();
        cake.bake();
        cake.frost();
    }
}

import java.util.*;
 
class FinanceManager {
    private static FinanceManager instance = null;
    private double balance;

    private FinanceManager() {
        // private constructor to prevent instantiation from outside the class
        balance = 0;
    }


    public static FinanceManager getInstance() {
        if (instance == null) {
            instance = new FinanceManager();
        }
        return instance;
    }

    public void addIncome(double amount) {
        balance += amount;
    }

    public void addExpense(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        FinanceManager financeManager = FinanceManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. Quit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter Income Amount:");
                double amount = scanner.nextDouble();
                financeManager.addIncome(amount);
            } else if (choice == 2) {
                System.out.println("Enter Expense Amount:");
                double amount = scanner.nextDouble();
                financeManager.addExpense(amount);
            } else if (choice == 3) {
                System.out.println("Balance: " + financeManager.getBalance());
            } else if (choice == 4) {
                break;
            }
        }

        scanner.close();
    }
}

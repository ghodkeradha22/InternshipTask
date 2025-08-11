package InternshipTask5;
import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactions; 
public Account(String accountHolder, double initialBalance) {
    this.accountHolder = accountHolder;
    this.balance = initialBalance;
    transactions = new ArrayList<>();
    transactions.add("Account created with balance: " + initialBalance);
}
public void deposit(double amount) {
    if (amount > 0) {
        balance += amount;
        transactions.add("Deposited: " + amount + " | Balance: " + balance);
        System.out.println("✅ Deposit successful!");
    } else {
        System.out.println("❌ Deposit amount must be positive!");
    }
}
public void withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
        balance -= amount;
        transactions.add("Withdrew: " + amount + " | Balance: " + balance);
        System.out.println("✅ Withdrawal successful!");
    } else if (amount > balance) {
        System.out.println("❌ Insufficient balance!");
    } else {
        System.out.println("❌ Withdrawal amount must be positive!");
    }
}
public void showBalance() {
    System.out.println("💰 Current Balance: " + balance);
}
public void showTransactions() {
    System.out.println("\n📜 Transaction History:");
        for (String t : transactions) {
            System.out.println(t);
        }
    }
}
public class BankAccountSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    System.out.print("Enter account holder name: ");
    String name = sc.nextLine();
    System.out.print("Enter initial balance: ");
    double balance = sc.nextDouble();

    Account account = new Account(name, balance);

    int choice;
    do {
        System.out.println("\n===== Bank Menu =====");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Transaction History");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter deposit amount: ");
                double depositAmount = sc.nextDouble();
                account.deposit(depositAmount);
                break;
            case 2:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = sc.nextDouble();
                account.withdraw(withdrawAmount);
                break;
            case 3:
                account.showBalance();
                break;
            case 4:
                account.showTransactions();
                break;
            case 5:
                System.out.println("👋 Thank you for using our bank!");
                break;
            default:
                System.out.println("❌ Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}

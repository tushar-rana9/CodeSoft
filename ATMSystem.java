import java.util.Scanner;

// Class representing the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("₹" + amount + " deposited successfully.");
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("❌ Insufficient balance! Withdrawal failed.");
            return false;
        } else if (amount <= 0) {
            System.out.println("❌ Invalid amount! Enter a positive value.");
            return false;
        }
        balance -= amount;
        System.out.println("₹" + amount + " withdrawn successfully.");
        return true;
    }

    public double getBalance() {
        return balance;
    }
}

// Class representing the ATM machine
class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n------ ATM Menu ------");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    withdraw();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    System.out.println("🙏 Thank you for using the ATM!");
                    return;

                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("❌ Invalid amount! Enter a positive value.");
            return;
        }

        account.deposit(amount);
    }

    private void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + account.getBalance());
    }
}

// Main class
public class ATMSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);  // initial balance
        ATM atm = new ATM(account);
        atm.start();
    }
}

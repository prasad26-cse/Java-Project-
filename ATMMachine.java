package JAVA;

import java.util.*;

public class ATMMachine {
    float balance;
    int pin;
    ArrayList<String> transtionHistory;

    public ATMMachine(int pin) {
     
        this.pin = pin;
        this.transtionHistory = new ArrayList<>();

    }

    public double checkBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransitonHistory("Withdraw:" + amount);
            System.out.println("succesfullay withdraw");
        } else {
            System.out.println("Insuffienct amount");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransitonHistory("Deposit:" + amount);
            System.out.println("succesfullay Deposit");
        } else {
            System.out.println("Insuffienct amount");
        }
    }

    public void DisplayHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transtionHistory) {
            System.out.println(transaction);
        }
    }

    private void addTransitonHistory(String transction) {
        transtionHistory.add(transction);
    }

    public void changePin(int currentPin, int newPin) {
        if (currentPin == pin) {
            pin = newPin;
            System.out.println("PIN successfully changed.");
        } else {
            System.out.println("Invalid PIN. Unable to change PIN.");
        }
    }

    public void runATM() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
          
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. View Transaction History");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Check balance
                    System.out.println("Your current balance: " + checkBalance());
                    break;
                case 2:
                    // Withdraw cash
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    // Deposit cash
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 4:
                    // Change PIN
                    System.out.print("Enter current PIN: ");
                    int currentPin = scanner.nextInt();
                    System.out.print("Enter new PIN: ");
                    int newPin = scanner.nextInt();
                    changePin(currentPin, newPin);
                    break;
                case 5:
                    // View transaction history
                    DisplayHistory();
                    break;
                case 0:
                    // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

   public static void main(String[] args) {
    ATMMachine atm = new ATMMachine( 1234);

        // Start ATM operations
        atm.runATM();

   }
}

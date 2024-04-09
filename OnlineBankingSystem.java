import java.util.Scanner;

public class OnlineBankingSystem {

    public static void main(String[] args) {

        BankAccount obj = new BankAccount("ICICI Bank", "23245435501");
        obj.showMenu();

    }

}

class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid) {
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            previousTransaction = amount;
            System.out.println("Deposit of " + amount + " successful.");
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            previousTransaction = -amount;
            System.out.println("Withdrawal of " + amount + " successful.");
        } else {
            System.out.println("Insufficient funds or invalid amount. Withdrawal failed.");
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred.");
        }
    }

    void showMenu() {

        char option;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome, " + customerName);
        System.out.println("Your ID is " + customerId + "\n");
        System.out.println("A: Check Your Balance");
        System.out.println("B: Deposit");
        System.out.println("C: Withdraw");
        System.out.println("D: View Previous Transaction");
        System.out.println("E: Exit The System");

        do {
            System.out.println("=============================================================");
            System.out.println("Enter Your Option");
            System.out.println("=============================================================");
            option = scanner.next().toUpperCase().charAt(0);
            System.out.println();

            switch (option) {

                case 'A':
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Your Current Balance: " + balance);
                    System.out.println("-------------------------------------------------------------");
                    System.out.println();
                    break;

                case 'B':
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Enter the amount to deposit: ");
                    System.out.println("-------------------------------------------------------------");
                    int depositAmount = scanner.nextInt();
                    deposit(depositAmount);
                    System.out.println();
                    break;

                case 'C':
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Enter the amount to withdraw: ");
                    System.out.println("-------------------------------------------------------------");
                    int withdrawAmount = scanner.nextInt();
                    withdraw(withdrawAmount);
                    System.out.println();
                    break;

                case 'D':
                    System.out.println("-------------------------------------------------------------");
                    getPreviousTransaction();
                    System.out.println("-------------------------------------------------------------");
                    System.out.println();
                    break;

                case 'E':
                    System.out.println("=============================================================");
                    System.out.println("Thank you for using our services.");
                    break;

                default:
                    System.out.println("Invalid option. Please enter a valid option.");
                    break;
            }
        } while (option != 'E');
    }
}


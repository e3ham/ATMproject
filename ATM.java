import java.util.Scanner;

class bankInfo {

    private int accountNumber;
    private int pin;
    private String name;
    private long balance;

    public void openAccount() {

        Scanner in = new Scanner(System.in);

            System.out.println("Please enter your account number:");
            accountNumber = in.nextInt();
        
            System.out.println("Please enter your PIN number. This must be 4 digits long: ");
            pin = in.nextInt();

            System.out.println("Please enter your name: ");
            name = in.next();

            in.close();

            System.out.println("Your starting balance has been set at 0$");
            balance = 0;

    }

    public void displayAccount() {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter PIN to verify identity: ");
        int newPin = in.nextInt();

        if (newPin == pin) {
            System.out.println("Name of account holder: " + name);
            System.out.println("Account no.: " + accountNumber);
            System.out.println("Balance: " + balance);
        } else {
            System.out.println("Wrong PIN. Account details unavailable.");
        }

        in.close();
    }

    public void deposit() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the amount you would like to deposit into your account: ");
        long amount = in.nextLong();
        in.close();

        balance += amount;
    }

    public void withdrawal() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the amount you would like to withdraw from your account: ");
        long amount = in.nextLong();
        in.close();

        balance += amount;
    }

}

public class ATM {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        bankInfo customer = new bankInfo();
        customer.openAccount();

        System.out.println("\n ***ATM System Starting***");
        System.out.println("1. Display all account details \n 2. Deposit money \n 3. Withdraw money \n 4.Exit ");
        System.out.println("Please enter your selection: ");
        int choice = input.nextInt();

        do {
            switch (choice) {
                case 1:
                    customer.displayAccount();
                    break;
                case 2:
                    customer.deposit();
                    break;
                case 3:
                    customer.withdrawal();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM system. See you soon.");
                    break;
            }

        } while (choice != 4);
        input.close();
    }
} 
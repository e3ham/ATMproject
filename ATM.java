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
    }

    public void deposit() {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the amount you would like to deposit into your account: ");
        long amount = in.nextLong();

        balance += amount;
        System.out.println("You have successfully deposited " + amount + "$ into your account.\nYour current balance is " + balance + "$\n");
        
    }

    public void withdrawal() {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the amount you would like to withdraw from your account: ");
        long amount = in.nextLong();

        balance -= amount;

        System.out.println("You have successfully withdrawn " + amount + "$ into your account.\nYour current balance is " + balance + "$\n");

    }
    
    
}

public class ATM {

    public static void main(String[] args) {

        boolean value = false;

        Scanner input = new Scanner(System.in);
        int choice;

        bankInfo customer = new bankInfo();
        customer.openAccount();

        System.out.println("\n ***ATM System Starting***");
        System.out.println("1. Display all account details \n2. Deposit money \n3. Withdraw money \n4.Exit ");
        System.out.println("\nPlease enter your selection: ");
        choice = input.nextInt();

        do {

            if (value == true) {
            System.out.println("1. Display all account details \n2. Deposit money \n3. Withdraw money \n4. Exit ");
            System.out.println("\nPlease enter your selection: ");
            choice = input.nextInt();
            }

            switch (choice) {
                case 1:
                    customer.displayAccount();
                    value = true;
                    break;
                case 2:
                    customer.deposit();
                    value = true;
                    break;
                case 3:
                    customer.withdrawal();
                    value = true;
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM system. See you soon.");
                    value = false;
                    break;
            }

        } while (choice != 4);

        input.close();
    }
} 
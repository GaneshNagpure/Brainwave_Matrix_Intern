package atm_interface;
import java.util.Scanner;

class ATM {
    private static String registeredUsername;
    private static String registeredPassword;
    private static double balance = 0.0;

    // Registration Method
    public static void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username for registration: ");
        registeredUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        registeredPassword = scanner.nextLine();
        System.out.println("Registration successful!");
    }

    // Login Method
    public static boolean login() {
    	
        Scanner scanner = new Scanner(System.in);
        System.out.println("Now you can do login.");
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(registeredUsername) && inputPassword.equals(registeredPassword)) {
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }

    }

    // Cash Withdraw Method
    public static void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();


        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Deposit Method
    public static void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Deposit successful! New balance: " + balance);

    }

    // View Balance Method
    public static void viewBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    // Logout Method
    public static void logout() {
        System.out.println("Logging out...");
    }

    // Main Method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;

        System.out.println("Welcome to the ATM System");
        


        // Registration
        register();

        // Login
        while (!loggedIn) {
            loggedIn = login();
            if (!loggedIn) {
                System.out.println("Please try again.");
            }
        }

        // ATM Menu
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw Cash");
            System.out.println("2. Deposit Cash");
            System.out.println("3. View Balance");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    viewBalance();
                    break;
                case 4:
                    logout();
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        System.out.println("Thank you for using the ATM. Goodbye!");

    }
}


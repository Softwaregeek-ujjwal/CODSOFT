import java.util.Scanner;

class BankAccount {
    private float balance;
    private int accountNumber;
    private String holderName;
    private String accountType;

    public BankAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name:");
        holderName = scanner.nextLine();

        System.out.println("Enter the account number:");
        accountNumber = scanner.nextInt();

        scanner.nextLine(); 

        System.out.println("Enter the account type:");
        accountType = scanner.nextLine();
        
        balance = 0; 
    }
        
    public void withdraw(float amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful");
        }
    }

    public void deposit(float amount) {
        balance += amount;
        System.out.println("Deposit successful");
    }

    public float getBalance() {
        return balance;
    }
}

class InnerAtm {
    private BankAccount account;
    private int pin;

    public InnerAtm(int pin, float initialBalance) {
        this.pin = pin;
        this.account = new BankAccount();
        this.account.deposit(initialBalance);
    }

    public void checkPin(Scanner scanner) {
        System.out.println("Enter your PIN:");
        int enteredPin = scanner.nextInt();

        if (enteredPin == pin) {
            menu(scanner);
        } else {
            System.out.println("Enter a valid PIN");
        }
    }

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("\nEnter your choice:");
            System.out.println("1. Check A/C balance");
            System.out.println("2. Withdraw money");
            System.out.println("3. Deposit money");
            System.out.println("4. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    float withdrawAmount = scanner.nextFloat();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Enter amount to deposit:");
                    float depositAmount = scanner.nextFloat();
                    account.deposit(depositAmount);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Enter a valid choice");
                    break;
            }
        }
    }
}

public class atm {  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Set your PIN:");
        int pin = scanner.nextInt();

        System.out.println("Set your initial balance:");
        float initialBalance = scanner.nextFloat();
        
        scanner.nextLine(); 

        InnerAtm atm = new InnerAtm(pin, initialBalance);
        atm.checkPin(scanner);
    }
}

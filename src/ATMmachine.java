import java.util.Scanner;

class myBankAccount
{
    private double balance;

    public myBankAccount(double startingBalance)
    {
        this.balance = startingBalance;
    }

    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amount)
    {
        if (amount > 0)
        {
            balance += amount;
            System.out.println("Deposit successful. Your New balance: $" + balance);
        }
        else
        {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount)
    {
        if (amount > 0)
        {
            if (amount <= balance)
            {
                balance -= amount;
                System.out.println("Withdrawal successful. Your New balance: $" + balance);
                return true;
            }
            else
            {
                System.out.println("Insufficient funds for withdrawal. Current balance: $" + balance);
            }
        }
        else
        {
            System.out.println("Invalid withdrawal amount. Please enter a valid amount.");
        }
        return false;
    }
}


public class ATMmachine
{
    public static void main(String[] args)
    {
        myBankAccount userAccount = new myBankAccount(1000.0); // Initial balance is $1000
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}


class ATM {
    private final myBankAccount bankAccount ;

    public ATM(myBankAccount bankAccount)
    {
        this.bankAccount = bankAccount;
    }

    public void showMenu() {
        System.out.println("ATM Menu:");
        System.out.println("Services ->");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run()
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            showMenu();
            System.out.print("Enter service number you want: ");
            int service = scanner.nextInt();

            switch (service)
            {
                case 1:
                    System.out.println("Current balance: $" + bankAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter your amount for deposit: $");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    boolean withdrawSuccess = bankAccount.withdraw(withdrawalAmount);
                    if (withdrawSuccess) {
                        System.out.println("Withdrawal successful.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    return;
                default:
                    System.out.println("Invalid service. Please try again.");
            }
        }
    }
}




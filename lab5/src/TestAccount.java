class BankAccount {
    private String customerName;
    private int accountNumber;
    private double accountBalance = 0;
    private String accountType;
    private static int accountsCreated;
    private static double totalDeposited, totalWithdrawn;

    BankAccount() {
        this.accountBalance = 0;
        accountsCreated++;
    }

    // overloaded constructor

    BankAccount(String customerName, int accountNumber, double accountBalance, String accountType) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        accountsCreated++;
    }

    // getters and setters

    public double getAccountBalance() {
        return accountBalance;
    }

    public void updateAccountNumber(int newAccountNumber) {
        this.accountNumber = newAccountNumber;
    }

    public static void printAccountsMade() {
        System.out.println(accountsCreated);
    }

    public static void printStatement() {
        System.out.println("Total deposited: $" + totalDeposited);
        System.out.println("Total withdrawn: $" + totalWithdrawn);
    }

    public void updateBalance(double amount, String operation) {
        if (operation.charAt(0) == 'D' || operation.charAt(0) == 'd') {
            accountBalance += amount;
            totalDeposited += amount;
        } else if (operation.charAt(0) == 'W' || operation.charAt(0) == 'w') {
            if (accountBalance >= amount) {
                accountBalance -= amount;
                totalWithdrawn += amount;
            } else {
                System.out.println("Insufficient funds");
            }

        }
    }

    /*
        public void updateBalance(double amount, boolean deposit) {
        if (deposit) {
            accountBalance += amount;
            totalDeposited += amount;
        } else {
            if (accountBalance >= amount) {
                accountBalance -= amount;
                totalWithdrawn += amount;
            } else {
                System.out.println("Insufficient funds for withdrawal.");
            }
        }
    }

     */

}

public class TestAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Artem Ruzaev", 123456, 1000, "Checking");
        BankAccount account2 = new BankAccount("Farmer Ben", 234567, 2000, "Savings");
        BankAccount account3 = new BankAccount("Barack Obama", 3343378, 3000, "Checking");

        // Deposit $100 to each account
        account1.updateBalance(100, "Deposit");
        account2.updateBalance(100, "d");
        account3.updateBalance(100, "deposit");

        // Withdraw $50 from each account
        account1.updateBalance(50, "w");
        account2.updateBalance(50, "Withdraw");
        account3.updateBalance(50, "withdraw");

        // Output required information
        System.out.print("Accounts made: ");
        BankAccount.printAccountsMade();
        BankAccount.printStatement();

        System.out.println("Remaining balances:");
        System.out.println("Account 1: $" + account1.getAccountBalance());
        System.out.println("Account 2: $" + account2.getAccountBalance());
        System.out.println("Account 3: $" + account3.getAccountBalance());
    }


}
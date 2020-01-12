public class BankAccount {
    private static final double RATE_DEFAULT_INTEREST = 0.02d;

    private  static int idCounter = 1;

    private int id;
    private double balance;
    private static double interestRate = RATE_DEFAULT_INTEREST;

    public BankAccount(){
        this.id = idCounter++;
    }

    public int getId() {
        return this.id;
    }

    public static void setInterestRate(double interest){
        BankAccount.interestRate = interest;
    }

    public double getInterest(int years){
        return BankAccount.interestRate * years * this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}


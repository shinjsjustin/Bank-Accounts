public class SavingsAccount extends BankAccount{
    public double interestRate; //this is the only difference between this and its superclass

    public SavingsAccount(){
        super();
        type = "Savings Account";
    }

    public SavingsAccount(String accName, String Date){
        super(accName, Date);
        type = "Savings Account";
    }

    public SavingsAccount(String accName, String Date, double bal, double rate){
        super(accName, Date, bal, "Savings Account");
        interestRate = rate;
    }

    public String toString(){
        String retString = super.toString() + "\nInterest Rate: " + interestRate;
        return retString;
    }
}

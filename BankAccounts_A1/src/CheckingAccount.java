public class CheckingAccount extends BankAccount{
    public double withdrawalCapacity;//this is the only difference between this and its superclass

    public CheckingAccount(){
        super();
        type = "Checking Account";
    }

    public CheckingAccount(String accName, String Date){
        super(accName, Date);
        type = "Checking Account";
    }

    public CheckingAccount(String accName, String Date, double bal, double cap){
        super(accName, Date, bal, "Checking Account");
        withdrawalCapacity = cap;
    }

    public String toString(){
        String retString = super.toString() + "\nWithdrawal Limit: " + withdrawalCapacity;
        return retString;
    }
}

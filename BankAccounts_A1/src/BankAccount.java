public class BankAccount {
    static String bankName = "Bank of Justin"; //for fun, not necessary
    private static int currentNumber=0; //number of banks(objects) this class has made.

    //heart of the class.
    public String accountNum;
    public String createDate;
    public double balance;
    public String type;

    //NOTE: all the constructors will increase the currentNumber by 1
    //      this is to keep track of the total number of banks this
    //      class has made.

    //Constructor 0-args
    public BankAccount(){
        currentNumber +=1;
        accountNum = "Bank " + currentNumber;
    }

    //Constructor 2-args
    public BankAccount(String accNum, String currentDate){
        currentNumber +=1;
        accountNum = accNum + " (" + currentNumber + ")";
        createDate = currentDate;
    }

    //Constructor 4-args
    public BankAccount(String accNum,
                          String currentDate,
                          double balance,
                          String type){
        currentNumber +=1;
        createDate = currentDate;
        this.balance = balance;
        this.type = type;
        accountNum = accNum + " (" + type + ": " + currentNumber + ")";
    }

    //Setters
    public void setAccountNum(String accNum){
        accountNum = accNum;
    }
    public void setDate(String date){
        createDate = date;
    }
    public void setBalance(int num){
        balance = num;
    }
    public void setType(String name){
        type = name;
    }

    //Getters
    public String getAccountNum(){ return accountNum; }
    public String getCreateDate(){
        return createDate;
    }
    public double getBalance(){
        return balance;
    }
    public String getType(){ return type; }

    public String toString(){
        String retString = "Account: " + accountNum
                + "\nCreated Date: " + createDate
                + "\nBalance: $" + balance
                + "\nAccount Type: " + type;

        return retString;
    }

    //Much needed helper method to compare banks.
    //Since the account number will be unique for
    // each object creation this will only return
    // true if the banks are completely identical
    // (private STATIC int currentNumber)
    // Even if you create two accounts with the same
    // name, the currentNumber will be unique.
    public int compare(BankAccount bank){
        int retInt = 2;
        if(this.accountNum == bank.getAccountNum()){
            retInt = 0;
        } else if(this.getBalance() > bank.getBalance()){
            retInt = 1;
        } else if(this.getBalance() < bank.getBalance()){
            retInt = -1;
        }
        return retInt;
    }
}

import java.util.Arrays;

public class ArrayBag implements BagInterface<BankAccount>{
    private static final int MAXIMUM_LIMIT = 10;

    //Private variables (heart of the class)
    private BankAccount[] bankArrays;
    private int numBanks = 0;

    //Constructor
    public ArrayBag(){}

    //Constructor
    public ArrayBag(int size){
        if(size > MAXIMUM_LIMIT) throw new IllegalStateException("Bag is too large");
        BankAccount[] bankArr = new BankAccount[size]; //To initiate a new object
        bankArrays = bankArr; //set the new object created above to this object
    }

    @Override
    public boolean add(BankAccount newEntry) {
        //Calls two helper methods, isFull() and doubleCapacity().
        if(this.isFull()){
            doubleCapacity();
        }
        //sets the new entry to this bankArray at index numBanks.
        //numBanks will always hold an empty spot because of the
        //two lines of code above.
        bankArrays[numBanks] = newEntry;
        numBanks++;
        return true;
    }

    @Override
    public boolean remove(BankAccount anEntry) {
        //sort through the array to see if this bag
        // has the bank you're trying to delete
        // using the .compare() method defined in
        // the BankAccount class.
        for(int i=0; i<numBanks; i++){
            if(bankArrays[i].compare(anEntry) == 0){
                bankArrays[i] = bankArrays[numBanks-1]; //set the "last" bank in this array to the current
                bankArrays[numBanks-1] = null; //delete the last bank.
                numBanks --;
                return true; //this return will terminate the method so the final return doesn't run
            }
        }
        return false;
        //NOTE: even if the bank is found at the last entry, this method will still work,
        //      the line before the null will simply do nothing.
    }

    //Similar to the method above, this just deletes the last bank in the array,
    //instead of a specified bank.
    @Override
    public boolean remove() {
        if(this.getSize() == 0){
            return false;
        } else{
            bankArrays[this.numBanks-1] = null;
            numBanks--;
            return true;
        }

    }

    @Override
    public boolean contains(BankAccount anEntry) {
        //sort through array using the .compare() method to look for the bank
        for(int i=0; i<getSize(); i++){
            if(bankArrays[i].compare(anEntry) == 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public int getSize() {
        return this.bankArrays.length;
    }

    //This method uses the system calls to copy the data of this class object
    // to a return replica. Doing this protects the object's data.
    @Override
    public BankAccount[] toArray() {
        BankAccount[] copy1 = bankArrays.clone();

        BankAccount[] copy2 = new BankAccount[copy1.length];
        System.arraycopy(this.bankArrays,0,copy2,0,this.numBanks);

        return copy1;
    }

    public String toString(){
        String retString = "Bag Contents (" + numBanks + ")\n\n";

        //At each index, attach the bank's string to the return string.
        for(int i=0; i<numBanks; i++){
            retString += "Index [" + i + "]\n"
            + bankArrays[i].toString() + "\n\n";
        }

        return retString;
    }

    public boolean isFull(){
        return numBanks >= this.getSize();
    }

    //private helper method
    private void doubleCapacity(){
        int newCapacity = this.getSize()*2; //create space
        this.bankArrays = Arrays.copyOf(this.bankArrays, newCapacity); //transfer data
    }

    public void balanceCheck(int number){
        System.out.println("The following bank accounts have a balance greater than or equal to $" + number + ":\n");
        //sort through the array and if the balance is greater than the number provided, print out the details.
        for(int i=0; i<numBanks; i++){
            if(this.bankArrays[i].getBalance() >= number){
                System.out.println(bankArrays[i].toString()+"\n");
            }
        }
    }

    public int getNumBanks(){
        return numBanks;
    }
}

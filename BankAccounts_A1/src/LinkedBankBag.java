import java.awt.*;
import java.util.ArrayList;

public class LinkedBankBag implements LinkedBagInterface<BankAccount>{
    //Private variables (heart of the class)
    private int numNodes = 0;
    Node firstNode;

    //Constructor
    public LinkedBankBag(){firstNode = null;}

    @Override
    public boolean add(BankAccount bank) {
        Node newNode = new Node(bank);

        //if: the bag isn't empty
        //else: if the bag is empty
        if(firstNode != null){
            newNode.next = firstNode;
            firstNode = newNode;
        } else{
            firstNode = newNode;
            firstNode.next = null;
        }
        numNodes++;
        return true;
    }

    @Override
    public boolean remove() {
        //if: bag is empty
        //else: bag is not empty
        if (firstNode == null) {
            return false;
        } else{
            //objects that aren't pointed to are "deleted"
            firstNode = firstNode.next;
            numNodes--;
            return true;
        }
    }

    @Override
    public boolean remove(BankAccount bank) {
        //calls helper method "getNodeFor" below

        //Helper method returns a node using the
        //  bank.compare() function to return the
        //  node if the bank exists in the bag.
        Node nodeToDelete = getNodeFor(bank);

        //if: helper method described above returned something
        //else: helper method couldn't find bank object in bag
        if(nodeToDelete != null){
            nodeToDelete.data = firstNode.data;
            firstNode = firstNode.next;
            numNodes--;
            return true;
        } else{
            return false;
        }
    }

    //helper method used in remove(BankAccount bank) method
    private Node getNodeFor(BankAccount bank){
        Node currentNode = firstNode;
        boolean found = false;

        //this will loop through the linked list running the
        //  bank.compare() method to search for a bank in
        //  this bag of banks.

        //the while loop has two conditions so the loop
        //  stops when it finds the item.  It will only
        //  find one specific instance of an item, not
        //  duplicates or triplicates etc.
        while(!found && (currentNode != null)){
            if(bank.compare(currentNode.data) == 0){
                found = true; //kill switch
            }else{
                currentNode = currentNode.next; //continue looping
            }
        }
        return currentNode;
    }

    @Override
    public int getSize() {
        return numNodes;
    }

    @Override
    public int getCount(BankAccount bank) {
        int count=0;
        Node currentNode = firstNode;

        //Similar to the helper "getNodeFor" method
        // except this won't exit the while loop
        // until the whole linked list has been
        // processed.
        while(currentNode!=null){
            if(bank.compare(currentNode.data) == 0){
                count++; //simple count when bank.compare() returns true
            }
            currentNode = currentNode.next;
        }
        return count;
    }

    @Override
    public BankAccount[] toArray() {
        BankAccount[] bankArray = new BankAccount[numNodes];
        Node currentNode = firstNode;
        int i=0;

        //loop through the entire linked list and at each stop
        // copy the data to an array of BankAccount.
        while(currentNode != null){
            bankArray[i] = currentNode.data;
            currentNode = currentNode.next;
        }
        return bankArray;
    }

    @Override
    public boolean contains(BankAccount bank) {
        //Uses the "getCount" method above,
        // if the count for this bank in this
        // bag is more than 0 that means this
        // bag contains said bank.
        if(this.getCount(bank)>0){
            return true;
        } else{
            return false;
        }
    }

    public void printEverything(){
        Node currentNode = firstNode;
        System.out.println("Bag Contents (" + numNodes + ")\n");

        //Loop through the bag and print out all the data.
        while(currentNode != null){
            System.out.println(currentNode.data.toString() + "\n");
            currentNode = currentNode.next;
        }
        System.out.println("\n"); //two spaces for pretty
    }

    //Same as the method above, "printEverything", except
    //  this method first checks the balance to a given
    //  number (sent from user) before printing.
    public void balanceCheck(int number){
        System.out.println("The following bank accounts have a balance greater than or equal to $" + number + ":\n");
        Node currentNode = firstNode;
        while(currentNode != null){
            if(currentNode.data.getBalance() >= number){
                System.out.println(currentNode.data.toString() + "k\n");
            }
            currentNode = currentNode.next;
        }
    }

    //inner class for Node
    public class Node{
        public BankAccount data;
        public Node next;

        public Node(){}

        public Node(BankAccount bank){
            this(bank, null);
        }

        public Node(BankAccount bank, Node n){
            this.data = bank;
            this.next = n;
        }

        public BankAccount getData(){ return this.data;}
        public Node getNextNode(){ return this.next;}
    }
}

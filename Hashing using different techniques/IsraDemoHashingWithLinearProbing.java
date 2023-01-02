package LA3Q1;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class IsraDemoHashingWithLinearProbing {
    public static int items; // a int type field that will hold the value of the total number of data items to be added to the hash table
    public static Scanner input = new Scanner(System.in);
    public static double lf; //records the load factor. load factor is number of keys there/size of table
    public static int tableCapacity; //stores the size of the table
    public static IsraValueEntry[] hashTable; //IsraValueEntry array reference
    public static IsraValueEntry[] workingHashtable; //second array reference that will be used to copy the hashtable reference for the rehashing operation
    //rehashing is making a new table with a new size and the size is selected by doubling the old size table and taking the next prime
    public static void main(String[] args) {
        header(3,1);

        System.out.println("Let's decide on the initial table capacity based on the load factor and dataset size");
        System.out.println("How many data items:");
        items=input.nextInt();//the items that the hashtable will contain are created by the user
        System.out.println("What is the load factor (Recommended: <= 0.5):");
        lf=input.nextDouble();//the user will choose the load factor capacity
        tableCapacity=checkPrime((int)(items/lf));//to get the capacity we divide the number of items we have by the load factor and take the next prime of that number
        System.out.println("The minimum required table capacity would be:" +tableCapacity );

        hashTable=new IsraValueEntry[tableCapacity];//giving the hashtable the capacity. Note that capacity is how much the table can hold and not how many items it currently has
        for(int i=0; i<tableCapacity; i++){
            hashTable[i]=new IsraValueEntry();//here I populated the hashtable by the no argument constructor I created and this will populate it with -1 representing null
        }


        for(int i = 1; i<=items; i++){//this is to add the items to the hashtable
            System.out.printf("\nEnter item %d: ", i);
            int item=input.nextInt();//asks the user to put in the item
            addValueLinearProbe(item);//a method call. addValueLinearProbe will add the item to the hashtable
        }
        System.out.print("The Current Hash-Table: [");
        printHashTable();//printing out the current hashtable
        System.out.print("\b]");

        System.out.println("\n\nLet’s remove two values from the table and then add one…….");

        System.out.println("\nEnter a value you want to remove: ");
        int vR=input.nextInt();//asking the user to put a value that they want to remove from the hashtable
        removeValueLinearProbe(vR);//a method call to remove the value they want to remove
        System.out.print(" The Current Hash-Table: [");
        printHashTable();//printing out the new hashtable with the removed objects
        System.out.print("\b]");
        System.out.println("\nEnter a value you want to remove: ");
        int vR1=input.nextInt();//removing a 2nd object
        removeValueLinearProbe(vR1);
        System.out.print(" The Current Hash-Table: [");
        printHashTable();
        System.out.print("\b]");

        System.out.println("\nEnter a value to add to the table: ");
        int vAdd=input.nextInt();//adding a value to the hashtable
        addValueLinearProbe(vAdd);//calling the adddValue methode and passing it the integer they want to add
        System.out.print("The Current Hash-Table:[");
        printHashTable();//printing out the hashtable
        System.out.print("\b]");

        System.out.println("\nRehashing the table...");
        rehashingWithLinearProbe();// rehashing will increase  the capacity of the hashtable by double the previous capacity and taking the next prime.
        System.out.print("The Current Hash-Table:[");
        printHashTable();
        System.out.print("\b]");


       footer(3);



    }
    public static void addValueLinearProbe(Integer k) {
        //linear probbing is when a collision(collision is when two keys get to be stored in the same index) happens and the key gets stored in the next empty spot.
        // This method adds values to the hashtable and checks if the value was already there and if a collision occurs. If a collision occurs it takes care of it by assigning that
       //value to the next null or available spot.
        int index= k% tableCapacity; //this is the hash function. the index of where the value will be placed is the mod of the hashcode(Here it is the number itself since we are using Integer as data type) with the table capacity calculated above
        if(index<0){//this condition id to check if the hash function  gives a negative number. Since an index cannot be negative it will take that and add the table capacity to it and this will fix the issue
            index=index+tableCapacity;
        }
        boolean b=false;
        for(int i = index; i<hashTable.length; i++){//i is = to index because we want the value to be placed in the correct spot based on hashcode.
            if(hashTable[i].getKey()==-1 || hashTable[i].getKey()==-111){//this will add values to the hashtable only if there is a spot
                hashTable[i].setKey(k);
                if(hashTable[i].getKey().equals(k)){//this checks if there is collision
                    b=true;
                    break;
                }
            }

        }

        if (index==hashTable.length-1 && !b){//if the value is supposed to be placed at the end of the array but it is full then go back to the beginning to the array and place it in the next empty dpot
            for(int i=0; i<hashTable.length; i++){
                if((hashTable[i].getKey()==-1 || hashTable[i].getKey()==-111) && hashTable[i].getKey()!=index){//will place the value in a free spot
                    hashTable[i].setKey(k);
                    break;
                }

            }
        }
    }

    public static int checkPrime(int n) {//this method will return the next prime.
        // We care so much about the table capacity being a prime number because this will decrease the number of collisions we will have if we chose and odd or an even number
        int m = n / 2;//eliminates half of the numbers to check
        for (int i = 3; i <= m; i++) {
            if (n % i == 0) {
                i = 2;//it resets the for loop for the next prime number so that we are always checking if
                n++;//increasing n if the next number was divisible by 3
                m = n / 2;//elimination half of the numbers again
            }
        }
        return n;
    }
    public static void  removeValueLinearProbe(Integer k){//removes a value from the hashtable
        int index= k % tableCapacity;//the hash function that will locate where the value is exactly
        if(index<0){//fixing the index if it is a negative number
            index=index+tableCapacity;
        }
        boolean h = false;
        for(int i = index; i < hashTable.length; i++) {
            if (hashTable[i].getKey().equals(k)) {//checking if the key we want to remove is in the hashtable
                h=true;
                System.out.print(hashTable[i].getKey() + " is Found and removed!");//this will get the key we want to remove and print out it is found
                hashTable[i].setKey(-111);//this will replace the value we removed with -111 representing that this spot is available now
            }
        }
                if(!h) {//if the key is not found then print out this statement
                    System.out.println("key is not found");
            }

    }
    public static void printHashTable(){//this method prints out the hashtable
        for(int i =0; i< hashTable.length; i++){//this prints out null if the index has value of -1, because -1 represents null.
           if(hashTable[i].getKey() == -1){
               System.out.print("null,");
           }
           else if(hashTable[i].getKey()==-111){//if the index has value of -111 then this means available so "available" will be printed out in that index
               System.out.print("available,");
           }
           else{//this prints out the hashtable with the correct values
               System.out.print(hashTable[i].getKey()+",");
           }


        }
    }
    public static void rehashingWithLinearProbe(){
        //rehashing is the idea of increasing the table capacity by doubling the old size and taking the next prime
        // and then copying the old table to the new one to save the values.
        int capacity=tableCapacity * 2;//doubling the old table capacity
        System.out.println("The rehashed table capacity is: "+checkPrime(capacity));
        tableCapacity=checkPrime(capacity);//changing the old table capacity to the new one by taking the next prime number after doubling it

        workingHashtable=new IsraValueEntry[tableCapacity];//giving the new table the new size we calculated above
        for(int i = 0; i<workingHashtable.length; i++){
            workingHashtable[i]=new IsraValueEntry();//populating the array with the no argument constructor that represents null
        }
        System.arraycopy(hashTable,0,workingHashtable,0,hashTable.length);//copying the old hashtable  with the values to the  new one
        hashTable=new IsraValueEntry[tableCapacity];//giving the old hashtable the new size
        for(int i=0; i< hashTable.length; i++){
            hashTable[i]= new IsraValueEntry();//now populating the old hashtable with null because the values it had are saved in the other table
        }

        for(int i=0; i< hashTable.length; i++){
            if(workingHashtable[i].getKey()==-111){//the resized table has all the available spots as null because it is new
                System.out.print("null");
            }
            else{
            addValueLinearProbe(workingHashtable[i].getKey());//adding all the saved values

            }

        }


    }
    public static void header(int Num, int q) {//Having an int parameter to input the number you want
        System.out.println("=============================");
        System.out.println("Lab Assignment " + Num + "-Q " +q+ "\nPrepared by: Isra Elwazir" + "\nStudent number: 251132469" + "\nGoal of this Exercise: hashing with linear probbing technique");
        System.out.println("=============================");

    }
    public static void footer ( int Num){//An int parameter again to input the lab number
        System.out.print("\n=============================");
        System.out.println("\nCompletion of Lab Assignment" + Num + "-Q1 is successful!");
        System.out.println("Signing off-Isra");
        System.out.println("=============================");
    }

}

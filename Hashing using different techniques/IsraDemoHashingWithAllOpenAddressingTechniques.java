package LA3Q2;
import LA3Q1.*;

import java.util.Arrays;//importing this to use Arrays.toString

import static LA3Q1.IsraDemoHashingWithLinearProbing.*;//makes it possible to use methods and classes and fields from another package

public class IsraDemoHashingWithAllOpenAddressingTechniques {
    public static void main(String[] args) {
        header(3,2);
        System.out.println("Let's demonstrate our understanding on all the open addressing techniques...");
        System.out.print("How many data items: ");
        items = input.nextInt();//the number of values our hashtable will conatin
        System.out.print("What is the load factor (Recommended: <= 0.5): ");
        lf = input.nextDouble();//asking the user for the load factor they want
        tableCapacity = checkPrime((int) (items / lf));///to get the capacity we divide the number of items we have by the load factor and take the next prime of that number
        System.out.println("The minimum required table capacity would be: " + tableCapacity);

        //different datasets to try the methods
        Integer[] dataset1 = {-11, 22, -33, -44, 55};
        Integer[] dataset2 = {7, 14, -21, -28, 35};

        System.out.print("The given dataset is: ");
        printArray(dataset1);//printing the array before doing anything to it
        hashTable = new IsraValueEntry[tableCapacity];//giving the hashtable the table capacity we calculated above
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new IsraValueEntry();//populating the hashtable with the no argument constructor which is null
        }

        System.out.println("Let's enter each data item from the above to the hash table:");
        System.out.println("\nAdding data - linear probing resolves collision");
        for (int i = 0; i < dataset1.length; i++) {
            addValueLinearProbe(dataset1[i]);//adding the items in the array to the hashtable using linear probing
        }
        System.out.print("The current hashtable: [");
        printHashTable();//printing out the hashtable after calling the linear probe method
        System.out.println("\b]");
        emptyHashTable();//emptying the hashtable so that we can use it again for the other methods


        for (int i = 0; i < dataset1.length; i++) {
            addValueQuadraticProbe(dataset1[i]);//adding the items in the array to the hashtable using quadratic probing
        }
        System.out.println("\nAdding data - quadratic probing resolves collision");
        if(lf>0.5){
            System.out.println("Probing failed! Use a load factor of 0.5 or less. Goodbye!");
        }
        System.out.print("The current hashtable: [");
        printHashTable();//printing out the hashtable after calling the quadratic probing method
        System.out.println("\b]");

        emptyHashTable();//emptying the hashtable so that we can use it again for the other methods
        for (int i = 0; i <dataset1.length; i++) {
            addValueDoubleHashing(dataset1[i]);//adding the items in the array to the hashtable using double hashing probing
        }
        int smallP=thePrimeNumberForSecondHashFunction(tableCapacity);//getting the previous prime to use it in the second hash function in double hashing
        System.out.println("\nAdding data - double-hashing resolves collision");
        System.out.println("The q value for double hashing is: " + smallP);
        System.out.print("The Current Hash-Table: [");
        printHashTable();
        System.out.println("\b]");



            footer(3);
    }

    public static void printArray(Integer[] a) {//this method simply prints out the array

        System.out.println(Arrays.toString(a));
    }

    public static void emptyHashTable() {//this method will reset the table to all values null
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new IsraValueEntry();//giving the table the empty argument constructor to assign null
        }
    }

    public static int thePrimeNumberForSecondHashFunction(int n) {
        int m = n / 2;
        n--;//so that it checks the numbers below the capacity since we need the previous prime
        for (int i = 3; i <= m; i++) {
            if (n % i == 0) {
                i = 2;
                n--;//will get the previous prime
                m = n / 2;
            }
        }
        return n;
    }

    public static void addValueQuadraticProbe(Integer k) {
        boolean n=false;
        //a flag

        int index = k % tableCapacity;//the key value modded with the table capacity
            if (index < 0) {//this condition id to check if the hash function  gives a negative number. Since an index cannot be negative it will take that and add the table capacity to it and this will fix the issue
                index = index + tableCapacity;
            }//i is = to index because we want the value to be placed in the correct spot based on hashcode.

            //if collision occurs this block of code will take care of it
                for (int i = 0; i < tableCapacity && !n; i++) {
                    int newIndex = (index+ (i * i)) % tableCapacity;//this is the quadratic probe hash function. It jumps k+n^2 times and placed the value there

                    if (hashTable[newIndex].getKey() == -1) {
                        hashTable[newIndex].setKey(k);//this will place the value in the correct index based on the quadratic probing hash function
                        n=true;

                    }

                }
            }


    public static void addValueDoubleHashing(Integer k) {//double hashing is using two hash functions and adding the first and the second multiplied by j which is the number of times you are looping through the array

        int hash1 = k % tableCapacity;//the regular hash function
        int prePrime = thePrimeNumberForSecondHashFunction(tableCapacity); //prePrime is the prime number right before the current table capacity prime number
        int hash2 = prePrime - (k % prePrime);//this is the second hash function
        if(hash1<0){
            hash1=hash1+tableCapacity;
        }

        boolean m=false;//this is a flag to help exist and place new values
        for (int i = 0; i <tableCapacity && !m; i++) {
                int hash = hash1 + (hash2 * i);//this is double hashing. It is adding the functions we had above. It helps reduce the amount of collisions that can happen
                for(int j=hash; j<=hashTable.length; j++) {
                    if ((hashTable[hash].getKey() == -1)){//checks that the spot is empty before adding the values
                        hashTable[hash].setKey(k);
                        m = true;
                        }
                    }

                if(hash>tableCapacity){//this is for if the index is the hash function produced is out of the table capacity, it will go back to beginning and add it to the first empty spot
                    for (int z=0; z<tableCapacity&&!m; z++){
                        if(hashTable[z].getKey()==-1){//makes sure the spot is empty before addidng
                        hashTable[z].setKey(k);
                        m=true;
                    }
                }

                }



       }
    }
}






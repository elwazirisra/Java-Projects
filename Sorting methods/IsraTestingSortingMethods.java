package LA2Q1;
import java.util.*;
import java.lang.Math;

public class IsraTestingSortingMethods {
    public static void main(String[] args) {
        int size = 50000;//the size of the array that is made of random numbers
        Integer[] main = new Integer[size]; //the main array that will be given to each method as an argument
        Integer[] backup = new Integer[main.length]; //we need to two arrays so that when the first one is sorted we copy it to the second one and gib=ve it to the method so it can sort it

        //define the range of the numbers
        int max = 94;
        int min = 13;
        int range = max - min + 1;

        //generating random numbers from 13 to 93
        for (int i = 0; i < main.length; i++) {
            int rand = (int) (Math.random() * range) + min;
            main[i] = rand;
        }
        System.arraycopy(main, 0, backup, 0, main.length); //copy the main array to the backup array, now we have two similar arrays

        List<Integer> list = Arrays.asList(main); //creating a list from the array we have to simplify printing

        header(2);
        //all the prints below are to print the sorting methods

        //System.out.println("Testing execution time of different sorting methods for sorting 5 random numbers:");
        //System.out.println("The unsorted list: " + list);
        long start = System.nanoTime();//snapshots the time from the beginning
        Collections.sort(list);
        long end = System.nanoTime();//snapshots time
        double time = (end - start) / 1e6;
        /*System.out.printf("\nCollections' Sorting Time: %.2f %s", time, "milliseconds");
        System.out.println("\nThe sorted list using Collections' sort method: " + list);

        System.arraycopy(backup, 0, main, 0, size); //we have to copy from the main to the backup everytime to make sure we are giving the methods the right unsorted array
        System.out.println("\n\nThe unsorted list: " +list);
        System.out.printf("My Selection-Sort Time: %.2f %s", selectionSort(main)*1e-6," milliseconds");
        System.out.println("\nThe sorted list using selection-sort: "+ list);

        System.arraycopy(backup, 0, main, 0, size);
        System.out.println("\n\nThe unsorted list: " + list);
        System.out.printf("My Bubble-Sort Time: %.2f %s ", bubbleSort(main)*1e-6, " milliseconds");
        System.out.println("\nThe sorted list with Bubble-sort: "+list);



        System.arraycopy(backup, 0, main, 0, size);
        System.out.println("\nThe unsorted list " + list);
        System.out.printf("My Insertion-Sort Time: %.2f %s ", insertionSort(main)*1e-6," milliseconds");
        System.out.println("\nThe sorted list with Insertion-sort:"+list);

        System.arraycopy(backup, 0, main, 0, size);
        System.out.println("\n\nThe unsorted list " + list);
        System.out.printf("My Merge-Sort Time: %.2f, %s", mergeSort(main)*1e-6," milliseconds");
        System.out.println( "\nThe sorted list with Merge-sort : "+list);

        System.arraycopy(backup, 0, main, 0, size);
        System.out.println("\n\nThe unsorted list: "+list);
        System.out.printf("My Quick-Sort Time: %.2f %s", quickSort(main,0,4)*1e-6," milliseconds");
        System.out.println("\nThe sorted list with Quick sort: "+list);

        System.arraycopy(backup, 0, main, 0, size);
        System.out.println("\nThe unsorted list: "+list);
        System.out.printf("My Bucket-Sort Time: %.2f %s", bucketSort(main,0,4,10)*1e-6," milliseconds");
        System.out.println("\nThe sorted list with Bucket-sort: "+list);*/

        System.out.println("Testing execution time of different sorting methods for sorting 50000 random numbers:");
        System.out.printf("\nCollections' Sorting Time: %.2f %s", time, "milliseconds");
        System.arraycopy(backup, 0, main, 0, size);
        System.out.printf("\nMy Selection-Sort Time: %.2f %s", selectionSort(main)*1e-6," milliseconds");
        System.arraycopy(backup, 0, main, 0, size);
        System.out.printf("\nMy Bubble-Sort Time: %.2f %s ", bubbleSort(main)*1e-6, " milliseconds");
        System.arraycopy(backup, 0, main, 0, size);
        System.out.printf("\nMy Insertion-Sort Time: %.2f %s ", insertionSort(main)*1e-6," milliseconds");
        System.arraycopy(backup, 0, main, 0, size);
        System.out.printf("\nMy Merge-Sort Time: %.2f, %s", mergeSort(main)*1e-6," milliseconds");
        System.arraycopy(backup, 0, main, 0, size);
        System.out.printf("\nMy Quick-Sort Time: %.2f %s", quickSort(main,0,49999)*1e-6," milliseconds");
        System.arraycopy(backup, 0, main, 0, size);
        System.out.printf("\nMy Bucket-Sort Time: %.2f %s", bucketSort(main,0,4,10)*1e-6," milliseconds");



        footer(2);

    }

    public static <T extends Comparable<? super T>> long selectionSort(T[] a) {
        long start=System.nanoTime();//snapshots time
        T[] array = a; //the array we will be working with
        int min;
        for (int i = 0; i < array.length ; i++) {//this will loop
            min = i; //assuming the smallest is the index i
            for (int j = i+1 ; j < array.length; j++) {//this will compare the element in index i with the rest of the elements and puts the smallest in the beginning
                if (array[j].compareTo(array[min]) < 0) {
                    min=j; //make the minimum j

                }
            }
            //swapping the index of the outerIndex with the min
            T temp= array[i];
            array[i]=array[min];
            array[min]=temp;
        }
        long end=System.nanoTime();

        return end-start;// return the time take for the methode
    }

    //Bubble sorting steps in the data set we have from one end to the other end and what it does is that it compares every pair of elements and swaps them if they are in the wrong order. It keeps doing it till the data is sorted
    public static <T extends Comparable<? super T>> long bubbleSort(T[] a) {
        long start = System.nanoTime();
        T[] array = a;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {//compares the first element in the first index to the next element in the second index and so on
                    T min = array[j];//the minimum element will in be in the first index
                    array[j] = array[j + 1];//updating where comparison starts from
                    array[j + 1] = min;
                }
            }

        }

        long end = System.nanoTime();
        long time = end - start;
        return time;
    }

    //the way insertion method works is that it removes one element from the list, finds the best location for it and inserts it back to the list
    //insertion is a stable sorting method, this means that it can sort things based on two keys
    public static <T extends Comparable<? super T>> long insertionSort(T[] a) {
        long start = System.nanoTime();
        T[] array = a;
        int i = 0;
        int j = 0;
        for (i = 0; i < array.length; i++) {//the first loop
            T key = array[i];// the variable key is equal to the element at index i in the array
            for (j = i - 1; j >= 0 && array[j].compareTo(key) > 0; j--) {//will compare the element in the first index to the element in the second index
                array[j + 1] = array[j];
            }
            array[j + 1] = key; // the array at index j+1 is equal to the key
        }
        long end = System.nanoTime();
        long time = end - start;
        return time;
    }

    //merge-sorting works by dividing the unsorted array continuously till it reaches single elements and then it merges them in a single sorted array
    public static <T extends Comparable<? super T>> long mergeSort(T[] S) {
        long start = System.nanoTime();
        int n = S.length;//n is the length of the array
        if (n < 2) return 1;//the base case for recursion so that it doesn't cause stack overflow
        int mid = n / 2; //dividing the array by 2 to get two arrays in the first call and so on it keeps diving the array till you get one single element


        T[] S1 = Arrays.copyOfRange(S, 0, mid); // copy of first half
        T[] S2 = Arrays.copyOfRange(S, mid, n); //copying the second half

        mergeSort(S1);//recursion call. this will take the first half of the array and keep dividing it
        mergeSort(S2);// recursion call it will keep diving the second half of the array

        int i = 0, j = 0;
        while (i + j < S.length) {//this will keep happening till i+j are equal ot bigger than the length of the array
            if (j == S2.length || (i < S1.length && S1[i].compareTo(S2[j]) < 0))
                S[i + j] = S1[i++];
            else
                S[i + j] = S2[j++];

        }

        long end = System.nanoTime();
        return end - start;
    }
    //quick sort works by choosing a random index in the array and making it our pivot after that we make pointer to the left and to the right of the pivot after that we take everything that is smaller than  the pivot to the left and everything bigger to the right
    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b){
        long start=System.nanoTime();
        if(a>=b){// recursion base case, if the left and right pointers are equal or left is bigger than right return 1
            return 1;
        }
        T pivot=s[b]; //we are making our pivot be the element at index b
        int left=a;// a pointer
        int right=b-1; // right is the index before the pivot
        T temp;
        while(left<=right){//while the left pointer is smaller or equal than the right pointer
            while (left<=right && s[right].compareTo(pivot)<0)//while the left pointer is smaller or equal to the right pointer and the right pointer is bigger than the pivot
                left++;//incrementing left by one because it is in the correct position
                while(left<=right && s[right].compareTo(pivot)>0)//while the left pointer is smaller or equal to the right pointer and the right pointer is smaller than the pivot
                    right--;//decrement right by one if the condition is satisfied so that we will make it go to the correct position before the pivot
                if(left<=right){
                    //here we are swapping the indices to their correct position
                    temp=s[left];
                    s[left]=s[right];
                    s[right]=temp;
                    left++; right--;
                }
        }
        temp=s[left];
        s[left]=s[b];
        s[b]=temp;
        quickSort(s,a,left-1);//recursion call
        quickSort(s,left+1,b);//recursion call
        long end=System.nanoTime();
        return end-start;
    }
    //this is a method  extracts the ith digit from a decimal number
    public static Integer findDigit(int number, int i) {
        int target = 0;
        for (int k = 0; k <= i; k++) {
            target = number % 10;
            number = number / 10;
        }
        return target;
    }
    //the way bucket sort works is that it groups the elements by a specified digit which is known as key
    public static long bucketSort(Integer[] a, int first, int last, int maxDigits){//max digits is the maximum number of digits an element has
        long start=System.nanoTime();
        Vector<Integer>[] bucket = new Vector[10];//creating ten buckets using vector

        //instantiating each bucket;
        for (int i = 0; i < 10; i++) {
            bucket[i] = new Vector<>();
        }
        for (int i = 0; i < maxDigits; i++) {
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();//clearing the vector buckets
            }
                //Placing a[index] at end of bucket[digit]
                for (int index = first; index <= last; index++) {
                    Integer digit = findDigit(a[index], i);
                    bucket[digit].add(a[index]);
                }
            //placing all the buckets back into the array
                int index = 0;
                for (int m = 0; m < 10; m++) {
                    for (int n = 0; n < bucket[m].size(); n++) {
                        a[index++] = bucket[m].get(n);

                    }
                }

        }
        long end=System.nanoTime();
        return end-start;
        }
    public static void header(int Num) {//Having an int parameter to input the number you want
        System.out.println("=============================");
        System.out.println("Lab Assignment " + Num + "-Q1" + "\nPrepared by: Isra Elwazir" + "\nStudent number: 251132469" + "\nGoal of this Exercise: Testing execution time for different sorting methods");
        System.out.println("=============================");

    }
    public static void footer ( int Num){//An int parameter again to input the lab number
        System.out.print("\n=============================");
        System.out.println("\nCompletion of Lab Assignment" + Num + "-Q1 is successful!");
        System.out.println("Signing off-Isra");
        System.out.println("=============================");
    }
}
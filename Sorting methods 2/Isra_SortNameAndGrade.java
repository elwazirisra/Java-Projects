package LA2Q1;

import LA2Q2.StudentGrade;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class Isra_SortNameAndGrade {
    public static void main(String[] args) {
        header(2);

        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny","Draco", "Dean", "Fred"}; //A string array of all the first names of the students
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley", "Malfoy", "Thomas", "Weasley"};//A string array of all the last names of our students
        //An integer array of all the grades of the students
        Integer[] grd = {(int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26)};

        //making 8 object of Student grade class for the 8 students
        StudentGrade s1 = new StudentGrade("Hermione", "Granger", grd[0]);
        StudentGrade s2 = new StudentGrade("Ron", "Weasley", grd[1]);
        StudentGrade s3 = new StudentGrade("Harry", "Potter", grd[2]);
        StudentGrade s4 = new StudentGrade("Luna", "Lovegood", grd[3]);
        StudentGrade s5 = new StudentGrade("Ginny", "Weasley", grd[4]);
        StudentGrade s6 = new StudentGrade("Draco", "Malfoy", grd[5]);
        StudentGrade s7 = new StudentGrade("Dean", "Thomas", grd[6]);
        StudentGrade s8 = new StudentGrade("Fred", "Weasley", grd[7]);

        //using vector because we want to take advantage of the copyInto method it has
        Vector<StudentGrade> sg = new Vector<>();
        //adding the object we created above to vector
        sg.add(s1);
        sg.add(s2);
        sg.add(s3);
        sg.add(s4);
        sg.add(s5);
        sg.add(s6);
        sg.add(s7);
        sg.add(s8);
        System.out.println("The Unsorted Array ................\n"  +sg+"\b"); //printing out the unsorted vector list of the students

        Collections.sort(sg);//collections.sort will sort the data based on the compareTo method it is given, so in this case it will sort based on the ascending order of the grades
        System.out.println("\nSorted by Grades...................\n" + sg+"\b");//printing out the sorted list

        StudentGrade[] studentReport = new StudentGrade[fnArray.length];//making an array of type Student grade and giving it the size of the fistNames array length
        sg.copyInto(studentReport);//copying vector to the studentReport array i created on top


        insertionSort(studentReport, 1);//giving insertion the array that we copied vector to and we are giving it 1 as key so that it prints out the list based on first names
        System.out.println("\nSorted by First Names .............");
        printArray(studentReport);//printing out using printArray method and we give it the array

        insertionSort(studentReport, 2);//giving insertion method the array and the key 2 to print out the names based on last names
        System.out.println("\nSorted by Last Names...............");
        printArray(studentReport);//printing out using printArray method and we give it the array

        footer(2);

    }
    //the way insertion method works is that it removes one element from the list, finds the best location for it and inserts it back to the list
    //insertion is a stable sorting method, this means that it can sort things based on two keys
    public static <T extends Comparable<? super T>> void insertionSort(StudentGrade[] a, Integer k) {
        StudentGrade[] array = a;
        int i = 0;
        int j = 0;
        if (k == 1) {//if the key is equal to 1 it will sort based on first name
            for (i = 0; i < array.length; i++) {///the first loop
                StudentGrade key = array[i];//specifying where the key is
                for (j = i - 1; j >= 0 && array[j].getFirstName().compareTo(key.getFirstName()) > 0; j--) {//compares the first names
                    array[j + 1] = array[j];
                }
                array[j + 1] = key;
            }
        }
        //same code of block as above but this is for last names
        if (k == 2) {
            for (i = 0; i < array.length; i++) {
                StudentGrade key = array[i];//specifying where the key is
                for (j = i - 1; j >= 0 && array[j].getLastname().compareTo(key.getLastname()) > 0; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = key;
            }
        }

    }

    public static void printArray(StudentGrade[] array) {//printing out the arrays using a for loop
        for(int i =0; i< array.length; i++){
            System.out.printf("%8s %8s\t:\t%d\n", array[i].getFirstName(), array[i].getLastname(),array[i].getGrade());

        }
    }

    public static void header(int Num) {//Having an int parameter to input the number you want
        System.out.println("=============================");
        System.out.println("Lab Assignment " + Num + "-Q2" + "\nPrepared by: Isra Elwazir" + "\nStudent number: 251132469" + "\nGoal of this Exercise: Testing execution time for different sorting methods");
        System.out.println("=============================");

    }
    public static void footer ( int Num){//An int parameter again to input the lab number
        System.out.print("\n=============================");
        System.out.println("\nCompletion of Lab Assignment" + Num + "-Q2 is successful!");
        System.out.println("Signing off-Isra");
        System.out.println("=============================");
    }

}

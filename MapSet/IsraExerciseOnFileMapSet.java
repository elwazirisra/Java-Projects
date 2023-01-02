package LE4Q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class IsraExerciseOnFileMapSet {
    public static void main(String[] args) throws FileNotFoundException {

       header(4);
        File students = new File("/Users/israelwazir/Desktop/SE2205Students.txt");
        Scanner scan = new Scanner(students);


        print(LastNames(scan));
        scan = new Scanner(students);
        print(firstNames(scan));
        footer(4);

    }

    public static Map<String, Integer> LastNames(Scanner sc) {
        Map<String, Integer> lastNmap = new TreeMap<>();
        while (sc.hasNext()) {
            String string = sc.nextLine();
            String[] name = string.split(" ");
            String lName = name[0];
            if (!(lastNmap.containsKey(lName))) {
                lastNmap.put(lName, 1);
            } else {
                int value = lastNmap.get(lName) + 1;
                lastNmap.put(lName, value);
            }


        }

        System.out.println("List of the Number of students with the same Last Names: ");
        System.out.println("Last-name                 numbers");
        System.out.println("-----------------------------------");

        sc.close();
        return lastNmap;

    }

    public static Map<String, Integer> firstNames(Scanner sc) {
        Map<String, Integer> firstNmap = new TreeMap<>();
        while (sc.hasNext()) {
            String strings = sc.nextLine();
            String[] firstN = strings.split(" ");
            String fN = firstN[firstN.length-1];
            if (!(firstNmap.containsKey(fN))) {
                firstNmap.put(fN, 1);
            } else {
                int value = firstNmap.get(fN) + 1;
                firstNmap.put(fN, value);
            }
        }
        System.out.println("                                    ");
        System.out.println("List of the Number of students with the same First Names:");
        System.out.println("First-name                  numbers");
        System.out.println("------------------------------------");

        sc.close();
        return firstNmap;
    }

    public static void print(Map<String, Integer> names) {
        Set<Map.Entry<String, Integer>> nms = names.entrySet();
        String format = "%-30s%s%n";
        for (Map.Entry<String, Integer> k : nms) {
            if (k.getValue() > 1)

                System.out.printf(format, k.getKey(), k.getValue());
        }
    }

    public static void header(int Num) {//Having an int parameter to input the number you want
        System.out.println("=============================");
        System.out.println("Lab Exercise " + Num + "-Q1" + "\nPrepared by: Isra Elwazir" + "\nStudent number: 251132469" + "\nGoal of this Exercise: using Java Maps");
        System.out.println("=============================");

    }
    public static void footer ( int Num){//An int parameter again to input the lab number
        System.out.print("=============================");
        System.out.println("\nCompletion of Lab Exercise " + Num + "-Q1 is successful!");
        System.out.println("Signing off-Isra");
        System.out.println("=============================");
    }
}
























package LE3Q1;

import java.sql.SQLOutput;

public class Driver_DoublyLinkedList {
    public static void main(String[] args){
        DoublyLinkedList<MyStudent> Isra= new DoublyLinkedList();
       // MyStudent s0=new MyStudent();
       // MyStudent s1=new MyStudent("Harry", 67.50);
        //MyStudent s2=new MyStudent("Luna", 87.5);
        MyStudent s3=new MyStudent("Vincent",60.5);
        MyStudent s4=new MyStudent("Hermione", 89.2);



        Isra.addLast(new MyStudent());
        Isra.addLast(new MyStudent("Harry",67.8));
        Isra.addLast(new MyStudent("Luna",60.5));
        Isra.addLast(s3);

        header(3);

        System.out.println("Adding 4 students to the list");
        System.out.println("List Content: ");
        System.out.println(Isra);

        Isra.addBetween(s4,Isra.findNode(new MyStudent()),Isra.findNode(s3));
        System.out.println("Adding Hermione to the list in between Luna and Vincent.....");
        System.out.println("The List Content:");
        System.out.println(Isra);
        footer(3);
    }
    public static void header ( int Num){//Having an int parameter to input the number you want
        System.out.println("=============================");
        System.out.println("Lab Assignment " + Num + "-Q1" + "\nPrepared by: Isra Elwazir" + "\nStudent number: 251132469" + "\nGoal of this Exercise: practicing doubly linked lists");
        System.out.println("=============================");

    }
    public static void footer ( int Num){//An int parameter again to input the lab number
        System.out.print("=============================");
        System.out.println("\nCompletion of Lab Assignment " + Num + "-Q1 is successful!");
        System.out.println("Signing off-Isra");
        System.out.println("=============================");
    }
}

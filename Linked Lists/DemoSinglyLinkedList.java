package LA1Q1;


import java.util.ArrayList;

import java.util.Arrays;//for the Arrays.asList

import java.util.Scanner;

public class DemoSinglyLinkedList {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(56, -22, 34, 57, 98));//An arraylist of numbers
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Griffin", "Will", "Isra", "Delaney", "Madison"));//arraylist of names

        header(1);// calling the header and passing it the number of the lab

        System.out.println("\n"+"The given Integer array: " + nums);//prints out the arraylist of numbers
        System.out.println("The given String array: " + names);//prints out the arraylist of names


        SinglyLinkedList<Integer> numbers = new SinglyLinkedList<>();//declaring a linked list and naming it numbers
        for (int i = 0; i < 3; i++) {//populating the linked list with the numbers in the arraylist
            numbers.addFirst(nums.get(i));
        }


        numbers.addLast(nums.get(4));//adding the last two elements in a different order and we are using the addLast method that adds a node to the end of the linked list
        numbers.addLast(nums.get(3));
        System.out.println("Your Integer List " + numbers);//printing out the linked list using the toString method that is in SinglyLinkedList class. toString method overrides this


        SinglyLinkedList<String> strings = new SinglyLinkedList<>();//populating the linked list with names in the arraylist
        for (int i = 0; i < 3; i++) {
            strings.addFirst(names.get(i));
        }
        strings.addLast(names.get(4));
        strings.addLast(names.get(3));
        System.out.println("Your String List " + strings + "\n");//printing out the linked list using the toString method that is in SinglyLinkedList class. toString method overrides this

        System.out.println("Stack demo with the Integer linked list ...");
        stackDemo(numbers);//
        System.out.println("\n" + "Queue demo with the String linked list ...");
        queueDemo(strings);


        System.out.println("\n" + "Let's search the stack...");
        System.out.println("The current stack:" + numbers);//prints out the stack representation of the linked list

        char yes= 'y';
        while(yes=='y') {//this will restart the stackdemo if the user says yes
            System.out.println("Enter the value you are searching for:");
            int choice = input.nextInt();
            if (numbers.searchStack(choice) == 0) {//validates if the user's input is in the stack
                System.out.println("The value is not found!");

                System.out.println("Do you want to continue? (enter 'y' for yes or enter any other key to discontinue): ");
                yes = input.next().charAt(0);

            } else {
                System.out.println("The value " + choice + " is found in location " + numbers.searchStack(choice) + " from the top of the stack");
            }
        }
        footer(1);//calls the footer method and we pass in 1 as the lab number
    }

    public static Scanner input = new Scanner(System.in);

    public DemoSinglyLinkedList() {
    }

    public static void stackDemo(SinglyLinkedList list) {//this is the stack version of the linked list. This means the linked lists could be treated as stacks or queues

        int user;
        while (true) {
            try {//this is to validate that the user inputs the correct integer values
                System.out.println("Which end of the Linked List you would like to use as the stack top?" + "\n" +
                        "Enter 1 for head and 2 for tail:");
                user = input.nextInt();
                if (user < 1 || user > 2) {
                    throw new Exception();//everytime the user puts in something tht is not one or two they will be asked again for a value
                }
                break;
            } catch (Exception e) {
                input.nextLine();//cleaning the buffer
            }
        }
        if (user == 1) {//if the user enters 1 then this block of code will be excuted
            System.out.println("Stack Top: Head of the linked list" + "\n");
            System.out.println("Let's pop all the elements in the stack in sequence:");
            System.out.print("The current Stack:");
            System.out.println(list + "\n");


            while (list.getSize() != 0) {//makes sure the stack is not empty
                System.out.println(list.popFromHead() + " has been popped! The revised stack is:" + list);//will pop the first element in the head
            }

            System.out.println("\n" + "Let's push 39 and -58 in the stack...");
            System.out.println("The current stack:" + list);
            list.pushAtHead(39);//pushing the value we want into the front of the stack
            System.out.println("After 39 is pushed, the revised stack:" + list);
            list.pushAtHead(-58);
            System.out.println("After -58 is pushed, the revised stack: " + list);


        }

        if (user == 2) {// this will execute when the user enters 2
            System.out.println("\n" + "Stack top: Tail of the linked list");
            System.out.println("\n" + "Let's pop first three elements from the stack in sequence: ");
            System.out.println("The current stack is: " + list);


            System.out.println("\n" + list.popFromTail() + " has been popped! The revised stack: " + list);

            System.out.println(list.removeLast()+" has been popped! The revised stack: "+list);
            System.out.println(list.removeLast()+" has been popped! The revised stack: "+ list);

            System.out.println("\n"+ "Let's push 39 and -58 in the stack ....");
            list.pushAtTail(39);//pushing or addingLast to the end of the stack
            System.out.println("After 39 is pushed, the revised stack: "+list);
            list.pushAtTail((-58));
            System.out.println("After 58 is pushed, the revised stack: "+list);


        }

    }


        public static void queueDemo (SinglyLinkedList queue){//queue version of the linked list
            System.out.println("Note: Head is the Q-front, and Tail is the Q-rear");
            System.out.println("\n" + "Let's enqueue Joelle and Lukas in the queue in sequence ....");
            System.out.println("\n" + "The current Queue: " + queue);

            queue.enqueueAtTail("Joelle");//adding a name to th end of the queue
            System.out.println("After Joelle is enqueued, the revised Queue: " + queue);
            queue.enqueueAtTail("Lukas");
            System.out.println("After Lukas is enqueued, the revised Queue: " + queue);

            System.out.println("\n" + "Let's dequeue first three elements from the queue in sequence ....");
            System.out.println("The current Queue: " + queue);

            queue.dequeueAtHead();//removing names from the start of the list
            System.out.println("\n" + "Isra has been dequeued!The revised queue: " + queue);
            queue.dequeueAtHead();
            System.out.println("Will has been dequeued! The revised queue: " + queue);
            queue.dequeueAtHead();
            System.out.println("Griffin has been dequeued! The revised queue: " + queue);
        }
    public static void header ( int Num){//Having an int parameter to input the number you want
        System.out.println("=============================");
        System.out.println("Lab Assignment " + Num + "-Q1" + "\nPrepared by: Isra Elwazir" + "\nStudent number: 251132469" + "\nGoal of this Exercise: understanding how linked lists work");
        System.out.println("=============================");
        System.out.printf("This program takes two arraylists and converts them into linked lists and then according to the user's input it " +
                "takes ypu to the head or the tail of the linked list, after that it pops out or pushes in elements out of or into the list.\n");
    }
    public static void footer ( int Num){//An int parameter again to input the lab number
        System.out.print("=============================");
        System.out.println("\nCompletion of Lab Assignment " + Num + "-Q1 is successful!");
        System.out.println("Signing off-Isra");
        System.out.println("=============================");
    }
}








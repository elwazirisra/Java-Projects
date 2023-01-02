package LA1Q1;

public class Node <T>{
    private T element; //a private field of an element of type T
    private Node<T> next; // private field of a node

    public Node(){//empty constructor
    }
    public Node (T e, Node<T> n){ //constructor that has two parameters one parameter is of type T and the other is of type node
        element=e;//holds the element in the node
        next=n;//hold the address of thr next node
    }
    public Node<T> getNext(){// gets the address of the next node. For example head.getNext means the node that is right after the head
        return next;
    }
    public T getElement(){ //gets the element in the node. For example head.getElement will return the element that is in the first node
        return element;
    }
    public void setNext(Node<T> n){//has a parameter of type node and this sets the address of the next node, for example if we have head.setNext(null) this will make head point to null
     this.next=n;
    }
}

package LA1Q1;



public class SinglyLinkedList <T> {
    private Node<T> head;//creating a field that is a node. The head is the first node in the linked list. Nodes in singleLinked lists carry an element and an address pointing to the next node
    private Node<T> tail;// this is also a node that is the last node in the list, since it is the last node it will point to null
    private int size;//help us keep track of the size of our linked list

    public SinglyLinkedList() {//an empty constructor
        head = null;
        tail = null;
        size = 0;
    }

    public SinglyLinkedList(Node<T> h, Node<T> t, int sz) {//a constructor with parameters that are two nodes and an integer value of type size
        head = h;
        tail = t;
        size = sz;
    }
    public int getSize() {//return the size of the list
        return size;
    } //returns the size of the list
    public Boolean isEmpty() {
        return size == 0;
    } //if the list is empty then this means that the size is 0

    @Override public String toString() { //This helps us print out the list
        String retStr = "[";

        Node<T> current = head;//creating a new node and making it point at the head
        while (current != null) {//makes sure that it goes to that last node but not beyond that. This allows us to loop through the whole list and get the elements we want and the addresses we need.
            retStr += current.getElement() + ", ";
            current = current.getNext();// we are updating the current node so it loops till the end of the list
        }
        retStr += "\b\b]";
        return retStr;//returning the string. This can print a linked list
    }


    public void addFirst(T e) {
        head = new Node(e, head); //Here we made a new node and we gave it an element and the address to the old node. this means that this node is going to point to the address of the old head making the new head the head of the list and the old head the second first node.
        if (isEmpty()) {//if the list is empty then the tail and the head are equal
            tail = head;}
        size++;// size is going to be incremented by adding a node.

    }

    public void addLast(T e) {
        Node<T> newest = new Node<>(e, null); //creating a new node that would be the last node of the link. This means that we will give this node the new element and since it will be the last node so it will point to null.
        if (isEmpty()) {
            head = newest;// if the list was empty then the head will be the tail because it will be the only element in the list
        } else {
            tail.setNext(newest);//if the list is not empty then set newest to be the tail
            tail = newest;//making the newest node our tail
        }
            size++;//increasing the size because now we have a bigger list
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;//if the list is empty then there is nothing to remove ,so we return null
        }

        T returnElement = head.getElement();// returns the element of the old head
        head = head.getNext();//making the second first node the new head
        size--;// decreasing the size because we want the list to shrink once the first node is removed.
        return returnElement; // this returns the element that was in the head we removed
    }

    public T removeLast() {// removing the node in the list
        T valueT;
        Node <T> current=head;
        while(current.getNext()!=tail){//this will start from the head of the list and reach the node that is right before the tail
            current=current.getNext();// this updates the current node till it is at the node that is right before the tail
        }
        valueT= tail.getElement();//this saves element that was in the tail
        size--;//decreasing the size of the list
        tail=current;//making the current node be the tail
        current.setNext(null);//the current node that is the tail now will point to null since it is the last node in the list
        return valueT;//returns the saved element
    }


    public void pushAtHead(T element){ // this is exactly the same as the addFirst method. Push is for the stack represented by the linked list.
        addFirst(element);


    }
    public T popFromHead() {//This is exactly the same as remove first. For stack representation by linked lists
        T elementFromHead = removeFirst();
        return elementFromHead;
    }



    public void pushAtTail(T element){
        addLast(element);}//pushes and element at the end of the stack. This is the same as add last method
    public T popFromTail() {//same as remove last method
        T elementFromTail = removeLast();
        return elementFromTail;
            }
    public void enqueueAtTail(T rear){
        addLast(rear);
    } //same as the add last method this is a queue  representation of the linked list
    public T dequeueAtHead() {//same as remove from first method. This is a queue representation of the linked list
        return removeFirst();
    }



        public int searchStack(T element) {// searches the stack for a specific element

            int count = 0;// this will return the position of the element we are looking for if it is there
            Node<T> current = head;//making a node that is a copy od the head. this will point to the same node the head point to. this is to make sure that current starts from head
            while (current!=null) {//this will loop the linked list from the head (the first node) till the last node
                count++;// count will keep incrementing everytime the elements are not equal
                if(current.getElement()==element){//if the elements are not equal count will never be returned and 0 will be returned
                    return count;//if the elements are equal then count will return the position where the element was found
                }
                current=current.getNext();// this will keep updating the current till it reaches to the last node then it will exit
            }
            return 0;//returns zero if element is not found

        }
   }







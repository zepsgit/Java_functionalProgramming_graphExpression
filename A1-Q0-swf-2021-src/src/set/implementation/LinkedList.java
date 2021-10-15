package set.implementation;

/**
 * Implementing a linkedList as the data structure 
 * for storing data of set
 * There are many ways for creating a set such as stringBuilder class
 * But for the sake of training my programming, I create a singly linked list.
 * We can define the method we need inside the LinkedList class which let us
 * implement the functionalities flexibly.
 */
 class LinkedList {
    Node head = null;//head node
    /**
     * The node of linkedList
     * data is the value of node
     * next is the reference of next node
     */
    class Node {
        Node next = null;//reference of next node
        Integer data;

        //constructor 
        Node(Integer x) {
            this.data = x;
        }
    }
    /**
     * add new node
     * @param x The data inserted into the new node
     * @requires x is Integer type
     * @return new Node type
     */
    void addNode(Integer x) {
        Node newNode = new Node(x);//instantiate a Node
        if (head == null) {
            head = newNode;
            return;
        }
        //otherwise head!=null
        Node temp = head;
        //traverse list
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    /**
     * delete node
     * @param Integer x the value to be deleted
     * @return a list without value x
     */
    void deleteNode(Integer x) {
        Node temp = head;
        Node pre = head;
        while (temp != null) {
             pre = temp;
             if (temp.data != x) {
                 temp = temp.next;
             }
             else {
                if (pre == head) {
                    head = pre.next;
                    temp=head;
                    pre.next = null;
                }
                else {
                    pre.next = temp.next;
                    temp.next = null;
                    temp = pre.next;
                }
            }
           
        }
        
    }
    /**
     * @return the length of List
     */
    int length() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
    /**
     * Print List for test
     */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    /*
    public static void main(String args[]) {
        LinkedList myList = new LinkedList();
        myList.addNode(8);
        myList.addNode(7);
        myList.addNode(3);
        myList.printList();
    }
    */
}

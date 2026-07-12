//1. Understand Linked Lists
//        Singly Linked List
//
//        Each node contains:
//
//        Data
//        Pointer to the next node
//
//        Traversal is only in the forward direction.

//Doubly Linked List
//
//        Each node contains:
//
//        Previous pointer
//        Data
//        Next pointer
//
//        Traversal is possible in both directions.



package Week_1.module2.Exercise5_Task_Management_System;


class Task{
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status){
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString(){
        return taskId + " " + taskName + " " + status;
    }
}

class Node{
    Task task;
    Node next;

    public Node(Task task){
        this.task = task;
        this.next = null;
    }
}

class SinglyLinkedList {

    Node head;

    // Add Task
    public void add(Task task) {

        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Search Task
    public Task search(int id) {

        Node current = head;

        while (current != null) {

            if (current.task.taskId == id)
                return current.task;

            current = current.next;
        }

        return null;
    }

    // Traverse
    public void display() {

        Node current = head;

        while (current != null) {

            System.out.println(current.task);

            current = current.next;
        }
    }

    // Delete Task
    public void delete(int id) {

        if (head == null)
            return;

        if (head.task.taskId == id) {

            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null &&
                current.next.task.taskId != id) {

            current = current.next;
        }

        if (current.next != null)
            current.next = current.next.next;
    }
}
public class Main {

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.add(new Task(1, "Design UI", "Pending"));
        list.add(new Task(2, "Develop Backend", "In Progress"));
        list.add(new Task(3, "Testing", "Pending"));

        System.out.println("Tasks:");

        list.display();

        System.out.println("\nSearching:");

        System.out.println(list.search(2));

        list.delete(1);

        System.out.println("\nAfter Deletion:");

        list.display();
    }
}

//        | Operation | Complexity |
//        | --------- | ---------- |
//        | Add       | O(n)       |
//        | Search    | O(n)       |
//        | Traverse  | O(n)       |
//        | Delete    | O(n)       |
//
//                Advantages of Linked Lists over Arrays
//                Dynamic size.
//                Easy insertion and deletion.
//                No need for contiguous memory.
//                Better memory utilization for frequently changing data.
//
//                When to Use Linked Lists
//                When the number of elements changes frequently.
//                When frequent insertions and deletions are required.
//                When contiguous memory allocation is difficult.

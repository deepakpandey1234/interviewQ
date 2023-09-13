import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Implement a Stack using a LinkedList, utilizing the interfaces and classes below.
*/

public class StackRunner {

    interface MyStack {
        // phase 1
        void push( int value);
         int pop();
         int peek();
         int length();
        boolean isEmpty();
        void clear();
        // phase 2
        void push( int... values);
        void reverse();
    }
    
    class RealStack implements MyStack {
        
        LinkedList link=new LinkedList();
        int globalCount=0;
        
        public void push( int value) {
            LinkedList.Node node=link.new Node(value);
            node.next=link.head;
            link.head=node;
            globalCount++;
        }
        
        public  int pop() {
            if(globalCount==0){
                return -1;
            }
            LinkedList.Node temp=link.head;
            link.head=link.head.next;
            globalCount--;
            return temp.data;
        }
        
        public int peek() {
            if(link.head==null){
                return -1;
            }
            return link.head.data;
        }
        
        public  int length() {
            // LinkedList.Node temp=link.head;
            // int count=0;
            // while(temp!=null){
            //     count++;
            //     temp=temp.next;
            // }
            return globalCount;
        }
        
        public boolean isEmpty() {
            if(link.head==null){
                return true;
            }
            return false;
        }
        
        public void clear() {
            link.head=null;
            globalCount=0;
        }
        
        public void push( int... values) {
            for(int val:values){
               push(val);
            }
        }
        
        public void reverse() {
            /*
            LinkedList.Node curr=link.head;
            LinkedList.Node prev=null;
            LinkedList.Node next=null;
            
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev =curr;
                curr=next;
            }
            link.head=prev;*/
            RealStack newstack = new RealStack();//O(n)
            while(link.head != null) {
                newstack.push(pop());
            }
            link = newstack.link;
        }
        
    }
    
    class LinkedList {
        Node head; // head of list
 
        /* Linked list Node*/
        class Node {
            int data;
            Node next;
    
            // Constructor to create a new node
            // Next is by default initialized
            // as null
            Node(int d) { 
                data = d; 
            }
             Node(int d,Node next) { 
                data = d; 
                this.next=next;
            }
        }
    }
    
   public static void main(String[] args) {
       StackRunner sr = new StackRunner();
       sr.run();
   }
   
   private void run() {
       StackRunner.MyStack stack = new StackRunner.RealStack();
       // phase 1
        if ((!stack.isEmpty()))
            throw new AssertionError();
        stack.push(1);
        if ((stack.isEmpty()))
            throw new AssertionError();
        if ((stack.peek() != 1))
            throw new AssertionError();
        if ((stack.length() != 1))
            throw new AssertionError();
        stack.push(2);
        if ((stack.peek() != 2))
            throw new AssertionError();
        if ((stack.length() != 2))
            throw new AssertionError();
        if ((stack.pop() != 2))
            throw new AssertionError();
        if ((stack.length() != 1))
            throw new AssertionError();
        if ((stack.peek() != 1))
            throw new AssertionError();
        stack.push(3);
        if ((stack.peek() != 3))
            throw new AssertionError();
        if ((stack.length() != 2))
            throw new AssertionError();
        stack.push(4);
        if ((stack.peek() != 4))
            throw new AssertionError();
        if ((stack.length() != 3))
            throw new AssertionError();
        stack.push(5);
        if ((stack.peek() != 5))
            throw new AssertionError();
        if ((stack.length() != 4))
            throw new AssertionError();
        if ((stack.pop() != 5))
            throw new AssertionError();
        if ((stack.length() != 3))
            throw new AssertionError();
        if ((stack.pop() != 4))
            throw new AssertionError();
        if ((stack.length() != 2))
            throw new AssertionError();
        if ((stack.peek() != 3))
            throw new AssertionError();
        stack.push(6);
        if ((stack.length() != 3))
            throw new AssertionError();
        if ((stack.peek() != 6))
            throw new AssertionError();
        stack.clear();
        if ((stack.length() != 0))
            throw new AssertionError();
        if ((!stack.isEmpty()))
            throw new AssertionError();
        stack.pop();
        if ((stack.length() != 0))
            throw new AssertionError();
        if ((!stack.isEmpty()))
            throw new AssertionError();
        // phase 2
        stack.push(1,2,3);
        if ((stack.pop() != 3))
            throw new AssertionError();
        if ((stack.pop() != 2))
            throw new AssertionError();
        if ((stack.pop() != 1))
            throw new AssertionError();
        stack.push(1,2,3);
        stack.reverse();
        if ((stack.pop() != 1))
            throw new AssertionError();
        if ((stack.pop() != 2))
            throw new AssertionError();
        if ((stack.pop() != 3))
            throw new AssertionError();
   }
}

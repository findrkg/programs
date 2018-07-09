package mycode.dsalgo.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MergeTwoLinkedList {
	static Node mergeLists(Node headA, Node headB) {
	     // This is a "method-only" submission. 
	     // You only need to complete this method 
		if(headA == null) {
			return headB;
		}
		if(headB == null) {
			return headA;
		}
	    Node head = null;
	    Node result = null;
	    if(headA.data <= headB.data) {
	    	head = headA;
	    	headA = headA.next;
	    }
	    else {
	    	head = headB;
	    	headB = headB.next;
	    }
	    result = head;
	    while(headA != null && headB != null) {
	        if(headA.data <= headB.data) {
	    		head.next = headA;
	            headA = headA.next;
	        }
	        else {
	    		head.next = headB;
	            headB = headB.next;
	        }
	        head = head.next;
	    }
	    if(headA != null && headB == null) {
	        head.next = headA;
	    }
	    if(headB != null && headA == null) {
	        head.next = headB;
	    }
	    return result;
	}

    public static void main(String[] args) {
    	Node h1 = new Node(1, new Node(3, new Node(5, null)));
    	Node h2 = new Node(2, new Node(4, new Node(6, null)));
    	Node rh = mergeLists(h1, h2);
    	while(rh != null) {
    		System.out.print(rh.data+" ->");
    		rh = rh.next;
    	}
    }
}

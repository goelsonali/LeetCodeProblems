package leetcode.patterns.tortoise.hare;

//141. Linked List Cycle
//Given head, the head of a linked list, determine if the linked list has a cycle in it.
//
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
// Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
//Return true if there is a cycle in the linked list. Otherwise, return false.
//Input: head = [3,2,0,-4], pos = 1
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
//Input: head = [1,2], pos = 0
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
public class LinkedListCycle {
    //a. Define ListNode object
    //b. set a slow pointer on node 1
    //c. set a fast pointer on node 3
    //d. while next node keep looping otherwise if

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = head.next;
            fast = head.next.next;
            head = slow;
            if(fast.equals(slow))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4,null);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        System.out.println("Cycle exists ? - " + hasCycle(node1));

    }

    static class ListNode {
        int val; // Node value
        ListNode next; // Pointer to the next node

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

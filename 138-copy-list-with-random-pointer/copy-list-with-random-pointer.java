/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node curr = head;
        //Step 1: Insert Elements between them

        while(curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        curr = head;

        // Step 2: Assign Random Pointers on Copied Node 

        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node dummy = new Node(-1);
        Node copyCurr = dummy;

        //Step 3: Separate Original From Copied Nodes

        while(curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;
            copyCurr.next = copy;
            copyCurr = copy;
            curr = curr.next;
        }
        return dummy.next;
    }
}
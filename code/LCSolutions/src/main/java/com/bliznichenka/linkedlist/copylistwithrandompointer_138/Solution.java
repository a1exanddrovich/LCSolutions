package com.bliznichenka.linkedlist.copylistwithrandompointer_138;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // We can avoid using extra space for old_node ---> new_node mapping
    // by tweaking the original linked list. Simply interweave the nodes
    // of the old and copied list.
    // For example: Old List: A --> B --> C --> D
    // Interweaved List: A --> A' --> B --> B' --> C --> C' --> D --> D'
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNew = new HashMap<>();
        oldToNew.put(null, null);

        Node curOld = head;
        Node copiedHead = new Node(-1);
        Node curNew = copiedHead;

        while (curOld != null) {
            curNew.next = new Node(curOld.val);
            curNew = curNew.next;
            oldToNew.put(curOld, curNew);
            curOld = curOld.next;
        }

        curOld = head;
        curNew = copiedHead.next;
        while (curOld != null) {
            curNew.random = oldToNew.get(curOld.random);
            curOld = curOld.next;
            curNew = curNew.next;
        }

        return copiedHead.next;
    }
}

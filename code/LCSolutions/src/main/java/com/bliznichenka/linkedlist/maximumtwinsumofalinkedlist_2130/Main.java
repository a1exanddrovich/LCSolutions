package com.bliznichenka.linkedlist.maximumtwinsumofalinkedlist_2130;

import com.bliznichenka.linkedlist.ListNode;
import com.bliznichenka.linkedlist.ListNodeUtils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode list = ListNodeUtils.fromList(List.of(5, 4, 2, 1)); // len must be even by the description
        System.out.println(s.pairSum(list));
    }

}

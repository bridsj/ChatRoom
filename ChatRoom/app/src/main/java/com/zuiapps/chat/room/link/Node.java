package com.zuiapps.chat.room.link;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by dengshengjin on 15/12/13.
 */
public class Node {
    private Stack mStack;
    private Queue mQueue;
    private LinkedList mLinkedList;

    private void sort() {
        Collections.sort(mLinkedList, new Comparator() {
            @Override
            public int compare(Object lhs, Object rhs) {
                return 0;
            }
        });

    }
}

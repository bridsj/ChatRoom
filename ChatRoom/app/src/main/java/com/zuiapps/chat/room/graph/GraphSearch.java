package com.zuiapps.chat.room.graph;

import java.util.Queue;

/**
 * Created by dengshengjin on 15/12/18.
 */
public class GraphSearch {
    private int[][] mMatrix;//边
    private int[] mNodes;//结点

    public GraphSearch(int[][] matrixs, int[] nodes) {
        mMatrix = matrixs;
        mNodes = nodes;
    }

    //深度遍历
    public void depthSearch(int index) {
        if (mMatrix[index][index] == 1) {
            return;
        }
        mMatrix[index][index] = 1;//标记看过
        System.out.println(mNodes[index] + ",");
        for (int j = 0; j < mNodes.length; j++) {
            if (index == j) {
                continue;
            }
            if (mMatrix[index][j] == 1) {
                depthSearch(j);
            }
        }
    }

    public void boardSearch(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) {
            return;
        }
        int index = queue.poll().intValue();
        if (mMatrix[index][index] == 1) {
            boardSearch(queue);
            return;
        }
        mMatrix[index][index] = 1;
        System.out.println(mNodes[index] + ",");
        for (int j = 0; j < mNodes.length; j++) {
            if (index == j) {
                continue;
            }
            if (mMatrix[index][j] == 1 && mMatrix[j][j] != 1) {
                queue.offer(j);
            }
        }
        boardSearch(queue);
    }

}

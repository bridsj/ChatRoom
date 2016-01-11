package com.zuiapps.chat.room.binaryTree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by dengshengjin on 15/12/17.
 * @link
 * @author
 */
public class BinaryTree {
    private TreeNode mRootNode;

    public TreeNode getRootNode() {
        return mRootNode;
    }


    public void createTree(int[] intArr) {
        for (int intValue : intArr) {
            insert(intValue);
        }
    }

    private void insert(int value) {
        if (mRootNode == null) {
            mRootNode = new TreeNode(value);
            mRootNode.mTreeType = TreeNode.TreeType.ROOT;
        } else {
            TreeNode currNode = mRootNode;
            while (true) {
                if (value < currNode.mValue) {
                    TreeNode tmpNode = currNode;
                    currNode = currNode.mLeftChildNode;
                    if (currNode == null) {
                        tmpNode.mLeftChildNode = new TreeNode(value);
                        tmpNode.mLeftChildNode.mTreeType = TreeNode.TreeType.LEFT;
                        break;
                    }
                } else {
                    TreeNode tmpNode = currNode;
                    currNode = currNode.mRightChildNode;
                    if (currNode == null) {
                        tmpNode.mRightChildNode = new TreeNode(value);
                        tmpNode.mRightChildNode.mTreeType = TreeNode.TreeType.RIGHT;
                        break;
                    }
                }
            }
        }
    }

    public void preBinarySearch(TreeNode node) {
        if (node != null) {
            System.out.print(node.mValue + ",");
            preBinarySearch(node.mLeftChildNode);
            preBinarySearch(node.mRightChildNode);
        }
    }

    public void middleBinarySearch(TreeNode node) {
        if (node != null) {
            middleBinarySearch(node.mLeftChildNode);
            System.out.print(node.mValue + ",");
            middleBinarySearch(node.mRightChildNode);
        }
    }

    public void postBinarySearch(TreeNode node) {
        if (node != null) {
            postBinarySearch(node.mLeftChildNode);
            postBinarySearch(node.mRightChildNode);
            System.out.print(node.mValue + ",");
        }
    }

    public void levelBinarySearch(TreeNode node) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.print(treeNode.mValue + ",");
            if (treeNode.mLeftChildNode != null) {
                queue.offer(treeNode.mLeftChildNode);
            }
            if (treeNode.mRightChildNode != null) {
                queue.offer(treeNode.mRightChildNode);
            }
        }
    }

    public TreeNode queryMin(TreeNode node) {
        TreeNode mMinNode = node;
        while (mMinNode.mLeftChildNode != null) {
            mMinNode = mMinNode.mLeftChildNode;
        }
        return mMinNode;
    }

    public TreeNode queryMax(TreeNode node) {
        TreeNode mMaxNode = node;
        while (mMaxNode.mRightChildNode != null) {
            mMaxNode = mMaxNode.mRightChildNode;
        }
        return mMaxNode;
    }

    public TreeNode queryNode(int value) {
        TreeNode tmpNode = mRootNode;
        while (tmpNode != null && tmpNode.mValue != value) {
            if (value < tmpNode.mValue) {
                tmpNode = tmpNode.mLeftChildNode;
            } else {
                tmpNode = tmpNode.mRightChildNode;
            }
        }
        return tmpNode;
    }

    public TreeNode queryParentNode(int value) {
        TreeNode tmpNode = mRootNode;
        TreeNode parentNode = mRootNode;
        while (tmpNode != null && tmpNode.mValue != value) {
            parentNode = tmpNode;
            if (value < tmpNode.mValue) {
                tmpNode = tmpNode.mLeftChildNode;
            } else {
                tmpNode = tmpNode.mRightChildNode;
            }
        }
        if (tmpNode == null) {
            parentNode = null;
        }
        return parentNode;
    }

    public int getNodeSize(TreeNode treeNode) {
        if (treeNode != null) {
            return getNodeSize(treeNode.mLeftChildNode) + getNodeSize(treeNode.mRightChildNode) + 1;
        }
        return 0;
    }

    public int getLeafNodeSize(TreeNode treeNode) {
        if (treeNode != null) {
            int leftNode = getLeafNodeSize(treeNode.mLeftChildNode);
            int rightNode = getLeafNodeSize(treeNode.mRightChildNode);
            if (treeNode.mLeftChildNode == null && treeNode.mRightChildNode == null) {
                return leftNode + rightNode + 1;
            } else {
                return leftNode + rightNode;
            }
        }
        return 0;
    }

    public int getWeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = getWeight(treeNode.mLeftChildNode);
        int right = getWeight(treeNode.mRightChildNode);
        int weight = (left > right ? left : right);
        weight += 1;
        return weight;
    }

    static class TreeNode {
        TreeType mTreeType;
        int mValue;
        TreeNode mLeftChildNode;
        TreeNode mRightChildNode;

        enum TreeType {
            ROOT, LEFT, RIGHT
        }

        public TreeNode(int value) {
            mValue = value;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof TreeNode) {
                TreeNode treeNode = (TreeNode) o;
                if (treeNode.mValue == mValue) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "mTreeType=" + mTreeType +
                    ", mValue=" + mValue +
                    ", mLeftChildNode=" + mLeftChildNode +
                    ", mRightChildNode=" + mRightChildNode +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] sourceArr = {21, 25, 16, 32, 22, 19, 13, 20};
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createTree(sourceArr);
        System.out.println("前序遍历:");
        binaryTree.preBinarySearch(binaryTree.getRootNode());
        System.out.println("\n中序遍历:");
        binaryTree.middleBinarySearch(binaryTree.getRootNode());
        System.out.println("\n后序遍历:");
        binaryTree.postBinarySearch(binaryTree.getRootNode());
        System.out.println("\n层次遍历:");
        binaryTree.levelBinarySearch(binaryTree.getRootNode());
        System.out.println("\n查询最小节点:" + binaryTree.queryMin(binaryTree.getRootNode()).toString());
        System.out.println("查询最大节点:" + binaryTree.queryMax(binaryTree.getRootNode()).toString());
        System.out.println("查询某个节点:" + binaryTree.queryNode(33));
        System.out.println("查询某个父节点:" + binaryTree.queryParentNode(33));
        System.out.println("查询节点个数:" + binaryTree.getNodeSize(binaryTree.getRootNode()));
        System.out.println("查询节点深度:" + binaryTree.getWeight(binaryTree.getRootNode()));
        System.out.println("查询叶子节点个数:" + binaryTree.getLeafNodeSize(binaryTree.getRootNode()));

    }
}

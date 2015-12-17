package com.zuiapps.chat.room.dynamic;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dengshengjin on 15/12/14.
 */
public class Pack01Problem {

    private Pack[] mSourcePacks;
    private int mMaxWeight;
    private int mNum;
    private int[][] mBestValues;// 横：重量 总：总价值
    private int mBestValue;//最有价值
    private List<Pack> mBestPacks;

    public Pack01Problem(Pack[] sourcePacks, int maxWeight) {
        mSourcePacks = sourcePacks;
        mMaxWeight = maxWeight;
        mNum = sourcePacks.length;
        if (mBestValues == null) {
            mBestValues = new int[mNum + 1][mMaxWeight + 1];
        }
    }

    public void solve() {
        System.out.println("给定背包:");
        for (Pack pack : mSourcePacks) {
            System.out.println(pack.toString());
        }
        System.out.println("最大承受重量：" + mMaxWeight);
        for (int j = 0; j <= mMaxWeight; j++) {
            for (int i = 0; i <= mNum; i++) {
                if (i == 0 || j == 0) {
                    mBestValues[i][j] = 0;
                } else {
                    if (i == 1 && j == 3) {
                        System.out.println(mBestValues[i - 1][j]+","+mSourcePacks[i - 1].getWeight());
                    }
                    if (mSourcePacks[i - 1].getWeight() > j) {
                        mBestValues[i][j] = mBestValues[i - 1][j];
                    } else {
                        int weight = mSourcePacks[i - 1].getWeight();
                        int value = mSourcePacks[i - 1].getValue();
                        mBestValues[i][j] = Math.max(mBestValues[i - 1][j], value + mBestValues[i - 1][j - weight]);
                    }
                }
            }
//            System.out.println();
        }
        if (mBestPacks == null) {
            mBestPacks = new LinkedList<>();
        }
        int tmpWeight = mMaxWeight;
        for (int i = mNum; i >= 1; i--) {
            if (mBestValues[i][tmpWeight] > mBestValues[i - 1][tmpWeight]) {
                mBestPacks.add(mSourcePacks[i - 1]);
                tmpWeight = tmpWeight - mSourcePacks[i - 1].getWeight();
            }
            if (tmpWeight == 0) {
                break;
            }
        }
        mBestValue = mBestValues[mNum][mMaxWeight];
    }

    public int getBestValue() {
        return mBestValue;
    }

    public int[][] getBestValues() {
        return mBestValues;
    }

    public List<Pack> getBestPacks() {
        return mBestPacks;
    }

    public static void main(String[] args) {
        Pack[] sourcePacks = new Pack[]{
                new Pack(1, 13), new Pack(1, 10),
                new Pack(3, 24), new Pack(2, 15),
                new Pack(4, 28), new Pack(5, 33),
                new Pack(3, 20), new Pack(1, 8)
        };
        int maxWeight = 10;
        Pack01Problem pack01Problem = new Pack01Problem(sourcePacks, maxWeight);
        pack01Problem.solve();
        System.out.println(" -------- 该背包问题实例的解: --------- ");
        System.out.println("最优值：" + pack01Problem.getBestValue());
        System.out.println("最优解【选取的背包】: ");
        System.out.println(pack01Problem.getBestPacks());
        System.out.println("最优值矩阵：个数/重量");

        int[][] bestValues = pack01Problem.getBestValues();
        for (int i = 0; i < bestValues.length; i++) {
            System.out.print("第几个背包=" + i + "\t");
            for (int j = 0; j < bestValues[i].length; j++) {
                if (i == 0) {
                    System.out.printf("weight:%-3d", j);
                } else {
                    System.out.printf("%-10d", bestValues[i][j]);
                }

            }
            System.out.println();
        }
    }

    public static class Pack {
        private int mWeight;
        private int mValue;

        public Pack(int weight, int value) {
            mWeight = weight;
            mValue = value;
        }

        public int getWeight() {
            return mWeight;
        }

        public void setWeight(int weight) {
            mWeight = weight;
        }

        public int getValue() {
            return mValue;
        }

        public void setValue(int value) {
            mValue = value;
        }

        @Override
        public String toString() {
            return "Pack{" +
                    "mWeight=" + mWeight +
                    ", mValue=" + mValue +
                    '}';
        }
    }
}

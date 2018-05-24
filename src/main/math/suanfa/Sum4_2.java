package main.math.suanfa;

import java.util.ArrayList;
import java.util.List;

public class Sum4_2 {
    /**
     * @param targetList
     *            所有的样本的集合
     * @param m
     *            从样本集合中选取的样本个数
     * @param item
     *            中间变量，m个样本的集合
     * @param result
     *            所有item的集合
     */
    private static void c(List<Integer> targetList, int m, List<Integer> item, List<List<Integer>> result) {
        for (int i = 0; i < targetList.size(); i++) {
            List<Integer> tempList = new ArrayList<>();
            item.add(targetList.get(i));
            if (m > 1) {
                tempList.addAll(targetList.subList(i + 1, targetList.size()));
                c(tempList, m - 1, item, result);
            } else {
                tempList.addAll(item);
                result.add(tempList);
            }
            item.remove(item.size() - 1);
        }
    }

    /**
     * 从n个样本中取m个的所有组合
     * 
     * @param n
     * @param m
     */
    private static void test2(int n, int m) {
        if (n <= 0 || m <= 0) {
            System.out.println("n or m is lte zero,error");
            return;
        }
        if (m > n) {
            System.out.println("m>n,error");
            return;
        }
        List<Integer> target = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            target.add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        c(target, m, new ArrayList<>(m), result);
        System.out.println(result);
        System.out.println("C" + n + "," + m + "=" + result.size());
    }
}

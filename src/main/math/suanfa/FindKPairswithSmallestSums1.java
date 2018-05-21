package main.math.suanfa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// 暴力法373 https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
public class FindKPairswithSmallestSums1 {
    public static void main(String[] args) {
        new FindKPairswithSmallestSums1().kSmallestPairs(new int[] { 1, 7, 11 }, new int[] { 2, 4, 6 }, 3);
    }

    class Entry {
        public Entry(int k, int[] a) {
            this.k = k;
            this.a = a;
        }
        private int k;
        private int[] a;

        public int getK() {
            return k;
        }

        public void setK(int k) {
            this.k = k;
        }

        public int[] getA() {
            return a;
        }

        public void setA(int[] a) {
            this.a = a;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<int[]> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) {
            return result;
        }
        List<Entry> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                list.add(new Entry(nums1[i] + nums2[j], new int[] { nums1[i], nums2[j] }));
            }
        }
        result = list.stream().sorted(new Comparator<Entry>() {
            @Override
            public int compare(Entry o1, Entry o2) {
                return o1.getK() - o2.getK();
            }
        }).map(Entry::getA).collect(Collectors.toList());
        if (k < list.size()) {
            result = result.subList(0, k);
        }
        return result;
    }
}

package math.suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum4 {
    public static void main(String[] args) {
        fourSum(new int[] { -493, -470, -464, -453, -451, -446, -445, -407, -406, -393, -328, -312, -307, -303, -259, -253, -252, -243, -221, -193, -126, -126, -122, -117, -106, -105, -101, -71, -20, -12, 3, 4, 20, 20, 54, 84, 98, 111, 148, 149, 152, 171, 175, 176, 211, 218, 227, 331, 352, 389, 410, 420, 448, 485 }, 1057);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        List<Integer> checkList = new ArrayList<>();
        for (int i : nums) {
            checkList.add(i);
        }
        Collections.sort(checkList);
        if ((checkList.get(checkList.size() - 1) + checkList.get(checkList.size() - 2) + checkList.get(checkList.size() - 3) + checkList
                .get(checkList.size() - 4)) < target) {
            return result;
        }
        int arrayLength = nums.length;
        Set<Entity> set = new HashSet<>();
        for (int a = 0; a < arrayLength; a++) {
            for (int b = 0; b < arrayLength; b++) {
                if (a == b) {
                    continue;
                }
                for (int c = 0; c < arrayLength; c++) {
                    if (a == c || b == c) {
                        continue;
                    }
                    for (int d = 0; d < arrayLength; d++) {
                        if (a == d || b == d || c == d) {
                            continue;
                        }
                        List<Integer> list = Arrays.asList(new Integer[] { nums[a], nums[b], nums[c], nums[d] });
                        if (sum(list, target)) {
                            Entity entity = new Entity(makeKey(list), list);
                            set.add(entity);
                        }
                    }
                }
            }
        }
        if (set != null && set.size() > 0) {
            set.stream().forEach(item -> {
                result.add(item.getValue());
            });
        }
        return result;
    }

    private static String makeKey(List<Integer> list) {
        StringBuilder ssb = new StringBuilder();
        Collections.sort(list);
        list.forEach(item -> {
            ssb.append(item.toString());
        });
        return ssb.toString();
    }

    private static boolean sum(List<Integer> list, Integer target) {
        int a=0;
        for (Integer item : list) {
            a += item;
        }
        return a == target;
    }

    static class Entity {
        private String key;
        private List<Integer> value;

        public Entity(String key, List<Integer> value) {
            this.key = key;
            this.value = value;
        }
        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public List<Integer> getValue() {
            return value;
        }

        public void setValue(List<Integer> value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            Entity entity = (Entity) obj;
            return this.key.equals(entity.getKey());
        }

        @Override
        public int hashCode() {
            return this.key.hashCode();
        }

    }
    // public List<List<Integer>> fourSum1(int[] nums, int target) {
    // List<List<Integer>> results = new ArrayList<List<Integer>>();
    // if (nums.length < 4) {
    // return results;
    // }
    //
    // List<Integer> numList = new ArrayList<Integer>();
    // for (int num : nums) {
    // numList.add(num);
    // }
    // Collections.sort(numList);
    // for (int i = 0; i < numList.size(); i++) {
    // nums[i] = numList.get(i);
    // }
    //
    // for (int i = 0; i < nums.length - 3; i++) {
    // while (i < nums.length - 3 && i != 0 && (nums[i - 1] == nums[i])) {
    // i++;
    // }
    // for (int j = i + 1; j < nums.length - 2; j++) {
    // while (j < nums.length - 2 && j != i + 1 && (nums[j - 1] == nums[j])) {
    // j++;
    // }
    // int p = j + 1;
    // int q = nums.length - 1;
    // while (p < q) {
    // if (nums[p] + nums[q] < target - nums[i] - nums[j]) {
    // p++;
    // } else if (nums[p] + nums[q] > target - nums[i] - nums[j]) {
    // q--;
    // } else {
    // List<Integer> result = Arrays.asList(new Integer[] { nums[i], nums[j], nums[p], nums[q] });
    // results.add(result);
    // int nums_p = nums[p];
    // int nums_q = nums[q];
    // p++;
    // q--;
    // while (p < q && nums_p == nums[p]) {
    // p++;
    // }
    //
    // while (p < q && nums_q == nums[q]) {
    // q--;
    // }
    // }
    // }
    // }
    // }
    // return results;
    // }

}

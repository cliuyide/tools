package main.math.suanfa;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    // 给定两个整数 n, d 分别代表一个分数的分子和分母，求该分数的小数形式。如果该小数有循环部分，需要用括号将循环部分括起来。
    //
    // 这道题的难度是中等，其中的边界条件特别多。我们先将比较复杂的问题分解成如下几个比较简单的问题：
    //
    // 1. 判断正负数和取绝对值
    // 动态语言，比如Ruby和Python不需要考虑这个问题，但是 Java/C++ 需要，因为 - 2^ 31 的绝对值还是 - 2^31 。Java 的Integer 的取值范围是 - 2^31 到 2 ^ 31 - 1 。
    //
    // 2. 求两数相除的办法
    // 假设我们要求 320 / 2 的值，那么其流程是
    // 2.1 ans = 3 / 2 = 1, carry = 3 % 2 = 1
    // 2.2 ans = 1 * 10 + (carry * 10 + 2) / 2 = 16 , carry = (carry * 10 + 2) % 2 = 0
    // 2.3 ans = 16 * 10 + (carry * 10 + 0) / 2 = 160 , carry = 0
    //
    // 3. 判断循环的位置
    // 可以用Hash Table 来判断循环出现的位置
    public static String handle(int numerator, int denominator) {
        long n = numerator, m = denominator;
        if (n * m == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        if (n * m < 0) {
            result.append("-");
        }
        long numeratorLong = Math.abs((long) numerator), denominatorLong = Math.abs((long) denominator);
        long wholeNumber = numeratorLong / denominatorLong;
        result.append(wholeNumber);
        long remainder = numeratorLong % denominatorLong;
        Map<Long, Integer> map = new HashMap<>();
        if (remainder != 0) {
            result.append(".");
            for (; remainder != 0; remainder = remainder % denominatorLong) {
                if (map.get(remainder) != null) {
                    result.insert(map.get(remainder), "(");
                    result.append(")");
                    break;
                }
                map.put(remainder, result.length());
                remainder = remainder * 10;
                result.append(remainder / denominatorLong);
            }
        }
        return result.toString();
    }

    // 正式答案

    /*public static String fractionToDecimal(int numerator, int denominator) {
        long n = numerator, d = denominator;
        if (n == 0) return "0";
        StringBuffer a = new StringBuffer();
        if ((n < 0) ^ (d < 0)) a.append("-");
        n = Math.abs(n);
        d = Math.abs(d);
        long in = n / d;
        a.append(String.valueOf(in)); // StringBuffer里面没有String的 a = a + if (n % d == 0) { return a.toString(); } else { a.append("."); } // 以上是小数点以前的
        HashMap<Long, Integer> map = new HashMap<Long, Integer>(); // 用hashmap查找循环的地方比较方便 // System.out.println(map.get(0)); //打印可看出
        // integer位置上未初始化时存的是null
        long i;
        for (i = n % d; i != 0; i = i % d) { // 注意step if (map.get(i) != null) { break; } map.put(i, a.length()); //
            // 将i的值当做key a的位置当做value
            i *= 10;
            a.append(i / d);
        }
        if (i == 0) return a.toString();
        a.insert(map.get(i), "("); // 直接在循环的地方加入( a.append(")"); //
        // 出现循环就立即跳出了循环，也就是说从i的位置到最后，都是循环体，所以只需在最后面加上）
        return a.toString();
    }
*/
}

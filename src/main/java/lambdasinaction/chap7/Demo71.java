package lambdasinaction.chap7;

import java.util.stream.Stream;

/**
 * @author vector
 * @date: 2018/10/9 0009 11:21
 */
public class Demo71 {

    public static long sequentialSum(int n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, (l1, l2) -> l1 + l2);
    }

    public static long parallelSum(int n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, (l1, l2) -> l1 + l2);
    }

    public static long iterativeSum(int n) {
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

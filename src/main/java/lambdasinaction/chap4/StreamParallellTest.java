package lambdasinaction.chap4;

import org.apache.commons.collections4.ListUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author vector
 * @date: 2018/10/18 0018 10:00
 *
 * List<List<?>> -> List<?>
 *
 * 使用parallelstream需注意【共享对象的可变状态】
 * 如使用foreach就能改变其状态
 * 需要特别注意下
 */
public class StreamParallellTest {

    public static List<String> sum(List<Integer> items,int count) {
        List<List<Integer>> listList = ListUtils.partition(items, count);
        return listList.stream().flatMap(List::stream).map(StreamParallellTest::delayFun).collect(Collectors.toList());
    }

    public static List<String> parallelSum(List<Integer> items,int count) {
        List<List<Integer>> listList = ListUtils.partition(items, count);
        return listList.parallelStream().flatMap(List::stream).map(StreamParallellTest::delayFun).collect(Collectors.toList());
    }

    public static String delayFun(int digist) {
        try {
            Thread.sleep(digist);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return digist + "";
    }

    public static void main(String[] args) {
        List<Integer> items = IntStream.rangeClosed(1, 50).boxed().collect(Collectors.toList());
        System.out.println(items);
        long s = System.currentTimeMillis();
        sum(items,10);
        long e = System.currentTimeMillis();
        System.out.println((double)(e-s)/1_000 + "s");

        long s1 = System.currentTimeMillis();
        parallelSum(items,10);
        long e1 = System.currentTimeMillis();
        System.out.println((double)(e1-s1)/1_000 + "s");
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                long s1 = System.currentTimeMillis();
//                parallelSum(items,10);
//                long e1 = System.currentTimeMillis();
//                System.out.println((double)(e1-s1)/1_000 + "s");
//            }
//            System.out.println("============================");
//        }
    }
}

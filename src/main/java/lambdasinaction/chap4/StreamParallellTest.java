package lambdasinaction.chap4;

import org.apache.commons.collections4.ListUtils;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author vector
 * @date: 2018/10/18 0018 10:00
 * <p>
 * List<List<?>> -> List<?>
 * <p>
 * 使用parallelstream需注意【共享对象的可变状态】
 * 如使用foreach就能改变其状态
 * 需要特别注意下
 */
public class StreamParallellTest {

    public static List<String> sum(List<Integer> items, int count) {
        List<List<Integer>> listList = ListUtils.partition(items, count);
        return listList.stream().flatMap(List::stream).map(StreamParallellTest::delayFun).collect(Collectors.toList());
    }

    public static List<String> parallelSum(List<Integer> items, int count) {
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

    private static void execute(String msg, Supplier<List<String>> supplier) {
        long s = System.nanoTime();
        supplier.get();
        long e = System.nanoTime();
        long duration = (e - s) / 1_000_000;

        System.out.println(msg + " done in " + duration + " msecs");
    }


    public static void main(String[] args) {
        List<Integer> items = IntStream.rangeClosed(1, 50).boxed().collect(Collectors.toList());
        System.out.println(items);
        execute("sum", () -> sum(items, 10));
        execute("parallelSum", () -> parallelSum(items, 10));
    }
}

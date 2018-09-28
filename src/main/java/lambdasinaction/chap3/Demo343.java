package lambdasinaction.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author vector
 * @date: 2018/9/28 0028 14:21
 */
public class Demo343 {
    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> map = map(Arrays.asList("ladf", "in", "action"), (String s) -> s.length());
        System.out.println(map);
    }
}

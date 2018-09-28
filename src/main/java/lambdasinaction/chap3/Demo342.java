package lambdasinaction.chap3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author vector
 * @date: 2018/9/28 0028 14:00
 */
public class Demo342 {
    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    public static void main(String[] args) {

        forEach(Arrays.asList(1,2,3,4,5,6),(Integer i)-> System.out.println(i));
    }
}

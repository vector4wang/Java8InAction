package lambdasinaction.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author vector
 * @date: 2018/9/29 0029 15:48
 */
public class Demo522 {
    public static void main(String[] args) {
        List<String> hw = Arrays.asList("Hello", "World");
        List<String> collect = hw.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(toList());
        System.out.println(collect);
    }
}

package TransformTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author vector
 * @date: 2018/10/15 0015 11:47
 */
public class Demo1 {
    public static <T> List<T> getLongestList(List<List<T>> lists) {
        if (lists.isEmpty()) {
            return new ArrayList<>();
        }
        int index = 0;
        int max = 0;
        for (int i = 0; i < lists.size(); i++) {
            List<T> list = lists.get(i);
            if (list.size() > max) {
                index = i;
                max = list.size();
            }
        }
        return lists.get(index);
    }


    public static <T> List<T> getLongestList2(List<List<T>> lists) {
        return lists.stream().max(Comparator.comparing(List::size)).orElse(Collections.emptyList());
//        List<T> max = Collections.max(lists, Comparator.comparingInt(List::size));
//        return max;

    }

    public static void main(String[] args) {
        List<List<String>> bigList = new ArrayList<List<String>>(){{
            add(new ArrayList<String>(){{
                add("A");
                add("B");
                add("C");
                add("D");
            }});
            add(new ArrayList<String>(){{
                add("a");
                add("b");
                add("c");
            }});
            add(new ArrayList<String>(){{
                add("A");
                add("B");
                add("C");
                add("d");
            }});
            add(new ArrayList<String>(){{
                add("A");
                add("B");
            }});
        }};
        System.out.println(bigList.size());
        for (int i = 0; i < 100; i++) {
            System.out.println(getLongestList(bigList));
            System.out.println(getLongestList2(bigList));
            System.out.println(new ArrayList<>());
            System.out.println("====");
        }

    }
}

package lambdasinaction.chap10;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author vector
 * @date: 2018/10/10 0010 14:00
 */
public class Demo104 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("a", "sadfas");
        map.put("b", "sadfas1");
        map.put("c", "sadfas2");
        map.put("d", "sadfas3");

        String e = map.get("e");
        System.out.println(e);

        Optional<String> e1 = Optional.ofNullable(map.get("e"));
        String s = Optional.ofNullable(map.get("e")).orElse("unknown key");
        System.out.println(s);

    }

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}

package lambdasinaction.chap5;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * @author vector
 * @date: 2018/9/29 0029 16:48
 */
public class Demo551 {
    public static void main(String[] args) {
        List<Transaction> list = new ArrayList<>();
        List<Transaction> list1 = list.stream().filter(item -> item.getYear() == 2011).sorted(comparing(Transaction::getValue)).collect(toList());

        Set<String> set2 = list.stream().map(item -> item.getTrader().getCity()).collect(Collectors.toSet());

        List<Trader> list3 = list.stream().map(Transaction::getTrader).filter(item -> item.getCity().equals("剑桥")).distinct().sorted(comparing(Trader::getName)).collect(toList());

        String collect4 = list.stream().map(item -> item.getTrader().getName()).distinct().sorted().collect(joining());

        boolean boolean5 = list.stream().anyMatch(item -> item.getTrader().getCity().equals("米兰"));

        list.stream().filter(item->item.getTrader().getCity().equals("剑桥")).map(Transaction::getValue).forEach(System.out::println);

        Optional<Integer> first7 = list.stream().map(Transaction::getValue).sorted(Integer::compareTo).limit(1).findFirst();

        list.stream().min(comparing(Transaction::getValue));



    }
}

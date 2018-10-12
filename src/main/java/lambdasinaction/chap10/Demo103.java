package lambdasinaction.chap10;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author vector
 * @date: 2018/10/10 0010 11:29
 */
public class Demo103 {
    public static void main(String[] args) {
        Person person = new Person();
        Optional<Car> car = person.getCar();
        System.out.println(car.orElse(new Car()));
        car.ifPresent(System.out::println);
        ;


//        Optional<Car> optCar2 = Optional.of(car)


    }
}

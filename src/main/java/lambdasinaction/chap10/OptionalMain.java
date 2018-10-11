package lambdasinaction.chap10;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class OptionalMain {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("lamurudu", "Okanbi", "Oduduwa");
		Optional<String> f = stream.filter(name -> name.startsWith("L")).findFirst();
		String lambda = f.orElse("Lambda");
		//		String lambda = f.orElseGet(() -> "Lambda");
		f.ifPresent(s -> {
			s = s.toUpperCase();
			System.out.println(s);
		});
		System.out.println(lambda);


		Optional.ofNullable("Jackson").filter(s->s.equals("Jackson")).ifPresent(s-> System.out.println(s+"~~~"));

		Stream.of("lamurudu", "Okanbi", "Oduduwa").filter(s -> s.contains("c")).findFirst().ifPresent(s-> System.out.println(123));

		Set<String> words = new HashSet<>(Arrays.asList("this", "is", "a", "stream", "of", "strings"));
		Optional<String> firstString = words.stream()
				.findFirst();
		System.out.println(firstString);

		List<String> equal=IntStream.range(0, 100)
				.mapToObj(i->new String("test")) // don't do this in normal code
				.collect(Collectors.toList());
		Map<String, Integer> map = IntStream.range(0, equal.size())
				.collect(IdentityHashMap::new, (m,i)->m.put(equal.get(i),i), Map::putAll);

		equal.parallelStream().distinct().map(map::get)
				.findFirst().ifPresent(System.out::println);



		Predicate<String> startsWithJ = (n) -> n.startsWith("J");
		Predicate<String> fourLetterLong = (n) -> n.length() == 4;
		Predicate<String> containsBig = (n) -> n.contains("A");
		Stream.of("lamurudu", "Jack", "Oduduwa","Jbulsu Abas")
				.filter(startsWithJ.and(fourLetterLong.or(containsBig)))
				.forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));

	}

	public String getCarInsuranceName(Optional<Person> person) {
		return person.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElse("Unknown");
	}
	//    public Set<String> getCarInsuranceNames(List<Person> persons) {
	//        return persons.stream()
	//                      .map(Person::getCar)
	//                      .map(optCar -> optCar.flatMap(Car::getInsurance))
	//                      .map(optInsurance -> optInsurance.map(Insurance::getName))
	//                      .flatMap(Optional::stream)
	//                      .collect(toSet());
	//    }
}

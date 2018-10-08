package lambdasinaction.chap6;

import java.util.Arrays;
import java.util.List;

public class Demo62 {
	public static List<GroupingTransactions.Transaction> transactions = Arrays
			.asList( new GroupingTransactions.Transaction(GroupingTransactions.Currency.EUR, 1500.0),
					new GroupingTransactions.Transaction(GroupingTransactions.Currency.USD, 2300.0),
					new GroupingTransactions.Transaction(GroupingTransactions.Currency.GBP, 9900.0),
					new GroupingTransactions.Transaction(GroupingTransactions.Currency.EUR, 1100.0),
					new GroupingTransactions.Transaction(GroupingTransactions.Currency.JPY, 7800.0),
					new GroupingTransactions.Transaction(GroupingTransactions.Currency.CHF, 6700.0),
					new GroupingTransactions.Transaction(GroupingTransactions.Currency.EUR, 5600.0),
					new GroupingTransactions.Transaction(GroupingTransactions.Currency.USD, 4500.0),
					new GroupingTransactions.Transaction(GroupingTransactions.Currency.CHF, 3400.0),
					new GroupingTransactions.Transaction(GroupingTransactions.Currency.GBP, 3200.0),
					new GroupingTransactions.Transaction(GroupingTransactions.Currency.USD, 4600.0),
					new GroupingTransactions.Transaction(GroupingTransactions.Currency.JPY, 5700.0),
					new GroupingTransactions.Transaction(GroupingTransactions.Currency.EUR, 6800.0) );

	public static void main(String[] args) {
		System.out.println(transactions.size());
		System.out.println(transactions.stream().count());
	}
}

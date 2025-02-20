
import utilities.Trader;
import utilities.Transaction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Use the provided utilities.Trader and utilities.Transaction data to implement the class's methods.
 *
 * Do NOT modify the utilities.Trader or utilities.Transaction data.
 */
public class TransactionQuestions {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");
    List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );

    /**
     * Find all transactions in the year 2011 and sort them by value (small to large).
     * @return a list of all transactions that occurred in 2011
     */
    public List<Transaction> transactions2011() {

        // Your implementation here
        // Example:
         return transactions.stream()
                 .filter(t -> t.getYear() == 2011)
           .sorted(Comparator.comparingInt(Transaction::getValue))
           .collect(Collectors.toList());
    }

    /**
     * What are all the unique cities where the traders work?
     * @return A list of all unique cities traders work in
     */
    public List<String> uniqueCities() {
        return menu.stream()
                 .map(Trader::getCity)
                 .distinct()
                 .sorted()
                 .collect(Collectors.toList());

    }

    /**
     * Find all traders from Cambridge and sort them by name alphabetically.
     * @return a list of all traders based in cambridge
     */
    public List<Trader> cambridgeTraders() {
        // Example:
        return transactions.stream()
                 .filter(t -> Objects.equals(t.getCity(), "Cambridge"))
                 .sorted(Comparator.comparing(t1 -> {
                     return Trader.getName(t1);
                 }))
                 .collect(Collectors.toList());
    }

    /**
     * Return a single string of all traders' names sorted alphabetically.
     *
     * There should be no characters in between each name.
     * @return a concatenated string of all trader names
     */
    public String traderNames() {
        // Example:
        return transactions.stream()
                 .filter(t -> Objects.equals(t.getCity(), "Cambridge"))
                 .map(Trader::getName)
                 .sorted()
                 .collect(Collectors.joining());
    }

    /**
     * Are any traders based in Milan?
     * @return true, if any traders are Milan based
     */
    public boolean isMilanBased() {
        // Example:
        return transactions.stream()
                 .filter(t -> Objects.equals(t.getCity(), "Milan"))
                 .findAny()
                 .isPresent();

    }

    /**
     * Print all transactions' values from the traders living in Cambridge.
     */
    public void printCambridgeTransactions() {
        // Example:
        transactions.stream()
                 .filter(t -> Objects.equals(t.getCity(), "Cambridge"))
                 .forEach(t -> System.out.println("Transaction value: " + t.getValue()));

    }

    /**
     * What's the highest value of all the transactions?
     * @return An optional with the highest value of a trade, if a trade occurred.
     */
    public Optional<Integer> highestValueTrade() {
        return transactions.stream()
                 .mapToInt(Transaction::getValue)
                 .max()
                 .map(Optional::of);
    }

    /**
     * Find the transaction with the smallest value.
     * @return An optional with the transaction with the smallest value, if a transaction exists.
     */
    public Optional<Transaction> smallestTransaction() {
        return transactions.stream()
                 .min(Comparator.comparingInt(Transaction::getValue));


    }
}

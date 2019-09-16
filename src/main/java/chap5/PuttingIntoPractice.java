package chap5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PuttingIntoPractice {
    public static void main(String[] args) {
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

        // 找到2011年的所有交易并按交易额排序（从低到高）
        List<Transaction> a1 = transactions.stream()
                .filter(s -> s.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
//        System.out.println(a1);

        // 交易员都在哪些不同的城市工作过
        List<String> a2 = transactions.stream()
                .map(s -> s.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
//        System.out.println(a2);

        // 查找所有来自于剑桥的交易员，并按姓名排序
        List<Trader> a3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(s -> s.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getCity))
                .collect(Collectors.toList());

        // 返回所有交易员的姓名字符串，并按字母顺序排序
        String a4 = transactions.stream()
                .map(s -> s.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (s1, s2) -> s1 + s2);
//        System.out.println(a4);

        // 有没有交易员是在米兰工作的
        boolean a5 = transactions.stream()
                .anyMatch(s -> s.getTrader().getCity().equals("Milan"));
//        System.out.println(a5);

        // 打印生活在剑桥的交易员的所有交易额
//        transactions.stream()
//                .filter(s -> ("Cambridge").equals(s.getTrader().getCity()))
//                .map(Transaction::getValue)
//                .forEach(System.out::println);

        // 所有交易中，最高的交易额是多少
        Optional<Integer> a7 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
//        System.out.println(a7.get());

        // 找到交易额最小的交易
        List<Transaction> a8 = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(a8);

        transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);

        transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
    }
}

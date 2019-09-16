package chap5;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
}

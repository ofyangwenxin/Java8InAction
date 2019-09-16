package chap5;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Trader {
    private final String name;
    private final String city;
}

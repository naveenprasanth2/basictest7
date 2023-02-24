package practise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class LambokPrac {
    private @Getter @Setter String name;
    private @Getter @Setter String last;
    private @Getter @Setter Integer age;
    private @Getter @Setter String sex;
}

package practise1;

import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String name;
    private int age;
    private String city;
    private boolean isActive;
    private String dob;

    @Builder
    public static Customer createCustomer(String name, int age) {
        return new Customer(name, age, "chennai", true, "12-12-23");
    }

}

package practise1;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    private String name;
    private int age;
    private String city;
    private boolean isActive;
    private String dob;

//    @Builder
//    public Customer(String city, String dob){
//        this.city = city;
//        this.dob = dob;
//    }

    @Builder
    public static Customer testCustomer(String name, int age){

        return new Customer(name, age, "chennai", true, "20-12-22");
    }

}

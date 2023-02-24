package practise;

import practise1.Customer;

import java.util.stream.Stream;

public class LambokTest {
    public static void main(String[] args) {
        LambokPrac l = LambokPrac.builder().name("naveenA").age(20).sex("male").last("prasanth").build();

        Stream.of(l).filter(x -> x.getAge().equals(20)).findFirst().ifPresent(x -> System.out.println(x.getName()));

        Customer c = Customer.builder().city("summa1").isActive(true).dob("54154545").age(20).name("summa").build();

        System.out.println(c);

    }
}

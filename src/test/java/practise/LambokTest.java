package practise;

import org.testng.annotations.Test;
import practise1.Customer;

public class LambokTest {

    @Test
    public void test(){
        Customer c1 = new Customer("naveen", 20, "545", true, "jhuihu");

        Customer c2 = Customer.builder().name("summa").age(23).build();
        System.out.println(c1);
        System.out.println(c2);
    }
}

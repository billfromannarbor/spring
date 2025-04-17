package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SingletonTest {

    @Test
    public void testSingleton() {
        BillPughSingleton billPughSingleton = BillPughSingleton.getInstance();
        BillPughSingleton billPughSingleton2 = BillPughSingleton.getInstance();

        Assertions.assertSame(billPughSingleton, billPughSingleton2);
    }
}

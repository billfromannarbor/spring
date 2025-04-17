package com.example;

import java.io.Serializable;

public class BillPughSingleton {

    //Private constructor - can't be instantiated by other classes
    private BillPughSingleton() {

    }

    //Private static inner class controls instantiation
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void doSomething() {
        System.out.println("BillPughSingleton doSomething");
    }


}



package com.company;

import java.util.Timer;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Timer t = new Timer();
        DoSomthing doSomthing =new DoSomthing();
        t.scheduleAtFixedRate(doSomthing, 0, 10000);
    }
}

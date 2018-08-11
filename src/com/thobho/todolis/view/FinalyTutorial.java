package com.thobho.todolis.view;

public class FinalyTutorial {

    private static int x = 3;

    public static void main(String[] args) {
        x = finalyTests();
    }

    private static int finalyTests(){
        try{
            return  5;
        }finally {
            x = 6;
            System.out.println("test");
        }
    }

}

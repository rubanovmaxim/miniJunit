package my.test;

import my.test.annotation.Test;

public class MessageService {

    public static String get() {
        return "Hello JUnit 5";
    }


    public void ff(String h,String j){

    }

    public Integer ff1(String h,String j){
        return null;
    }

    @Test
    public Integer ff1(){
        return null;
    }

    @Test
    public void ff1111(){

        assert 1 == 1 : "kjkj";
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

    }

    @Test
    public void ff2221(){
        System.out.println("===============================1111111111111111111111111111111");
    }



}

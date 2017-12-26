package com.hdw.springboot;


import org.junit.Test;
import java.util.Date;




public class TestMethod {
    @Test
    public void index(){
        Date date = new Date();

        System.out.print("++++testing" + date.toString() );
    }

}

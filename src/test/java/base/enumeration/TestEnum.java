package base.enumeration;

import base.enumeration.Enum;
import org.junit.Test;

public class TestEnum {
    @Test
    public void test1(){
        System.out.println(Enum.AAAA == Enum.AAAA);
        System.out.println(Enum.AAAA.equals(Enum.AAAA));
    }
}



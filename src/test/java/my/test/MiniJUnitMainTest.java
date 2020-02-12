package my.test;


import org.junit.Test;

import java.util.logging.Logger;


public class MiniJUnitMainTest {
    private static Logger logger = Logger.getLogger(MiniJUnitMainTest.class.getName());

    @Test
    public void testAll() {
        logger.info("Try to test all classes");
        // запуск классов тестирования
        MiniJUnitMain.test(
                PrivateMethodClass.class,
                DefaultMethodClass.class,
                ProtectedMethodClass.class,
                PublicMethodClass.class
        );
    }

    @Test
    public void testPrivateMethodClass() {
        logger.info("Try to test all PrivateMethodClass");
        // запуск классов тестирования
        MiniJUnitMain.test(
                PrivateMethodClass.class
        );
    }


    @Test
    public void testDefaultMethodClass() {
        logger.info("Try to test all DefaultMethodClass");
        // запуск классов тестирования
        MiniJUnitMain.test(
                DefaultMethodClass.class
        );
    }

    @Test
    public void testProtectedMethodClass() {
        logger.info("Try to test all ProtectedMethodClass");
        // запуск классов тестирования
        MiniJUnitMain.test(
                ProtectedMethodClass.class
        );
    }

    @Test
    public void testPublicMethodClass() {
        logger.info("Try to test all PublicMethodClass");
        // запуск классов тестирования
        MiniJUnitMain.test(
                PublicMethodClass.class
        );
    }

}


class PrivateMethodClass {

    private static Logger logger = Logger.getLogger(PrivateMethodClass.class.getName());

    @my.test.annotation.Test
    private void test() {
        logger.info("PrivateMethodClass test");
    }
}

class DefaultMethodClass {

    private static Logger logger = Logger.getLogger(DefaultMethodClass.class.getName());

    @my.test.annotation.Test
    void test() {
        logger.info("DefaultMethodClass test");
    }
}


class ProtectedMethodClass {

    private static Logger logger = Logger.getLogger(ProtectedMethodClass.class.getName());

    @my.test.annotation.Test
    void test() {
        logger.info("ProtectedMethodClass test");
    }
}


class PublicMethodClass {

    private static Logger logger = Logger.getLogger(PublicMethodClass.class.getName());

    @my.test.annotation.Test
    public void test() {
        logger.info("PublicMethodClass test without parameter and return type");
    }

    @my.test.annotation.Test
    public String test(String str) {
        logger.info("PublicMethodClass test with parameter and return test");
        return str;
    }
}





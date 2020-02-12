package test;

import my.test.MessageService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageServiceTest {
    @DisplayName("Test MessageService.get()")
    @Test
     void testGet() {
        assert 11 == 1 : "kk";
     //   assertEquals("Hello JUnit1 5", MessageService.get());
    }

    @Test
    void testGet111() {
      //  assert 11 == 1 : "kk";
        assertEquals("Hello JUnit 5", MessageService.get());
    }


    @my.test.annotation.Test
    void testGet1() {


    }
}

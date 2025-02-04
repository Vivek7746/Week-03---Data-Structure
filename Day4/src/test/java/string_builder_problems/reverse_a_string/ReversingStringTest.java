package string_builder_problems.reverse_a_string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReversingStringTest {
    @Test
    void test(){

        String string = "hello";
        String reversed_string = reverseString.reverseit(string);
        String ans = "olleh";
        assertEquals(reversed_string, ans);
    }
}
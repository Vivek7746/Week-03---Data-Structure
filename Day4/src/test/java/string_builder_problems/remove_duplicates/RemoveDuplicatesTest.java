package string_builder_problems.remove_duplicates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    @Test
    void test1(){

        String string = "vivek";
        String resultant_string = RemoveDuplicates.removingDuplicates(string);
        String ans = "viek";

        assertEquals(resultant_string, ans);
    }

    @Test
    void test2(){

        String string = "nitin";
        String resultant_string = RemoveDuplicates.removingDuplicates(string);
        String ans = "nit";

        assertEquals(resultant_string, ans);
    }
}
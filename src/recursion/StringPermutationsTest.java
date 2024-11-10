package recursion;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class StringPermutationsTest {

    @Test
    public void testPermutationsForNonEmptyString() {
        // Test for a non-empty string "abc" to check if all expected permutations are generated
        String input = "abc";
        List<String> result = StringPermutations.generatePermutations(input);
        // Verify the number of permutations should be 6 (3! = 6)
        assertEquals(6, result.size());
        assertTrue(result.contains("abc"));
        assertTrue(result.contains("acb"));
        assertTrue(result.contains("bac"));
        assertTrue(result.contains("bca"));
        assertTrue(result.contains("cab"));
        assertTrue(result.contains("cba"));
    }

    // Test for an empty string, expecting one permutation which is an empty string
    @Test
    public void testPermutationsForEmptyString() {
        String input = "";
        List<String> result = StringPermutations.generatePermutations(input);
        assertEquals(1, result.size());
        assertEquals("", result.get(0));
    }

    // Test for a single character string, expecting one permutation which is the character itself
    @Test
    public void testPermutationsForSingleCharacter() {
        String input = "a";
        List<String> result = StringPermutations.generatePermutations(input);
        assertEquals(1, result.size());
        assertEquals("a", result.get(0));
    }
}
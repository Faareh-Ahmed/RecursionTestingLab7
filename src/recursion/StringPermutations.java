package recursion;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    // Method to generate all permutations of a given string
    public static List<String> generatePermutations(String str) {
        List<String> result = new ArrayList<>();
        // Base case: if input is null or empty, add an empty string to the result
        if (str == null || str.length() == 0) {
            result.add("");
            return result;
        }
        // Convert the string to a character array and start the permutation process
        permute(str.toCharArray(), 0, result);
        return result;
    }

    // Recursive helper method to generate permutations by swapping characters
    private static void permute(char[] chars, int currentIndex, List<String> result) {
    	
        // If we reach the end of the array, add the current permutation to the result
        if (currentIndex == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        // Iterate over the array and swap characters to create permutations
        for (int i = currentIndex; i < chars.length; i++) {
            swap(chars, currentIndex, i);
            permute(chars, currentIndex + 1, result);
            swap(chars, currentIndex, i); // backtrack
        }
    }

    // Helper method to swap two characters in the character array
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String input = "abc"; 
        List<String> permutations = generatePermutations(input);
        System.out.println("Permutations of " + input + ":");
        for (String perm : permutations) {
            System.out.println(perm);
        }
    }
}
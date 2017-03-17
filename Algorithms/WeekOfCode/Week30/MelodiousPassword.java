package WeekOfCode.Week30;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *	Algorithms -> Week of Code 30 -> Melodious password
 *	Medium
 */
public class MelodiousPassword {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PasswordGenerator pg = new PasswordGenerator(n);
    }
    // Test functions
    public static void generate(String input, int N) {
        generate("", input, new HashSet<String>(), N);
    }

    private static void generate(String str, String input, Set<String> dup, int N) {
        if (str.length() == N && dup.add(str))
            System.out.println(str);
        else
            //remove a char form input and add it to str
            for (int i = 0; i < input.length(); i++)
                generate(
                    str + input.charAt(i), 
                    input.substring(0, i) + input.substring(i + 1), 
                    dup, N);
    }
    // end two test functions
    public static class PasswordGenerator
    {
       public static String vowels = "aeiou";
       public static String consts = "bcdfghjklmnpqrstvwxyz";
       public static String alphabet = "abcdefghijklmnopqrstuvwxyz";
       /*
        * Rules
        * - Must be exactly n lowercase chars
        * - Vowels must be next to const and const are next to vowels
        * - Password can start with a vowel or a const
        */
        private int size;
        public PasswordGenerator(int n) {
            this.size = n;
            generate(this.size);
        }
        
        public void generate(int N) {
            generate("", alphabet, new HashSet<String>(), N);
        }

        private void generate(String str, String input, Set<String> dup, int N) {
            if (str.length() == N && dup.add(str)) {
                if(checkPasswordForRules(str, N))
                    System.out.println(str);
            } else {
                //remove a char form input and add it to str
                for (int i = 0; i < input.length(); i++)
                    generate(
                        str + input.charAt(i), 
                        //input.substring(0, i) + input.substring(i + 1), 
                        input,
                        dup, N);
            }
        }

        public static boolean checkPasswordForRules(String password, int size)
        {
            if(password.length() != size) // Password needs to be this long.
                return false;
            char c;
            boolean cIsVowel, bIsVowel;
            for(int i = 0; i < password.length(); i++) {
                c = password.charAt(i);
                if(c <= 'Z') // No Uppercase
                    return false;
                if(c == 'y') // No y
                    return false;
                if(i > 0) {
                    cIsVowel = isVowel(c);
                    bIsVowel = isVowel(password.charAt(i - 1));
                    if( (cIsVowel && bIsVowel) || (!cIsVowel && !bIsVowel) ) // No two vowels or two consts in row.
                        return false;
                }
            }
            return true;
        }
        
        public static boolean isVowel(char c) {
            char vowel;
            for(int i = 0; i < vowels.length(); i++) {
                vowel = vowels.charAt(i);
                if(vowel == c)
                    return true;
            }
            return false;
        }
    } // end class PasswordGenerator
} // end class MelodiousPassword

/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }
    public static String lowerCase(String s) {
        String s1 = s; // #feedback - this variable is not needed, you can use s directly.
        String s2 = "";
        for(int i = 0; i < s1.length(); i++) {
            char letter = s1.charAt(i); 
            if((letter <= 'Z') && (letter >= 'A')) {
                s2 = s2 + (char)(s1.charAt(i) + 32); 
            } else {
                s2 = s2 + letter;
            }
        }
        return s2;
    }
}

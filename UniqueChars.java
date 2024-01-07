/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) 
    {
        String str = s;
        str += " ";
        String s = "";
        int count = 0;
        int i=0;

        while(i < str.length()-1)
        {
            if(str.charAt(i) != str.charAt(i+1))
            {
                s+=(char)(str.charAt(i));
            }
            i++;
        }
    return s;
    }
}

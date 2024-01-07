public class test 
{
	public static void main(String[] args) 
	{
		String s1 = "Hi ByE";
        String s2 = "";

        for(int i = 0; i < s1.length(); i++) 
        {
            char letter = s1.charAt(i); 

            if((letter <= 'Z') && (letter >= 'A'))
            {
                s2 = s2 + (char)(s1.charAt(i) + 32); 
            }
            else
            {
                s2 = s2 + letter;
            }
        }
        System.out.print(s2);



		/*String s1 = "I love FOOD yeaH";
		String s2 = "";

		for(int i = 0; i < s1.length(); i++) 
        {
            char letter = s1.charAt(i); 

            if((letter <= 'Z') && (letter >= 'A'))
            {
                s2 = s2 + (char)(s1.charAt(i) + 32); 
            }
            else
            {
            	s2 = s2 + letter;
            }
        }
        System.out.print(s2);*/
	}
}
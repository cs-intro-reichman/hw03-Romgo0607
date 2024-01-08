/** String processing exercise 2. */
public class UniqueChars 
{
    public static void main(String[] args) 
    {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    
    public static String uniqueChars(String s) 
    {
        String str = s; 
        String sNew = "";

        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if(sNew.indexOf(ch) == -1)
            {
                sNew += ch;
            }
            else if(ch == ' ')
                {
                    sNew += " ";
                }
        }   
        return sNew; 
    }
}

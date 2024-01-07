public class test 
{ //deleting letters from given sring if its more then once
	public static void main(String[] args) 
	{
        String str = "checkh";
        String strNew = "";

        for(int i =0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            if(strNew.indexOf(ch) == -1)
            {
                strNew += ch;
            }
        }
        System.out.print(strNew);
        
	}
}
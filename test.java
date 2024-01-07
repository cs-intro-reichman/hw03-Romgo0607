public class test 
{ //deleting letters from given string if its more then once
	public static void main(String[] args) 
	{
        String str = args[0]; //abbab
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
        System.out.println(s);
	}
}
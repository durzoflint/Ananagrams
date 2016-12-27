import java.util.*;
class Ananagrams
{
	static int dicl;
	static String dic[]=new String[1000];
	static Scanner sc=new Scanner(System.in);
	public static void main(String arghh[])
	{
		dicl=input(dic);
		generate(dic);
	}
	static void generate(String s[])
	{
		for(int i=0;i<dicl;i++)
		{
			if(checkanana(dic[i].toUpperCase(),i))
			System.out.println(dic[i]);
		}
	}
	static boolean checkanana(String s,int ind)
	{
		s=s.toUpperCase();
		for(int i=0;i<dicl;i++)
		{
			if(ind==i)
			continue;
			String x=dic[i];
			x=x.toUpperCase();
			if(x.length()==s.length())
			{
				int count=0;
				for(int j=0;j<x.length();j++)
				{
					int c=0,cc=0;
					char ch=x.charAt(j);
					for(int k=0;k<x.length();k++)
					if(x.charAt(k)==ch)
					c++;
					for(int k=0;k<s.length();k++)
					if(s.charAt(k)==ch)
					cc++;
					if(c==cc)
					count++;
				}
				if(count==x.length())
				return false;
			}
		}
		return true;
	}
	static int input(String dic[])
	{
		int j=0;
		String s="",x="";
		while(true)
		{
			s=sc.nextLine()+" ";
			if(s.equals("# "))
			break;
			for(int i=0;i<s.length();i++)
			{
				char ch=s.charAt(i);
				if(ch!=' ')
				x=x+ch;
				else
				{
					if(x.equals(""))
					continue;
					dic[j++]=x;
					x="";
				}
			}
		}
		Arrays.sort(dic,0,j);
		return j;
	}
}
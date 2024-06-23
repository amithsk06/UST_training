public class First
{
	public static void main(String[] args) {
		String query="select fname from table where age>20 and home=konni";
		
		System.out.println(getConditions(query));
	}




public static String[] getConditions(String queryString) {
		String[] st=queryString.split("where");
		String[] st1=st[1].trim().toLowerCase().split("and|or|  ");
		String[] s=new String[st1.length];
//	//	for(int i=0;i<st1.length;i++)
////		{
//			for(String j:st1)
//			{
//			System.out.println(j);
//			}
	//	}
//		System.out.println(st1); 
		return st1;
		
	}
}
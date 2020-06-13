public class Project1 {
	public static void main(String args[]) {
		String emp[][]={{"1001","Ashish","1/04/2009","e","R&D","20000","8000","3000"},{"1002","Sushma","23/08/2018","c","PM","30000","12000","9000"},{"1003","Rahul","12/11/2008","k","Acct","10000","8000","10000"},{"1004","Chahat","29/01/2013","r","Front Desk","12000","6000","2000"},{"1005","Ranjan","16/07/2005","m","Engg","50000","20000","20000"},{"1006","Suman","1/1/2000","e","Manufacturing","23000","9000","4400"},{"1007","Tanmay","12/06/2006","c","PM","29000","12000","10000"}};
		int salary=0,da=0;
		char des=' ';
		String ename=" ",dept=" ",designation=" ",input1=args[0];
		for(int i=0;i<7;i++) {
			if(emp[i][0].equals(input1)) {
				ename=emp[i][1];
				dept=emp[i][4];
				salary=Integer.parseInt(emp[i][5])+Integer.parseInt(emp[i][6])-Integer.parseInt(emp[i][7]);
				des=emp[i][3].charAt(0);
				break;
			}
		}
		switch(des){
		case 'e':
			da=20000;
			designation="Engineer";
		case 'c':
			da=32000;
			designation="Consultant";
		case 'k':
			da=12000;
			designation="Clerk";
		case 'r':
			da=15000;
			designation="Receptionist";
		case 'm':
			da=40000;
			designation="Manager";
		}
		if(ename.equals(" "))
			System.out.println("There is no employee with empid:"+input1);
		else {
		System.out.println("Emp No.\tEmp Name\tDepartment\tDesignation\tSalary");
		System.out.println(input1+"\t"+ename+"\t"+dept+"\t"+designation+"\t"+(salary+da));
	
		}
	}
}

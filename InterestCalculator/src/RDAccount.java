import java.util.HashMap;
import java.util.Map;

public class RDAccount extends Account{
	double interestRate;
	double amount;
	int noOfDays;
	int ageOfACHolder;
	int index=-1,mapIndex=-1;
	Map<Integer,double[]> rate=new HashMap<Integer,double[]>();
	RDAccount(double amount,int noOfDays,int ageOfACHolder){
		this.amount=amount;
		this.ageOfACHolder=ageOfACHolder;
		this.noOfDays=noOfDays;
	}
	void initial() {
		rate.put(1,new double[] {7.5,8});
		rate.put(2,new double[] {7.75,8.25});
		rate.put(3,new double[] {8,8.5});
		rate.put(4,new double[] {8.25,8.75});
		rate.put(5,new double[] {8.5,9});
		rate.put(6,new double[] {8.75,9.25});
	}
	double calculateInterest() 
	{
		if(ageOfACHolder<60)
			index=0;
		else
			index=1;
		if(noOfDays<=14)
			mapIndex=1;
		else if(noOfDays>14 && noOfDays<=29)
			mapIndex=2;
		else if(noOfDays>29 && noOfDays<=45)
			mapIndex=3;
		else if(noOfDays>45 && noOfDays<=60)
			mapIndex=4;
		else if(noOfDays>60 && noOfDays<184)
			mapIndex=5;
		else
			mapIndex=6;
		return(((rate.get(mapIndex)[index])*amount)/100);
	}
}

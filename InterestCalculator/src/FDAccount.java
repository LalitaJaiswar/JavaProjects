import java.util.*;

public class FDAccount extends Account{
	double interestRate;
	double amount;
	int noOfDays;
	int ageOfACHolder;
	int index=-1,mapIndex=-1;
	Map<Integer,double[]> rate=new HashMap<Integer,double[]>();
	FDAccount(double amount,int noOfDays,int ageOfACHolder){
		this.ageOfACHolder=ageOfACHolder;
		this.amount=amount;
		this.noOfDays=noOfDays;
	}
	void initial() {
		rate.put(1,new double[] {4.5,5.0,6.5});
		rate.put(2,new double[] {4.75,5.25,6.75});
		rate.put(3,new double[] {5.5,6,6.75});
		rate.put(4,new double[] {7,7.5,8});
		rate.put(5,new double[] {7.5,8,8.5});
		rate.put(6,new double[] {8,8.5,10});
		}
	double calculateInterest() 
	{
	if(amount<1000000) {
		if(ageOfACHolder<60) {
			index=0;
		}
		else 
			index=1;
		
	}
	else 
	{
		index=2;
	}
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

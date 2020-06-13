public class SBAccount extends Account{
	double interestRate;
	double amount;
	SBAccount(double amount){
		this.amount=amount;
	}
	double calculateInterest()
	{
		return((double)(amount*4)/100);
	}
}

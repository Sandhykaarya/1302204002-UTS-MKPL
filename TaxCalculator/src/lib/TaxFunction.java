package lib;

public class TaxFunction {
	
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		
		int tax;
		
		checkMonth(numberOfMonthWorking);
		numberOfChildren = checkChildren(numberOfChildren);

		tax = married(monthlySalary, otherMonthlyIncome, numberOfMonthWorking, deductible, isMarried, numberOfChildren);
		
		return checkTax(tax);
	}

	public static int checkChildren(int numberOfChildren){
		if (numberOfChildren > 3) {
			return 3;
		}else{
			return numberOfChildren;
		}
	}

	public static void checkMonth(int numberOfMonthWorking){
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
	}

	public static int married(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren){
		if (isMarried) {
			return (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - (54000000 + 4500000 + (numberOfChildren * 1500000))));
		}else {
			return (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - 54000000));
		}
	}

	public static int checkTax(int tax){
		if (tax < 0) {
			return 0;
		}else {
			return tax;
		}
	}
	
}
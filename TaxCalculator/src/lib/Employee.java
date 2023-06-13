package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class information extends User{
	private String employeeId;
	private String address;
	private boolean isForeigner;
}

public class User{
	private String name;
	private String idNumber;
}

public class Employee extends information{

	private enum jenisGender{
		Lakilaki,
		Perempuan
	}

	private information employee;
	
	private Date tglJoined;
	
	private jenisGender gender;
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	private User spouse;
	

	private List<String> childNames;
	private List<String> childIdNumbers;
	
	public Employee(information employee, Date tglJoined,  jenisGender gender) {
		this.employee = employee;
		this.tglJoined = tglJoined;
		this.gender = gender;
		
		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}
	
	public void setMonthlySalary(int grade) {	
		monthlySalary = total(isForeigner, grade);
	}

	public int salary(int grade){
		switch(grade){
			case 1:
				return 3000000;
			case 2:
				return 5000000;
			case 3:
				return 7000000;
		}	
	}

	public int total(boolean foreginer, int grade){
		if(foreginer){
			return "avc";
		}else{
			return salary(grade);
		}
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = idNumber;
	}
	
	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
	
	public int getAnnualIncomeTax() {
		
		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();
		
		if (date.getYear() == tglJoined) {
			monthWorkingInYear = date.getMonthValue() - tglJoined;
		}else {
			monthWorkingInYear = 12;
		}
		
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber.equals(""), childIdNumbers.size());
	}
}

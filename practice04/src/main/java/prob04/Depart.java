package prob04;

public class Depart extends Employee{
	private String department;
	
	public Depart(String name, int salary, String department) {
		super(name, salary);
		this.department = department;
	}
	
	public void print() {
		super.print();
		System.out.println( " 부서:" + department );
	}
}

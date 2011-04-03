package inheritance;

public class BasePlusCommissionEmployee extends CommissionEmployee {
	
		private double m_baseSalary;
	
	public BasePlusCommissionEmployee(String firstName, String lastName,
			String socialSecurityNumber, double commissionRate, 
			double grossSales, double baseSalary)
	{
		super(firstName, lastName, socialSecurityNumber,commissionRate,grossSales);
		setBaseSalary(baseSalary);
			
	}
	
	public void setBaseSalary(double baseSalary)
	{
		m_baseSalary=(baseSalary<0.0)?0.0:baseSalary;
		
	}
	
	public double getBaseSalary()
	{
		return m_baseSalary;
	}
	
	public double earnings ()
	{
		return m_baseSalary+(getGrossSales()*getCommissionRate());
	}
	
	public String toString()
	{
		return String.format("%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f\n%s: %.2f",
				"Commission Employee", getFirstName(), getLastName(),
				"Social Security Number", getSocialSecurityNumber(),
				"Gross Sales", getGrossSales(),
				"Commission Rate", getCommissionRate(),
				"Base Salary", m_baseSalary);
	}
	

}

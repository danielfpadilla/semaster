package inheritance;

public class CommissionEmployee  {
	
	private String m_firstName;
	private String m_lastName;
	private String m_socialSecurityNumber;
	private double m_commissionRate;
	private double m_grossSales;
	
	public CommissionEmployee(String firstName, String lastName,
			String socialSecurityNumber, double commissionRate, 
			double grossSales)
	{
		m_firstName=firstName;
		m_lastName=lastName;
		m_socialSecurityNumber=socialSecurityNumber;
		setGrossSales(grossSales);
		setCommissionRate(commissionRate);
		
	}
	
	public void setCommissionRate(double commissionRate) 
	{
		m_commissionRate=(commissionRate<0.0 && commissionRate >1.0)?0.0:commissionRate;
		
	}

	public void setGrossSales(double grossSales) 
	{
		m_grossSales=(grossSales<0.0)?0.0:grossSales;
		
	}

	public void setFirstName(String firstName)
	{
		m_firstName=firstName;
	}
	
	public void setLastName(String lastName)
	{
		m_lastName=lastName;
		
	}
	
	public void setSocialSecurityNumber(String socialSecurityNumber)
	{
		m_socialSecurityNumber=socialSecurityNumber;
	}
	
	public String getFirstName()
	{
		return m_firstName;
	}
	
	public String getLastName()
	{
		return m_lastName;
	}
	
	public String getSocialSecurityNumber()
	{
		return m_socialSecurityNumber;
	}
	
	public double getCommissionRate()
	{
		return m_commissionRate;
	}
	 
	public double getGrossSales()
	{
		return m_grossSales;
	}
	
	public double earnings ()
	{
		return m_grossSales*m_commissionRate;
	}
	
	public  String toString()
	{
		return String.format("%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f",
				"Commission Employee", m_firstName, m_lastName,
				"Social Security Number", m_socialSecurityNumber,
				"Gross Sales", m_grossSales,
				"Commission Rate", m_commissionRate);
	}
	

}

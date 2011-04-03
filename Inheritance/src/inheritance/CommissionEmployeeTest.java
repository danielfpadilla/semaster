package inheritance;

public class CommissionEmployeeTest {

	public static void main(String[] args) {
		BasePlusCommissionEmployee employee=new BasePlusCommissionEmployee("shaban", "Bakari",
				"22937534", 0.6, 10000,1000);
		
		System.out.println("Employee's information obtained from get methods!");
		
		System.out.printf("%s: %s\n","Employee's first name is",
				employee.getFirstName() );
		
        System.out.printf("%s: %s\n", "Employee's second name is",
        		employee.getLastName());
        
        System.out.printf("%s: %s\n","Employee's social security number is",
        		employee.getSocialSecurityNumber());
        
        System.out.printf("%s: %s\n", "Employee's commission rate is",
        		employee.getCommissionRate());
        
        System.out.printf("%s: %s\n", "Employee's gross sales are",
        		employee.getGrossSales());
        
        System.out.printf("%s: %s\n", "Employee's has base salary of",
        		employee.getBaseSalary());
        
        System.out.printf("%s: %s\n","Employees Earnings are",
        		employee.earnings());
        
        employee.setBaseSalary(5000);
        
        System.out.printf("\n%s:\n%s\n",
        		"the updated information of employee obtained by toString",employee);
        
        
	}

}

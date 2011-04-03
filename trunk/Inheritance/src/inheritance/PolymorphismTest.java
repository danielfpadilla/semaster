package inheritance;

public class PolymorphismTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CommissionEmployee commissionEmployee=new CommissionEmployee("Shaban",
				"Bakari", "22937534", .06, 10000);
		BasePlusCommissionEmployee basePlusCommissionEmployee=new BasePlusCommissionEmployee("Irene",
				"Gatwiry", "22937535", .04, 5000, 300);
		
		System.out.printf("%s %s:\n\n%s\n","call toString method with the super class",
				"reference to superClass object",
				commissionEmployee.toString());
		
		System.out.printf("%s %s:\n\n%s\n","call toString method with the subclass",
				"reference to subClass object",
				basePlusCommissionEmployee.toString());
		
		CommissionEmployee commissionEmployee2=basePlusCommissionEmployee;
		
		System.out.printf("%s %s:\n\n%s\n", "call basePlusCommisionEmployee's toString",
				"with superclass reference to subclass object",
				commissionEmployee2.toString());

	}

}

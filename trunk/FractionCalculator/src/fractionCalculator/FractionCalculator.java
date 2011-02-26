package fractionCalculator;

public class FractionCalculator {
	private int numerator;
		
	private int denominator;
		
	                
	
	        public FractionCalculator() 
	        {
	           numerator=0;
	           denominator=1;
	        }  		
	        public FractionCalculator(int num, int denom) {
	        	if(denom!=0)
	        	{
	              numerator=num;
	              denominator=denom;
	        	}
	        	else
	        		System.exit(0);
		
	        }
		
		
	        public int getNumerator() {
		
	                
		
	                return numerator;
	
	        }
		
		
	        public int getDenominator() {
		
	                
		
	              return denominator;
		
	        }
		
	
	        public void setNum(int inNum) {
	
	                numerator=inNum;
	        }
		
	        public void setDenom(int inDenom) {
	        	
                denominator=inDenom;
           }   
		
	                public String showFraction() {
	             
		
	                return numerator+"/"+denominator;
		
	        }
		

	        public void reduce() {
		
	                // TODO Auto-generated method stub
	
	                
		
	        }

			

}

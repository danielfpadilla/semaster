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
		

	        public String reduce() {
		
	                int gcd=1;
	                int x;
	                if(numerator>denominator)
	                {
	                	x=denominator;	                	
	                }
	                else
	                {
	                	x=numerator;
	                }
	                gcd =x;
	                while(!((numerator%gcd)==0)&&((denominator%gcd)==0))
	                {

    	                x--;	
	                	gcd =x;
	                		
	                }
	                
	                numerator=numerator/gcd;
	                denominator=denominator/gcd;
	                return numerator+"/"+denominator;             
	       
	        }

			

}
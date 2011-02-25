import org.junit.Test;

import fractionCalculator.FractionCalculator;
import junit.framework.Assert;

public class FractionCalculatorTest {
	double denom=1;
	double num=1;
	
	@Test public void createFractionCalculator()
	{
		FractionCalculator fractionCalculator=new FractionCalculator();
		Assert.assertNotNull(fractionCalculator);
	}

   @Test public void canInitializeFractionCalculator()
   {
	FractionCalculator fractionCalculator=new FractionCalculator(num,denom);
	Assert.assertNotNull(fractionCalculator);
    }
   
   @Test public void canGetNumerator()
   {
	   FractionCalculator fractionCalculator=new FractionCalculator();
	   Assert.assertEquals(num, fractionCalculator.getNumerator());
   }
   
   @Test public void canGetDenominator()
   {
	   FractionCalculator fractionCalculator=new FractionCalculator();
	   Assert.assertEquals(denom, fractionCalculator.getDenominator());	   
   }
   @Test public void canSetNumeratorAndDenominator()
   {
	   FractionCalculator fractionCalculator=new FractionCalculator();
	   fractionCalculator.setNumeratorAndDenominator(2,2);
	   Assert.assertNotNull(fractionCalculator);
   }
   
   @Test public void canShowTheFraction()
   {
	   FractionCalculator fractionCalculator=new FractionCalculator();
	   Assert.assertEquals("1.0/1.0", fractionCalculator.showFraction());
   }
   
   @Test public void canReduceFractionToSimplestForm()
   {
	   FractionCalculator fractionCalculator=new FractionCalculator();
	   fractionCalculator.reduce();
	   Assert.assertNotNull(fractionCalculator);
   }
   
      
}
package fractionCalculator;

import org.junit.Test;
import junit.framework.Assert;

import fractionCalculator.FractionCalculator;
	
	
public class FractionCalculatorTest {
	
        double denom=1;
	
        double num=1;

		private Object FractionCalculator;
	
        

        @Test public void createFractionCalculator()
	
        {
	
                FractionCalculator fractionCalculator=new FractionCalculator();
	
                Assert.assertNotNull(fractionCalculator);
	
        }
	
   @Test public void canInitializeFractionCalculator()
	
   {	
        FractionCalculator fractionCalculator=new FractionCalculator();
        Assert.assertNotNull(fractionCalculator);
	
    }
	
   
	
   @Test public void canGetNumerator()
	
   {
	
           FractionCalculator fractionCalculator=new FractionCalculator();
	
           Assert.assertEquals(0, fractionCalculator.getNumerator());
	
   }
	
   
	
   @Test public void canGetDenominator()
	
   {
	
           FractionCalculator fractionCalculator=new FractionCalculator();
	
           Assert.assertEquals(1, fractionCalculator.getDenominator());           
	
   }
   
   @Test public void canSetNumerator()
	
   {
	
           FractionCalculator fractionCalculator=new FractionCalculator();
	
           fractionCalculator.setNum(0);
	
           Assert.assertNotNull(fractionCalculator);
	
   }
   
   @Test public void canSetDenomenator()
	
   {
	
           FractionCalculator fractionCalculator=new FractionCalculator();
	
           fractionCalculator.setDenom(0);
	
           Assert.assertNotNull(fractionCalculator);
	
   }
	
   
	
   @Test public void canShowTheFraction()
	
   {
	
           FractionCalculator fractionCalculator=new FractionCalculator(1,1);
	
           Assert.assertEquals("1/1", fractionCalculator.showFraction());
	
   }
	
   
	
   @Test public void canReduceFractionToSimplestForm()
	
   {
	
           FractionCalculator fractionCalculator=new FractionCalculator();
	
           fractionCalculator.reduce();
	
           Assert.assertNotNull(fractionCalculator);
	
   }
   
  @Test public void createFractionOperations()
  {
	  FractionOperations fractionOperations=new FractionOperations();
	  Assert.assertNotNull(fractionOperations);
  }
  
 @Test public void canInitializeFractionOperations()
  {   
	 FractionCalculator fractionCalculator=new FractionCalculator();
	  FractionOperations fractionOperations=new FractionOperations(fractionCalculator);
	  Assert.assertNotNull(fractionOperations);
	  
  }
 
 @Test public void canInitializewithTwoOjects()
 {
	 FractionCalculator fraction1=new FractionCalculator();
	 FractionCalculator fraction2=new FractionCalculator();
	 FractionOperations fractionOperations=new FractionOperations(fraction1,fraction2);
	 Assert.assertNotNull(fractionOperations);
 }
 
 @Test public void canAddFractions()
 {
	 FractionOperations fractionOperations=new FractionOperations();
	 fractionOperations.addFractions();
	 Assert.assertNotNull(fractionOperations);
	 
}
 
 @Test public void canSubstract()
 {
	 FractionOperations fractionOperations=new FractionOperations();
	 fractionOperations.subtractFractions();
	 Assert.assertNotNull(fractionOperations);
 }
 
 @Test public void canMultiplyFractions()
 {
	 FractionOperations fractionOperations=new FractionOperations();
	 fractionOperations.multiplyFractions();
	 Assert.assertNotNull(fractionOperations);
 }
 
 @Test public void canDivideFractions()
 {
	 FractionOperations fractionOperations=new FractionOperations();
	 fractionOperations.divideFractions();
	 Assert.assertNotNull(fractionOperations);
 }
}


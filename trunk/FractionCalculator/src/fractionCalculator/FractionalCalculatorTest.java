package fractionCalculator;

import org.junit.Test;
import junit.framework.Assert;

import fractionCalculator.FractionCalculator;
	
	
public class FractionalCalculatorTest {
	       int num=0;
	       int denom=1;
	       double delta=0.0001;

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
	
           Assert.assertEquals(0, fractionCalculator.getNumerator());
	
   }
	
   
	
   @Test public void canGetDenominator()
	
   {
	
           FractionCalculator fractionCalculator=new FractionCalculator();
	
           Assert.assertEquals(denom, fractionCalculator.getDenominator());           
	
   }
   
   @Test public void canSetNumerator()
	
   {
	
           FractionCalculator fractionCalculator=new FractionCalculator();
	
           fractionCalculator.setNum(num);
	
           Assert.assertEquals(num, fractionCalculator.getNumerator());
	
   }
   
   @Test public void canSetDenomenator()
	
   {
	
           FractionCalculator fractionCalculator=new FractionCalculator();
	
           fractionCalculator.setDenom(denom);
	
           Assert.assertEquals(denom, fractionCalculator.getDenominator());
	
   }
	
   
	
   @Test public void canShowTheFraction()
	
   {
	
           FractionCalculator fractionCalculator=new FractionCalculator(num,denom);
	
           Assert.assertEquals("0/1", fractionCalculator.showFraction());
	
   }
	
   
	
   @Test public void canReduceFractionToSimplestForm()
	
   {
	
           FractionCalculator fractionCalculator=new FractionCalculator(4,8);
	
           
	
           Assert.assertEquals("1/2", fractionCalculator.reduce());
	
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
	 FractionCalculator fraction1=new FractionCalculator(1,2);
	 FractionCalculator fraction2=new FractionCalculator(2,2);
	 
	 Assert.assertEquals("6/4", fractionOperations.addFractions(fraction1,fraction2));
	 
}
 
 @Test public void canSubstract()
 {
	 FractionOperations fractionOperations=new FractionOperations();
	 FractionCalculator fraction1=new FractionCalculator(0,2);
	 FractionCalculator fraction2=new FractionCalculator(1,4);
	 
	 Assert.assertEquals("-2/8", fractionOperations.subtractFractions(fraction1,fraction2));
 }
 
 @Test public void canMultiplyFractions()
 {
	 FractionOperations fractionOperations=new FractionOperations();
	 FractionCalculator fraction1=new FractionCalculator(1,2);
	 FractionCalculator fraction2=new FractionCalculator(1,4);
	 
	 Assert.assertEquals("1/8", fractionOperations.multiplyFractions(fraction1,fraction2));
 }
 
 @Test public void canDivideFractions()
 {
	 FractionOperations fractionOperations=new FractionOperations();
	 FractionCalculator fraction1=new FractionCalculator(1,2);
	 FractionCalculator fraction2=new FractionCalculator(1,4);
	 
	 Assert.assertEquals("4/2", fractionOperations.divideFractions(fraction1,fraction2));
 }
}


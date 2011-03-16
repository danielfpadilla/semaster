package matrixoperations;

import junit.framework.Assert;

import org.junit.Test;
public class test {
	@Test public void canCreateMatrix()
	{
		Matrix operations=new Matrix();
		Assert.assertNotNull(operations);
	}
	
    @Test public void canInitializeMatrix()
    {
    	double[][] a = {{1,2},{1,2}};
    	Matrix operations=new Matrix(a);
    	Assert.assertNotNull(operations);
    }
    
    @Test public void canPrintMatrix()
    {
    	double[][] a = {{1,2},{1,2}};
    	Matrix matrix=new Matrix(a);
    	Assert.assertEquals("{{1.0,2.0,},{1.0,2.0,},}",matrix.toString());
    	
    }
     
    @Test public void canAddMatrices()
    {
    	double[][] a = {{1,2},{1,2}};
    	//Matrix object1=new Matrix(a);
    	//Matrix object2=new Matrix(a);
    	
    	double [][]res = {{2,4},{2,4}};
    	Matrix object3=new Matrix(res);
    	
    	Assert.assertEquals(object3, Matrix.sum(a,a));
    	
    	
    	
    }
    @Test public void canSubtractMatrices()
    {
    	
    	double [][] b={{2,2},{2,2}};
    	double [][]c={{1,1},{1,1}};
    	double [][]difference={{1,1},{1,1}};
    	
    	Matrix object4= new Matrix(difference);
    	Assert.assertEquals(object4,Matrix.subtract(b,c));
    	
    	
    }
    
    
    
    
    

}

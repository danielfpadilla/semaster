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
    
    /*@Test public void canPrintMatrix()
    {
    	double[][] a = {{1,2},{1,2}};
    	Matrix matrix=new Matrix(a);
    	Assert.assertTrue(matrix.equals("{{1.0,2.0,0,},{1.0,2.0,0.0,},{0.0,0.0,0.0,},}"));
    	
    }*/
    
    @Test public void canAddTheMatrices()
    {
    	double[][] a = {{1,2},{1,2}};
    	Matrix matA=new Matrix(a);
    	//double [][] b = {{1,2},{1,2}};
        Matrix matB=new Matrix(a);
    	double [][] res = {{2,4},{2,4}};
    	Matrix matRes = new Matrix(res);
    	double [][]actual = {{0,0},{0,0}};
    	Matrix actualres = new Matrix(actual);
    	Assert.assertEquals(res,actualres.sum(a,a));
    	
    }

}

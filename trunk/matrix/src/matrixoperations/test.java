package matrixoperations;


import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Test;
public class test {
	private final double DELTA =0.0001;
	private int m_size=1;
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
    
    @Test public void canInitializeSize()
    {
    	Matrix matrix = new Matrix(m_size);
    	Assert.assertNotNull(matrix);
    }
    
    @Test 
    public void canSetSize()
    {
    	Matrix matrix = new Matrix();
    	matrix.setSize(m_size);
    	Assert.assertEquals(m_size, matrix.getSize());
    	
    }
    
    @Test
    public void canThrowExceptionIfSizeLessThanZero() throws Exception
    {
    	try
    	{
    		 new Matrix(-1);
    		fail("Error! the size cannot be negative!");
    	}catch(IllegalArgumentException expected)
    	{}
    	
    	
    }
    
    @Test
    public void canGetSize()
    {
    	Matrix matrix=new Matrix();
    	matrix.getSize();
    	Assert.assertNotNull(matrix);
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
    
    @Test
    public void calculateDeterminant2X2()
    {
        double [][] matrixData = {{2, 1},{5, 1}};
        Matrix matrix = new Matrix();
        double result = matrix.Determinant(matrixData);
        Assert.assertEquals(-3, result, DELTA);
    }
    
    @Test
    public void canFindAdjointOfMatrix()
    {
    	double [][] data={{1,2},{3,4}};
        double[][] act={{4,2},{3,1}};
        Matrix matrix=new Matrix();
    	
    	double[][] exp= matrix.Adjoint(data);
    	Matrix actual=new Matrix(exp);
    	Matrix expected =new Matrix(act);    	
    	Assert.assertEquals(expected,actual);
    }
    
    
    @Test
    public void canFindInverseOfMatrix() throws Exception 
    {   
    	double [][] data={{4,2},{2,2}};
    	Matrix matrix=new Matrix(data);
    	
    	double [][] act={{0.5,-0.5},{-0.5,1}};
    	double [][] exp=matrix.Inverse(data);
    	Matrix expected=new Matrix(exp);
    	Matrix actual=new Matrix(act);
    	
    	Assert.assertEquals(expected, actual);
    }
    
    @Test 
    public void canThrowExceptionIfDeterminantIsZero() throws Exception
    {
    	try
    	{
    	Matrix matrix = new Matrix();
    	double [][] data={{4,0},{2,0}};
    	matrix.Inverse(data);
    	fail("Cannot find inverse! ");
    	} 
    	catch(IllegalArgumentException e){}
    	   	
    }
    
    /*@Test 
    public void canGetUpperTiangularMatrix()
    {
    	Matrix matrix = new Matrix();
    	double [][] a= {{1,2},{3,4}};
    	double[][] exp={{1,2},{4,10}};
    	double [][]act=matrix.UpperTriangle(a);
    	Matrix expected=new Matrix(exp);
    	Matrix actual=new Matrix(act);
    	
    	Assert.assertEquals(expected, actual);
    }*/
    
    @Test
    public void canCalculateRowColumnProduct()
    {   
    	int i=1,j=1;
    	double [][] a={{1,2},{3,4}};
    	double [][] b={{1,2},{3,4}};
    	Matrix matrix=new Matrix();
    	double res=matrix.calculateRowColumnProduct(a, i, b, j);
    	
    	Assert.assertEquals(22, res,DELTA);
    }
    
    
    @Test 
    public void canMultiplyMatrices()throws Exception
    {
    	Matrix matrix=new Matrix();
    	double [][] a={{1,2},{3,4}};
    	double [][] b={{1,2},{3,4}};
    	double [][] exp={{7,10},{15,22}};
    	double [][] act=matrix.multiplyMatrix(a,b);
    	Matrix expected=new Matrix(exp);
    	Matrix actual=new Matrix(act);
    	
    	Assert.assertEquals(expected, actual);
    	
    	    }
    @Test
    public void canThrowExceptionIfMatricesAreNotOfSameSize()throws Exception
    {
    	try
    	{
    		Matrix matrix=new Matrix();
        	double [][] a={{1,2,3},{3,4,5}};
        	double [][] b={{1,2},{3,4}};
        	matrix.multiplyMatrix(a,b);
        	fail("matrices have different dimensions!");
    	}
    	catch(Exception e)
    	{}
    }
    
    
    
}


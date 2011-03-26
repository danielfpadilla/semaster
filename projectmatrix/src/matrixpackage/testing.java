package matrixpackage;
import org.junit.Assert;
import org.junit.Test;


public class testing
{
	private int m_size;
	@Test public void CanCreateMatrix()
	{ 
		Matrix matrix=new Matrix();
		Assert.assertNotNull(matrix);	
	}
	@Test public void canSetSizeForMatrix()
	{
		Matrix matrix=new Matrix(2);
		Assert.assertNotNull(matrix);
	}

	@Test public void CanInitializeMatrix()	
	{       double [][]a={{1,2},{1,3}};
	        Assert.assertNotNull(a);
	}
	@Test public void canCreateaDefaultConstructor()
	{
		Matrix matrix=new Matrix();
		Assert.assertNotNull(matrix);
	}

	@Test
	public void canGetSize()
	{
		Matrix matrix=new Matrix();
		matrix.getSize();
		Assert.assertNotNull(matrix);
	}
	@Test 
	public void canSetSize()
	{
		Matrix matrix = new Matrix();
		matrix.setSize(m_size);
		Assert.assertEquals(m_size, matrix.getSize());

	}
	

	@Test public void canAddMatrices()
	{

		double[][] a = {{1,2},{1,2}};
		double [][] b= {{1,2},{1,2}};
		Matrix object1=new Matrix(a,2);
		Matrix object2=new Matrix(b,2);
		
		double [][]res = {{2,4},{2,4}};
		Matrix object3 = new Matrix(res,2);
		
		Matrix object4 = new Matrix();
		object4 = object1.add(object2);
                
		Assert.assertEquals(object3,object4);

	}

	@Test public void canSubtractMatrices()
	{

		double[][] a = {{2,4},{2,4}};
		double [][] b= {{1,2},{1,2}};
		Matrix object1=new Matrix(a,2);
		Matrix object2=new Matrix(b,2);
		
		double [][]res = {{1,2},{1,2}};
		Matrix object3 = new Matrix(res,2);
		
		Matrix object4 = new Matrix();
		object4 = object1.subtract(object2);
                
		Assert.assertEquals(object3,object4);

	}
	
}
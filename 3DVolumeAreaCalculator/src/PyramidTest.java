import org.junit.Test;
import junit.framework.Assert;

public class PyramidTest 
{
	int edge = 3; //lenght of edge in pyramid's base
	int NumberOfEdge = 7; //number of edge in pyramid's base
	int height = 5;
	@Test public void CanCreatePyramid()
	 {
		 Pyramid pyramid = new Pyramid();
		 Assert.assertNotNull(pyramid);
	 }
	@Test public void CanInitializePyramid()
	 {
		 Pyramid pyramid = new Pyramid(edge, NumberOfEdge, height);
		 Assert.assertNotNull(pyramid);
	 }
}

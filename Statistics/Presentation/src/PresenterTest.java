import junit.framework.Assert;
import org.junit.Test;


public class PresenterTest 
{
	@Test public void canCreate()
	{
		Presenter presenter = new Presenter(new View());
		Assert.assertNotNull(presenter);
	}
	
	@Test public void canAdd()
	{
		View view = new View();
		Presenter presenter = new Presenter(view);
		view.m_number1  = "1";
		view.m_number2 = "2";
		view.m_handler.processAddAction();
		Assert.assertEquals("3.0", view.m_result);
	}
	
	@Test public void canMultiply()
	{
		View view = new View();
		Presenter presenter = new Presenter(view);
		
		view.m_number1 = "2";
		view.m_number2 = "4";
		view.m_handler.processMultiplyAction();
		Assert.assertEquals("8.0", view.m_result);
	}
	
	/*@Test public void canCalculateExpectation()
	{
		View view = new View();
		Presenter presenter = new Presenter(view);
		view.size = 2;
		view.m_array = new double[view.size];
		view.m_array[0] = 1.0;
		view.m_array[1] = 2.0;
		view.m_handler.processExpectationAction();
		Assert.assertEquals(1.5, view.m_result);
	}
	
	@Test public void canCalculateExpectationForDiscreteDistribution()
	{
		View view = new View();
		Presenter presenter = new Presenter(view);
		view.m_number1 = "1.0";
		view.m_number2 = "2.0";
		view.m_probability1 = "0.6";
		view.m_probability2 = "0.4";
		view.m_handler.processExpectationAction();
		Assert.assertEquals("1.4", view.m_result);
	}*/
}

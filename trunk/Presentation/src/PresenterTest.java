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
		View view=new View();
		new Presenter(view);
		view.m_number1= "1";
		view.m_number2="2";
		view.m_handler.processAddAction();
		Assert.assertEquals("3",view.m_result);
	}
}





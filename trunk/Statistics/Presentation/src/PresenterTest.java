import junit.framework.Assert;
import org.junit.Test;


public class PresenterTest 
{
	Presenter presenter = new Presenter(new View());
	
	@Test public void canCreate()
	{
		Assert.assertNotNull(presenter);
	}
	
	@Test public void canClearM_sizeText()
	{
		View view = new View();
		view.m_size = "5";		
		view.m_handler.processClearAction();
		Assert.assertEquals("0", view.m_size);
	}
	
	@Test public void canAddText()
	{
		View view = new View();
		view.m_type = 1;
	//	view.m_value = "1,2";
		view.size = 3;
		view.m_handler.processParseArgumentAction();
		double one = view.m_arrayOfValue[0];
		Assert.assertEquals(1, one);
	}

}

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
		Assert.assertEquals(" ", view.m_size);
	}

}

import junit.framework.Assert;
import org.junit.Test;


public class PresenterTest 
{
	@Test public void canCreate()
	{
		Presenter presenter = new Presenter(new View());
		Assert.assertNotNull(presenter);
	}

}

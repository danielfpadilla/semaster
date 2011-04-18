import org.junit.Test;
import junit.framework.Assert;

public class ParameterValueExceptionTest 
{
	int parameter = -1;
	String message = "ParameterValueException[" + parameter + "]";
	@Test public void CanCreateParameterValueException()
	{
		ParameterValueException pve = new ParameterValueException();
		Assert.assertNotNull(pve);
	}
	@Test public void CanInitializeParameterValueException()
	{
		ParameterValueException pve = new ParameterValueException(parameter);
		Assert.assertNotNull(pve);
	}
	@Test public void CanReturnExceptionMessage()
	{
		ParameterValueException pve = new ParameterValueException(parameter);
		Assert.assertEquals(message, pve.toString());
	}
	
}

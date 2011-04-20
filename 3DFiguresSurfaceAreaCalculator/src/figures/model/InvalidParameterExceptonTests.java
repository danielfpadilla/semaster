package figures.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class InvalidParameterExceptonTests
{
	@Test
	public void canCreateInvalidParameterException()
	{
		
		InvalidParameterException m_exception = new InvalidParameterException("");
		assertNotNull(m_exception);
	}
	@Test
	public void canGetErrorMessage()
	{
		InvalidParameterException m_exception = new InvalidParameterException("Invalid Input");
		assertEquals("Invalid Input", m_exception.getErrorMessage());

	}

}

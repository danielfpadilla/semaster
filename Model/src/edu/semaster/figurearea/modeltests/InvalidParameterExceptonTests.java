package edu.semaster.figurearea.modeltests;
import static org.junit.Assert.*;

import org.junit.Test;

import edu.semaster.figurearea.model.InvalidParameterException;

public class InvalidParameterExceptonTests
{
	@Test
	public void canCreateInvalidParameterException()
	{
		
		InvalidParameterException exception = new InvalidParameterException("");
		assertNotNull(exception);
	}
	@Test
	public void canGetErrorMessage()
	{
		InvalidParameterException exception = new InvalidParameterException("Invalid Input");
		assertEquals("Invalid Input", exception.getErrorMessage());

	}

}

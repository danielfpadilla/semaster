import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.Assert;

public class helloTest {
	@Test
	public void  testHello() {
		Hello myHello = new Hello();
		assertEquals("Hello World", myHello.message());
} 
	}

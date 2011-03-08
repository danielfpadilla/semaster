import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;

public class ExampleTest {
    protected int m_value;

    @Before
    public void setUp() {
	m_value = 10;
    }

    @Test
    public void TestSetUp() {
        Assert.assertEquals(10, m_value);
    }

    @After
    public void tearDown() {
	m_value = -1;
    }

    @Test
    public void CanCreateExample() {
	Example example = new Example();
	Assert.assertNotNull(example);
    }
}





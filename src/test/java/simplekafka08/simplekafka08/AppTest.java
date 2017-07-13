package simplekafka08.simplekafka08;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	
	private static final Logger LOG = LoggerFactory.getLogger(ConsumerDemo.class);
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
    	
  
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
      	try {
    			String	path = new File( "." ).getCanonicalPath() + "/resource/log4j.properties";
    			PropertyConfigurator.configure(path);
    		} catch (IOException e) {
    			 //TODO Auto-generated catch block
    			e.printStackTrace();
    		}
      	LOG.info("test");
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}

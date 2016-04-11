package c3pio;

import c3pio.TCPServer;
import junit.framework.TestCase;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Before;

public class TCPServerTest extends TestCase {

    TCPServer server;


    @Before
    public void setUp() throws Exception {
        server = new TCPServer(null);

    }

    @After
    public void tearDown() throws Exception {
        server = null;
    }

    public void testStringToJSON() throws Exception {
        String testString = "{\"TestType\":\"TestValue\"}";
        String returnString = server.stringToJSON(testString).toString();
        assertEquals(testString,returnString);
    }

    public void testParseJSON() throws Exception {
        String testString = "{\"request\":\"nonExist\"}";
        try{
           server.parseJSON(server.stringToJSON(testString));
            fail("Exception not thrown");
        }
        catch (Exception e){
            assertEquals("Default thrown",e.getMessage());
        }
    }



}

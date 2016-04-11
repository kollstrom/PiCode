package c3pio;

import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TCPServerTest{

    TCPServer server;


    @Before
    public void setUp() throws Exception {
        server = new TCPServer(null);

    }

    @After
    public void tearDown() throws Exception {
        server = null;
    }

    @Test
    public void testStringToJSON() throws Exception {
        String testString = "{\"TestType\":\"TestValue\"}";
        String returnString = server.stringToJSON(testString).toString();
        assertEquals(testString,returnString);
    }

    @Test
    public void testParseJSON() throws Exception {
        String testString = "{\"request\":\"nonExist\"}";
        try{
           server.parseJSON(server.stringToJSON(testString));
            fail("Exception not thrown");
        }
        catch (Exception e){
            assertEquals("No request found",e.getMessage());
        }
    }

    @Test
    public void testWriteResponse() throws Exception {
        try {
            JSONObject reply = new JSONObject();
            server.writeResponse(reply);
        } catch (Exception e) {
            // TODO: Ingenting blir testet her!
        }
    }

}

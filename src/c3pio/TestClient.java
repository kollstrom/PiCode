package c3pio;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.net.*;

/**
 * This class is only used for testing the TCP-server module.
 * The real TCP-client is the Android-phone.
 */

public class TestClient {

    public static void main(String args[]) throws Exception{
        JSONParser parser = new JSONParser();

        String filepath = "src\\c3pio\\username.json";
        String host = "localhost";

        JSONObject payload = new JSONObject();
        try{
            System.out.println("Read file");

            Object obj = parser.parse(new FileReader(filepath));

            JSONObject testObj = (JSONObject) obj;

            payload.put("request","execute");
            payload.put("profile",testObj.toString());
        }

        catch (FileNotFoundException e){
            System.out.println("Can't read file");
        }
        catch (Exception e){
            System.out.println("Trouble with JSON");
        }

        try{
            Socket clientSocket = new Socket(host, 6789);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println(payload.toString());
            outToServer.writeBytes(payload.toString() + '\n');
            String receivedString = inFromServer.readLine();
            System.out.println(receivedString);

            JSONObject jsonObject = (JSONObject) parser.parse(receivedString);

            clientSocket.close();

        }catch (Exception e){
            System.out.println("Fuck deg ittno connection");
        }
    }
}

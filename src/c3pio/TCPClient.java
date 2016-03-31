package c3pio;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.net.*;

public class TCPClient {

    public static void main(String args[]) throws Exception{

        JSONParser parser = new JSONParser();


        JSONObject payload = new JSONObject();
        try{
            Object obj = parser.parse(new FileReader("C:\\Users\\Miklel\\Documents\\NTNU\\PU\\PiCode\\src\\c3pio\\username.json"));
            JSONObject testObj = (JSONObject) obj;
            System.out.println(testObj.toString());

            payload.put("request","save");
            payload.put("profile",testObj.toString());
        }

        catch (Exception e){
            System.out.println("Fuck deg");
        }

        try{

            Socket clientSocket = new Socket("129.241.13.44", 6789);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            outToServer.writeBytes(payload.toString() + '\n');
            String receivedString = inFromServer.readLine();

            System.out.println("FROM SERVER: " + receivedString);
            System.out.println("COMPARE: " + payload.toString());


            JSONObject jsonObject = (JSONObject) parser.parse(receivedString);
            System.out.println(jsonObject.toString());


            clientSocket.close();

        }catch (Exception e){
            System.out.println("Fuck deg ittno connection");
        }

        /*
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + '\n');
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        clientSocket.close();
        */
    }
}

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
            System.out.println("Read file");

            Object obj = parser.parse(new FileReader("C:\\Users\\Miklel\\Documents\\NTNU\\PU\\PiCode\\PiCode\\src\\c3pio\\username.json"));

            JSONObject testObj = (JSONObject) obj;


            payload.put("request","execute");
            payload.put("profile",testObj.toString());
        }

        catch (FileNotFoundException e){
            System.out.println("Cant read file");
        }
        catch (Exception e){
            System.out.println("Trouble with JSON");
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

package c3pio;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.net.*;

class TCPServer implements Runnable{

    private String threadName;

    Controller controller;

    BufferedReader inFromClient;

    DataOutputStream outToClient;

    public TCPServer(Controller controller){

        this.controller = controller;
        System.out.println("Creating server");
        new Thread (this).start();
    }

    public void run(){
        try{


            ServerSocket welcomeSocket = new ServerSocket(6789);

            System.out.println("Waiting for connection");
            Socket connectionSocket = welcomeSocket.accept();
            System.out.println("Client Connected");
            this.inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            this.outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            String clientString = inFromClient.readLine();
            JSONObject clientJSON = stringToJSON(clientString);
            parseJSON(clientJSON);
        }
        catch (FileNotFoundException e){
            System.out.println("Someting wong");
        }
        catch (Exception e){
            System.out.println("Trouble with Json");
        }
    }

    public void parseJSON(JSONObject payload) throws Exception{

        String request = payload.get("request").toString();
        System.out.println("Client request: " + request);
        switch(request){


            case "execute":
                this.requestExecute(payload);
                break;

            case "save":
                this.requestSave(payload);
                break;

            case "login":
                break;

            default:
                throw new Exception("Default thrown");
        }
    }

    public void requestSave(JSONObject payload){
        JSONObject profile = controller.getCarSettingsAsJSON();
        JSONObject reply = new JSONObject();
        try{
            reply.put("request", "save");
            reply.put("profile", profile.toString());
            this.outToClient.writeBytes(reply.toString() + "\n");
            System.out.println("Wrote profile to client");
        } catch (Exception e) {
            System.out.println("Couldt reply with profile");

        }
    }

    public void requestExecute(JSONObject payload){
        try{
            System.out.println("Executing");
            controller.setCarSettingsFromJSON(payload.get("profile").toString());
        }
        catch (Exception e){
            System.out.println("\"profile\" ekisterer ikke i pakken");
        }

    }

    public JSONObject stringToJSON(String inputString) throws Exception{
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(inputString);
    }
}

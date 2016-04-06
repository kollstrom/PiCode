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
            while (true){

                Socket connectionSocket = welcomeSocket.accept();
                this.inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                this.outToClient = new DataOutputStream(connectionSocket.getOutputStream());

                String clientString = inFromClient.readLine();
                JSONObject clientJSON = stringToJSON(clientString);

                System.out.println(clientJSON);

                parseJSON(clientJSON);


            }


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

            case "check":
                this.requestCheck(payload);
                break;

            default:
                throw new Exception("Default thrown");
        }
    }

    public void requestSave(JSONObject payload){
        JSONObject profile = controller.getCarSettingsAsJSON();
        try{
            writeResponse(stringToJSON(profile.toString()));
        } catch (Exception e) {
            System.out.println("Couldn't reply with profile");

        }
    }



    public void requestExecute(JSONObject payload){
        try{
            controller.setCarSettingsFromJSON(payload.get("profile").toString());
            JSONObject reply = new JSONObject();
            reply.put("message", "Profile executed");
            writeResponse(reply);
        }
        catch (Exception e){
            System.out.println("\"profile\" ekisterer ikke i pakken");
        }

    }

    public void requestCheck(JSONObject payload){
        double promilledouble = controller.alcoholMeasurement();
        String promille = String.valueOf(promilledouble);
        try{
            JSONObject reply = new JSONObject();
            reply.put("message", promille);
            writeResponse(reply);
        }
        catch(Exception e){
            System.out.println("Wong with alcohol JSON");
        }
    }


    public JSONObject stringToJSON(String inputString) throws Exception{
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(inputString);
    }

    public void writeResponse(JSONObject reply) throws Exception {
        this.outToClient.writeBytes(reply.toString() + "\n");
        System.out.println("Wrote response: " + reply.toString());
    }
}

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

        /** This is a threaded method that keeps listening on socket 6789.
         * When something is received the message gets parsed in the parseJSON method.
         */

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

        catch (Exception e){
            System.out.println("Couldn't convert client string to JSON");
        }
    }

    public void parseJSON(JSONObject payload) throws Exception{

        /**
        *The received object gets sent to the method that handles
        * given request.
         */

        String request = payload.get("request").toString();
        System.out.println("Client request: " + request);
        switch(request){


            case "execute":
                this.requestExecute(payload);
                break;

            case "save":
                this.requestSave(payload);
                break;

            case "check":
                this.requestCheck(payload);
                break;

            default:
                throw new Exception("No request found");
        }
    }

    public void requestSave(JSONObject payload){

        /**
         * Reads the current profile and sends it to client.
         */

        JSONObject profile = controller.getCarSettingsAsJSON();
        try{
            writeResponse(stringToJSON(profile.toString()));
        }
        catch (IOException e){
            System.out.println("Couldn't write to client in requestSave");
        }
        catch (Exception e){
            System.out.println("Couldn't convert to JSON in requestSave");
        }
    }



    public void requestExecute(JSONObject payload){

        /**
         * Executes the profile given by the client by uploading it into the carSettings.
         */

        try{
            controller.setCarSettingsFromJSON(payload.get("profile").toString());
            JSONObject reply = new JSONObject();
            reply.put("message", "Profile executed");
            writeResponse(reply);
        }
        catch (IOException e){
            System.out.println("Couldn't write to client in requestExecute");
        }
        catch (Exception e){
            System.out.println("Wrong with JSON in requestExecute");
        }

    }

    public void requestCheck(JSONObject payload){

        /**
         * Stats reading from the alcometer and sends the reading to the client.
         */

        double promilledouble = controller.alcoholMeasurement();
        String promille = String.valueOf(promilledouble);
        try{
            JSONObject reply = new JSONObject();
            reply.put("message", promille);
            writeResponse(reply);
        }
        catch (IOException e){
            System.out.println("Couldn't write to client in requestCheck");
        }
        catch(Exception e){
            System.out.println("Couldnt convert to JSON in requestCheck");

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

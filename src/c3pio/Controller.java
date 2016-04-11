package c3pio;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;

import java.io.StringWriter;
import java.util.Date;

public class Controller {
    private CarSettings carSettings;
    private Simulator simulator;
    private TCPServer server;

    public Controller() {

        /**
         * Initializes all the other classes that runs on the raspberry pi.
         * Since the server is threaded (runs in the background), it's started first.
         */

        this.server = new TCPServer(this);
        this.carSettings = new CarSettings();
        this.simulator = new Simulator(this, this.carSettings);
    }

    public JSONObject stringToJSON(String inputString) throws Exception{
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(inputString);
    }

    public void setCarSettingsFromJSON(String profileAsJSON){

        /**
         * Writes the given JSONstring to the car, with loads of exceptions if something is missing
         */

        try{
           JSONObject JSONObject = stringToJSON(profileAsJSON);

            try{
                carSettings.setSteeringWheelTilt(Integer.parseInt(JSONObject.get("steering_wheel_tilt").toString()));
            }
            catch (Exception e){
                System.out.println("steering_wheel_tilt error");
            }
            try{
                carSettings.setSteeringWheelDepth(Integer.parseInt(JSONObject.get("steering_wheel_depth").toString()));
            }
            catch (Exception e){
                System.out.println("2 steering_wheel_depth");
            }
            try{
                carSettings.setRadioStation((String) JSONObject.get("radio_station"));
            }
            catch (Exception e){
                System.out.println("3 radio_station");
            }
            try{
                carSettings.setWingMirrorLeftX(Integer.parseInt(JSONObject.get("wing_mirror_left_x").toString()));
            }
            catch (Exception e){
                System.out.println("4 wing_mirror_left_x");
            }
            try{
                carSettings.setWingMirrorLeftY(Integer.parseInt(JSONObject.get("wing_mirror_left_y").toString()));
            }
            catch (Exception e){
                System.out.println("5 wing_mirror_left_y");
            }
            try{
                carSettings.setWingMirrorRightX(Integer.parseInt(JSONObject.get("wing_mirror_right_x").toString()));
            }
            catch (Exception e){
                System.out.println("6 wing_mirror_right_x");
            }
            try{
                carSettings.setWingMirrorRightY(Integer.parseInt(JSONObject.get("wing_mirror_right_y").toString()));
            }
            catch (Exception e){
                System.out.println("7 wing_mirror_right_y");
            }
            try{
                carSettings.setSeatHeight(Integer.parseInt(JSONObject.get("seat_height").toString()));
            }
            catch (Exception e){
                System.out.println("8 seat_height");
            } try{
                carSettings.setSeatDepth(Integer.parseInt(JSONObject.get("seat_depth").toString()));
            }
            catch (Exception e){
                System.out.println("9 seat_depth");
            } try{
                carSettings.setSeatBackAngle(Integer.parseInt(JSONObject.get("seat_back_angle").toString()));
            }
            catch (Exception e){
                System.out.println("10 seat_back_angle");
            }
            try{
                carSettings.setSeatHeadAngle(Integer.parseInt(JSONObject.get("seat_depth").toString()));
            }
            catch (Exception e){
                System.out.println("11 seat_depth");
            }
            try{
                carSettings.setSeatBackDepth(Integer.parseInt(JSONObject.get("seat_back_depth").toString()));
            }
            catch (Exception e){
                System.out.println("12 seat_back_depth");
            }try{
                carSettings.setTemperature(Integer.parseInt(JSONObject.get("temperature").toString()));
            }
            catch (Exception e){
                System.out.println("13 temperature");
            }

            System.out.println("Successfully read from app.");
            System.out.println(carSettings);
        }
        catch (Exception e){
            System.out.println("Couldn't convert received string to JSON in setCarSettingsFromJSON");
        }
    }

    public double alcoholMeasurement(){
        /**
         * Used by the server to give the alcohol reading to the client.
         */

        return Simulator.alcoholMeasurement();
    }

    @SuppressWarnings("unchecked")
    public JSONObject getCarSettingsAsJSON(){

        /**
         * Reads the cars current settings and returns it as a JSONObject
         */

        JSONObject j = new JSONObject();

        j.put("steering_wheel_tilt",carSettings.getSteeringWheelTilt());
        j.put("steering_wheel_depth",carSettings.getSteeringWheelDepth());
        j.put("radio_station", carSettings.getRadioStation());
        j.put("wing_mirror_left_x",carSettings.getWingMirrorLeftX());
        j.put("wing_mirror_left_y",carSettings.getWingMirrorLeftY());
        j.put("wing_mirror_right_x",carSettings.getWingMirrorRightX());
        j.put("wing_mirror_right_y",carSettings.getWingMirrorRightY());
        j.put("seat_height",carSettings.getSeatHeight());
        j.put("seat_depth",carSettings.getSeatDepth());
        j.put("seat_back_angle",carSettings.getSeatBackAngle());
        j.put("seat_head_angle",carSettings.getSeatHeadAngle());
        j.put("seat_back_depth",carSettings.getSeatBackDepth());
        j.put("temperature",carSettings.getTemperature());
        j.put("timestamp", new Date().getTime());

        return j;
    }

    public static void main(String[] args){
        Controller c = new Controller();
    }
}

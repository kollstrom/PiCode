package c3pio;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Date;

public class Controller {

    private CarSettings carSettings;

    public Controller() {

        /**
         * Initializes all the other classes that runs on the raspberry pi.
         * Since the server is threaded (runs in the background), it's started first.
         */

        TCPServer server = new TCPServer(this);
        this.carSettings = new CarSettings();
        Simulator simulator = new Simulator(this, this.carSettings);
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
                int swt = Integer.parseInt(JSONObject.get("steering_wheel_tilt").toString());
                carSettings.setSteeringWheelTilt(swt);
                Simulator.ps.println("steeringWheelTilt");
                Simulator.ps.println(swt);
            }
            catch (Exception e){
                System.out.println("steering_wheel_tilt error");
            }
            try{
                int swd = Integer.parseInt(JSONObject.get("steering_wheel_depth").toString());
                carSettings.setSteeringWheelDepth(swd);
                Simulator.ps.println("steeringWheelDepth");
                Simulator.ps.println(swd);
            }
            catch (Exception e){
                System.out.println("2 steering_wheel_depth");
            }
            try{
                carSettings.setWingMirrorLeftX(Integer.parseInt(JSONObject.get("wing_mirror_left_x").toString()));
            }
            catch (Exception e){
                System.out.println("4 wing_mirror_left_x");
            }
            try{
                int wml = Integer.parseInt(JSONObject.get("wing_mirror_left_y").toString());
                carSettings.setWingMirrorLeftY(wml);
                Simulator.ps.println("wingMirrorLeftY");
                Simulator.ps.println(wml);
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
                int wmr = Integer.parseInt(JSONObject.get("wing_mirror_right_y").toString());
                carSettings.setWingMirrorRightY(wmr);
                Simulator.ps.println("wingMirrorRightY");
                Simulator.ps.println(wmr);
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
                int seatDepth = Integer.parseInt(JSONObject.get("seat_depth").toString());
                carSettings.setSeatDepth(seatDepth);
                Simulator.ps.println("seatDepth");
                Simulator.ps.println(seatDepth);
            }
            catch (Exception e){
                System.out.println("9 seat_depth");
            } try{
                int seatBackAngle = Integer.parseInt(JSONObject.get("seat_back_angle").toString());
                carSettings.setSeatBackAngle(seatBackAngle);
                Simulator.ps.println("seatBackAngle");
                Simulator.ps.println(seatBackAngle);
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
            try{
                String station = (String) JSONObject.get("radio_station");
                carSettings.setRadioStation(station);
                Simulator.ps.println("radioStation");
                Simulator.ps.println(station);
            }
            catch (Exception e){
                System.out.println("3 radio_station");
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

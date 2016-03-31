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
        this.server = new TCPServer(this);
        this.carSettings = new CarSettings();
        this.simulator = new Simulator(this, this.carSettings);

    }

    public JSONObject stringToJSON(String inputString) throws Exception{
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(inputString);
    }

    public void setCarSettingsFromJSON(String profileAsJSON){


        try{
           JSONObject JSONObject = stringToJSON(profileAsJSON);
            System.out.println("Execute file: " + JSONObject);

            try{
                carSettings.setSteeringWheelTilt(Integer.parseInt(JSONObject.get("steering_wheel_tilt").toString()));
            }
            catch (Exception e){
                System.out.println("1");
            }
            try{
                carSettings.setSteeringWheelDepth(Integer.parseInt(JSONObject.get("steering_wheel_depth").toString()));
            }
            catch (Exception e){
                System.out.println("2");
            }
            try{
                carSettings.setRadioStation((String) JSONObject.get("radio_station"));
            }
            catch (Exception e){
                System.out.println("3");
            }
            try{
                carSettings.setSteeringWheelDepth(Integer.parseInt(JSONObject.get("steering_wheel_depth").toString()));
            }
            catch (Exception e){
                System.out.println("4");
            }
            try{
                carSettings.setSteeringWheelDepth(Integer.parseInt(JSONObject.get("steering_wheel_depth").toString()));
            }
            catch (Exception e){
                System.out.println("5");
            }
            try{
                carSettings.setSteeringWheelDepth(Integer.parseInt(JSONObject.get("steering_wheel_depth").toString()));
            }
            catch (Exception e){
                System.out.println("6");
            }
            try{
                carSettings.setWingMirrorLeftX(Integer.parseInt(JSONObject.get("wing_mirror_left_x").toString()));
            }
            catch (Exception e){
                System.out.println("7");
            }
            try{
                carSettings.setWingMirrorLeftY(Integer.parseInt(JSONObject.get("wing_mirror_left_y").toString()));
            }
            catch (Exception e){
                System.out.println("8");
            }
            try{
                carSettings.setWingMirrorRightX(Integer.parseInt(JSONObject.get("wing_mirror_right_x").toString()));
            }
            catch (Exception e){
                System.out.println("9");
            }
            try{
                carSettings.setWingMirrorRightY(Integer.parseInt(JSONObject.get("wing_mirror_right_y").toString()));
            }
            catch (Exception e){
                System.out.println("10");
            }
            try{
                carSettings.setSeatHeight(Integer.parseInt(JSONObject.get("seat_height").toString()));
            }
            catch (Exception e){
                System.out.println("11");
            } try{
                carSettings.setSeatDepth(Integer.parseInt(JSONObject.get("seat_depth").toString()));
            }
            catch (Exception e){
                System.out.println("12");
            } try{
                carSettings.setSeatBackAngle(Integer.parseInt(JSONObject.get("seat_back_angle").toString()));
            }
            catch (Exception e){
                System.out.println("13");
            }
            try{
                carSettings.setSeatHeadAngle(Integer.parseInt(JSONObject.get("seat_depth").toString()));
            }
            catch (Exception e){
                System.out.println("14");
            }try{

            }
            catch (Exception e){
                System.out.println("15");
            }try{
                carSettings.setSeatBackDepth(Integer.parseInt(JSONObject.get("seat_back_depth").toString()));
            }
            catch (Exception e){
                System.out.println("16");
            }try{
                carSettings.setTemperature(Integer.parseInt(JSONObject.get("temperature").toString()));
            }
            catch (Exception e){
                System.out.println("17");
            }




            System.out.println("Successfully read from app.");

        }
        catch (Exception e){
            System.out.print("Someting wang with recieved JSON");
        }


    }
    public static void main(String[] args){
        Controller c = new Controller();

/*        CarSettings carSettings = new CarSettings();
        JSONObject j = c.getCarSettingsAsJSON(carSettings);
        StringWriter out = new StringWriter();
        try{
            j.writeJSONString(out);
        }
        catch(Exception e){
        }
        System.out.println(j);
        c.setCarSettingsFromJSON("[" +
                "{\"profile_name\":\"emil\", \"timestamp\":1364326174.617000," +
                "\"profile_email\":\"emil@kollstrom.net\", "+
                "\"ignition_status\":\"off\","+
                "\"steering_wheel_tilt\":5,"+
                "\"steering_wheel_depth\":5,"+
                "\"radio_station\":\"NRK P3\","+
                "\"wing_mirror_left_x\":5,"+
                "\"wing_mirror_left_y\":5,"+
                "\"wing_mirror_right_x\":5,"+
                "\"wing_mirror_right_y\":5,"+
                "\"seat_height\":5,"+
                "\"seat_depth\":5,"+
                "\"seat_back_angle\":5,"+
                "\"seat_head_angle\":5,"+
                "\"seat_back_depth\":5,"+
                "\"temperature\":21}"+
                "]");
*/
    }
    private static CarSettings.IgnitionStatusType getIgnitionStatusTypeFromString(String ignitionTypeString) {
        if(ignitionTypeString.toLowerCase().equals("off")){
            return CarSettings.IgnitionStatusType.OFF;
        }
        else if(ignitionTypeString.toLowerCase().equals("start")){
            return CarSettings.IgnitionStatusType.START;
        }
        else if(ignitionTypeString.toLowerCase().equals("accessory")){
            return CarSettings.IgnitionStatusType.ACCESSORY;
        }
        else if(ignitionTypeString.toLowerCase().equals("run")){
            return CarSettings.IgnitionStatusType.RUN;
        }
        return CarSettings.IgnitionStatusType.OFF;
    }

    @SuppressWarnings("unchecked")
    public JSONObject getCarSettingsAsJSON(){
        JSONObject j = new JSONObject();

        j.put("ignition_status",carSettings.getIgnitionStatus().toString());
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
}

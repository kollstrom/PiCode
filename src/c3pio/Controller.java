package c3pio;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;

import java.io.StringWriter;
import java.util.Date;

public class Controller {
    private CarSettings carSettings;
    private Simulator simulator;

    public Controller() {
        this.carSettings = new CarSettings();
        this.simulator = new Simulator(this, this.carSettings);
    }

    public void setCarSettingsFromJSON(String profileAsJSON){
        JSONParser parser = new JSONParser();

        try{
            Object obj = parser.parse(profileAsJSON);
            JSONArray array = (JSONArray)obj;
            JSONObject JSONObject = (JSONObject)array.get(0);
            carSettings.setIgnitionStatus(Controller.getIgnitionStatusTypeFromString(JSONObject.get("ignition_status").toString()));
            carSettings.setSteeringWheelTilt(Integer.parseInt(JSONObject.get("steering_wheel_tilt").toString()));
            carSettings.setSteeringWheelDepth(Integer.parseInt(JSONObject.get("steering_wheel_depth").toString()));
            carSettings.setRadioStation((String) JSONObject.get("radio_station"));
            carSettings.setWingMirrorLeftX(Integer.parseInt(JSONObject.get("wing_mirror_left_x").toString()));
            carSettings.setWingMirrorLeftY(Integer.parseInt(JSONObject.get("wing_mirror_left_y").toString()));
            carSettings.setWingMirrorRightX(Integer.parseInt(JSONObject.get("wing_mirror_right_x").toString()));
            carSettings.setWingMirrorRightY(Integer.parseInt(JSONObject.get("wing_mirror_right_y").toString()));
            carSettings.setSeatHeight(Integer.parseInt(JSONObject.get("seat_height").toString()));
            carSettings.setSeatDepth(Integer.parseInt(JSONObject.get("seat_depth").toString()));
            carSettings.setSeatBackAngle(Integer.parseInt(JSONObject.get("seat_back_angle").toString()));
            carSettings.setSeatHeadAngle(Integer.parseInt(JSONObject.get("seat_depth").toString()));
            carSettings.setSeatBackDepth(Integer.parseInt(JSONObject.get("seat_back_depth").toString()));
            carSettings.setTemperature(Integer.parseInt(JSONObject.get("temperature").toString()));

            System.out.println("Successfully read from app.");

        }
        catch (Exception e){
            System.out.print(e.getMessage());
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
    public JSONObject getCarSettingsAsJSON(CarSettings carSettings){
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

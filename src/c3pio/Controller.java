package c3pio;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;

import java.io.StringWriter;
import java.util.Date;

/**
 * Created by Philipp on 03.03.2016.
 */
public class Controller {
    private CarSettings carSettings;
    private Simulator simulator;

    public Controller() {
        this.carSettings = new CarSettings();
        this.simulator = new Simulator(this, this.carSettings);
    }

    public void setCarSettingsFromJSON(String profileAsJSON){
        carSettings = new CarSettings();

        JSONParser parser = new JSONParser();

        try{
            Object obj = parser.parse(profileAsJSON);
            JSONArray array = (JSONArray)obj;
            JSONObject jsnobject = (JSONObject)array.get(0);


            carSettings.setIgnitionStatus(getIgnitionStatusTypeFromString(jsnobject.get("ignition_status").toString()));
            carSettings.setSteeringWheelTilt((int) jsnobject.get("steering_wheel_tilt"));
            carSettings.setSteeringWheelDepth((int) jsnobject.get("steering_wheel_depth"));
            carSettings.setRadioStation((String) jsnobject.get("radio_station"));
            carSettings.setWingMirrorLeftX((int) jsnobject.get("wing_mirror_left_x"));
            carSettings.setWingMirrorLeftY((int) jsnobject.get("wing_mirror_left_y"));
            carSettings.setWingMirrorRightX((int) jsnobject.get("wing_mirror_right_x"));
            carSettings.setWingMirrorRightY((int) jsnobject.get("wing_mirror_right_y"));
            carSettings.setSeatHeight((int) jsnobject.get("seat_height"));
            carSettings.setSeatDepth((int) jsnobject.get("seat_depth"));
            carSettings.setSeatBackAngle((int) jsnobject.get("seat_back_angle"));
            carSettings.setSeatHeadAngle((int) jsnobject.get("seat_head_angle"));
            carSettings.setSeatBackDepth((int)jsnobject.get("seat_back_depth"));
            carSettings.setTemperature((int) jsnobject.get("temperature"));

        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }


    }

    public static void main(String[] args){
        CarSettings carSettings = new CarSettings();
        Controller c = new Controller();
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

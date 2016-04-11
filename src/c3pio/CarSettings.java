package c3pio;

public class CarSettings {

    private IgnitionStatusType ignitionStatus;
    private int steeringWheelTilt;
    private int steeringWheelDepth;
    private String radioStation;
    private int wingMirrorLeftX;
    private int wingMirrorLeftY;
    private int wingMirrorRightX;
    private int wingMirrorRightY;
    private int seatHeight;
    private int seatDepth;
    private int seatBackAngle;
    private int seatHeadAngle;
    private int seatBackDepth;
    private int temperature;

    public CarSettings() {
        setIgnitionStatus(IgnitionStatusType.OFF);
        setRadioStation("NrkP3");
        setTemperature(15);

    }

    public IgnitionStatusType getIgnitionStatus() {
        return ignitionStatus;
    }

    public void setIgnitionStatus(IgnitionStatusType ignitionStatus) {
        this.ignitionStatus = ignitionStatus;
    }

    public enum IgnitionStatusType{
        OFF,  RUN, ACCESSORY,  START
    }

    public int getSteeringWheelTilt() {
        return steeringWheelTilt;
    }

    public void setSteeringWheelTilt(int steeringWheelTilt) {
        if (steeringWheelTilt > 90 || steeringWheelTilt < 0){
            throw new IllegalArgumentException("Number must be between 0 and 90");
        }
        this.steeringWheelTilt = steeringWheelTilt;
    }
    
    public int getSteeringWheelDepth() {
        return steeringWheelDepth;
    }

    public void setSteeringWheelDepth(int steeringWheelDepth) {
        if (steeringWheelDepth < 0 || steeringWheelDepth > 10){
            throw new IllegalArgumentException("Number must be between 0 and 10");
        }
        this.steeringWheelDepth = steeringWheelDepth;
    }

    public String getRadioStation() {
        return radioStation;
    }

    public void setRadioStation(String radioStation) {
        if (radioStation.equals("")){
            throw new IllegalArgumentException("The String cannot be empty");
        }
        this.radioStation = radioStation;
    }

    public int getWingMirrorLeftX() {
        return wingMirrorLeftX;
    }

    public void setWingMirrorLeftX(int wingMirrorLeftX) {
        if (wingMirrorLeftX < -25 || wingMirrorLeftX > 25){
            throw new IllegalArgumentException("Number must be between -25 and 25");
        }
        this.wingMirrorLeftX = wingMirrorLeftX;
    }

    public int getWingMirrorLeftY() {
        return wingMirrorLeftY;
    }

    public void setWingMirrorLeftY(int wingMirrorLeftY) {
        if (wingMirrorLeftY < -25 || wingMirrorLeftY > 25){
            throw new IllegalArgumentException("Number must be between -25 and 25");
        }
        this.wingMirrorLeftY = wingMirrorLeftY;
    }

    public int getWingMirrorRightX() {
        return wingMirrorRightX;
    }

    public void setWingMirrorRightX(int wingMirrorRightX) {
        if (wingMirrorRightX < -25 || wingMirrorRightX > 25){
            throw new IllegalArgumentException("Number must be between -25 and 25");
        }
        this.wingMirrorRightX = wingMirrorRightX;
    }

    public int getWingMirrorRightY() {
        return wingMirrorRightY;
    }

    public void setWingMirrorRightY(int wingMirrorRightY) {
        if (wingMirrorRightY < -25 || wingMirrorRightY > 25){
            throw new IllegalArgumentException("Number must be between -25 and 25");
        }
        this.wingMirrorRightY = wingMirrorRightY;
    }

    public int getSeatHeight() {
        return seatHeight;
    }

    public void setSeatHeight(int seatHeight) {
        if (seatHeight < 0 || seatHeight > 10){
            throw new IllegalArgumentException("Number must be between 0 and 10");
        }
        this.seatHeight = seatHeight;
    }

    public int getSeatDepth() {
        return seatDepth;
    }

    public void setSeatDepth(int seatDepth) {
        if (seatDepth < 0 || seatDepth > 10){
            throw new IllegalArgumentException("Number must be between 0 and 10");
        }
        this.seatDepth = seatDepth;
    }

    public int getSeatBackAngle() {
        return seatBackAngle;
    }

    public void setSeatBackAngle(int seatBackAngle) {
        if (seatBackAngle < -90 || seatBackAngle > 90){
            throw new IllegalArgumentException("Number must be between -90 and 90");
        }
        this.seatBackAngle = seatBackAngle;
    }

    public int getSeatHeadAngle() {
        return seatHeadAngle;
    }

    public void setSeatHeadAngle(int seatHeadAngle) {
        if (seatHeadAngle < -90 || seatHeadAngle > 90){
            throw new IllegalArgumentException("Number must be between -90 and 90");
        }
        this.seatHeadAngle = seatHeadAngle;
    }

    public int getSeatBackDepth() {
        return seatBackDepth;
    }

    public void setSeatBackDepth(int seatBackDepth) {
        if (seatBackDepth < 0 || seatBackDepth > 10){
            throw new IllegalArgumentException("Number must be between 0 and 10");
        }
        this.seatBackDepth = seatBackDepth;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        if (temperature < 15 || temperature > 25){
            throw new IllegalArgumentException("Number must be between 15 and 25");
        }
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "CarSettings:" + "\n" + "\t" +
                " 1. ignitionStatus = " + ignitionStatus + "\n" + "\t" +
                " 2. steeringWheelTilt = " + steeringWheelTilt + "\n" + "\t" +
                " 3. steeringWheelDepth = " + steeringWheelDepth + "\n" + "\t" +
                " 4. radioStation = '" + radioStation + '\'' + "\n" + "\t" +
                " 5. wingMirrorLeftX = " + wingMirrorLeftX + "\n" + "\t" +
                " 6. wingMirrorLeftY = " + wingMirrorLeftY + "\n" + "\t" +
                " 7. wingMirrorRightX = " + wingMirrorRightX + "\n" + "\t" +
                " 8. wingMirrorRightY = " + wingMirrorRightY + "\n" + "\t" +
                " 9. seatHeight = " + seatHeight + "\n" + "\t" +
                "10. seatDepth = " + seatDepth + "\n" + "\t" +
                "11. seatBackAngle = " + seatBackAngle + "\n" + "\t" +
                "12. seatHeadAngle = " + seatHeadAngle + "\n" + "\t" +
                "13. seatBackDepth = " + seatBackDepth + "\n" + "\t" +
                "14. temperature = " + temperature;
    }
}
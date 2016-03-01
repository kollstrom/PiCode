package c3pio;

public class CarSettings {

    private enum ignitionStatus{OFF, ACCESSORY, RUN, START};
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

    public int getSteeringWheelTilt() {
        return steeringWheelTilt;
    }

    public void setSteeringWheelTilt(int steeringWheelTilt) {
        this.steeringWheelTilt = steeringWheelTilt;
    }


    public int getSteeringWheelDepth() {
        return steeringWheelDepth;
    }

    public void setSteeringWheelDepth(int steeringWheelDepth) {
        this.steeringWheelDepth = steeringWheelDepth;
    }

    public String getRadioStation() {
        return radioStation;
    }

    public void setRadioStation(String radioStation) {
        this.radioStation = radioStation;
    }

    public int getWingMirrorLeftX() {
        return wingMirrorLeftX;
    }

    public void setWingMirrorLeftX(int wingMirrorLeftX) {
        this.wingMirrorLeftX = wingMirrorLeftX;
    }

    public int getWingMirrorLeftY() {
        return wingMirrorLeftY;
    }

    public void setWingMirrorLeftY(int wingMirrorLeftY) {
        this.wingMirrorLeftY = wingMirrorLeftY;
    }

    public int getWingMirrorRightX() {
        return wingMirrorRightX;
    }

    public void setWingMirrorRightX(int wingMirrorRightX) {
        this.wingMirrorRightX = wingMirrorRightX;
    }

    public int getWingMirrorRightY() {
        return wingMirrorRightY;
    }

    public void setWingMirrorRightY(int wingMirrorRightY) {
        this.wingMirrorRightY = wingMirrorRightY;
    }

    public int getSeatHeight() {
        return seatHeight;
    }

    public void setSeatHeight(int seatHeight) {
        this.seatHeight = seatHeight;
    }

    public int getSeatDepth() {
        return seatDepth;
    }

    public void setSeatDepth(int seatDepth) {
        this.seatDepth = seatDepth;
    }

    public int getSeatBackAngle() {
        return seatBackAngle;
    }

    public void setSeatBackAngle(int seatBackAngle) {
        this.seatBackAngle = seatBackAngle;
    }

    public int getSeatHeadAngle() {
        return seatHeadAngle;
    }

    public void setSeatHeadAngle(int seatHeadAngle) {
        this.seatHeadAngle = seatHeadAngle;
    }

    public int getSeatBackDepth() {
        return seatBackDepth;
    }

    public void setSeatBackDepth(int seatBackDepth) {
        this.seatBackDepth = seatBackDepth;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

}
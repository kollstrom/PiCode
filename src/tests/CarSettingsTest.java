import c3pio.CarSettings;
import junit.framework.TestCase;

/**
 * Created by Emil on 01.03.2016.
 */
public class CarSettingsTest extends TestCase {

    public void testSetSteeringWheelTilt() throws Exception {
        CarSettings car1 = new CarSettings();
        car1.setSteeringWheelTilt(90);
        assertEquals(90, car1.getSteeringWheelTilt());
    }

    public void testSetSteeringWheelDepth() throws Exception {

    }

    public void testSetRadioStation() throws Exception {

    }

    public void testSetWingMirrorLeftX() throws Exception {

    }

    public void testSetWingMirrorLeftY() throws Exception {

    }

    public void testSetWingMirrorRightX() throws Exception {

    }

    public void testSetWingMirrorRightY() throws Exception {

    }

    public void testSetSeatHeight() throws Exception {

    }

    public void testSetSeatDepth() throws Exception {

    }

    public void testSetSeatBackAngle() throws Exception {

    }

    public void testSetSeatHeadAngle() throws Exception {

    }

    public void testSetSeatBackDepth() throws Exception {

    }

    public void testSetTemperature() throws Exception {

    }
}
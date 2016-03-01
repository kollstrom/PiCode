package c3pio;
import c3pio.CarSettings;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by Emil on 01.03.2016.
 */
public class CarSettingsTest {

    CarSettings car;

    @Before
    public void setUp() throws Exception {
        car = new CarSettings();

    }

    @Test
    public void testSetSteeringWheelTilt(){
        car.setSteeringWheelTilt(90);
        assertEquals(90, car.getSteeringWheelTilt());
    }

    @Test
    public void testThrowExceptionIfSteeringWheelTiltIsOver90(){
        try {
            car.setSteeringWheelTilt(91);
            fail("IllegalArgumentException expected: values can not be over 90");
        }catch(IllegalArgumentException iae){
        }
    }


    @Test
    public void testThrowExceptionIfSteeringWheelTiltIsNegative(){
        try {
            car.setSteeringWheelTilt(-1);
            fail("IllegalArgumentException expected: values can not be negative");
        }catch(IllegalArgumentException iae){
        }
    }

    @Test
    public void testSetSteeringWheelDepth() throws Exception {
        car.setSteeringWheelDepth(10);
        assertEquals(10, car.getSteeringWheelDepth());
    }

    @Test
    public void testThrowExceptionIfSteeringWheelDepthIsNegative(){
        try {
            car.setSteeringWheelDepth(-1);
            fail("IllegalArgumentException expected: values can not be negative");
        }catch(IllegalArgumentException iae){
        }
    }

    @Test
    public void testThrowExceptionIfSteeringWheelDepthIsOver10(){
        try {
            car.setSteeringWheelDepth(11);
            fail("IllegalArgumentException expected: values can not be negative");
        }catch(IllegalArgumentException iae){
        }
    }
    @Test
    public void testSetRadioStation() throws Exception {

    }
    @Test
    public void testSetWingMirrorLeftX() throws Exception {

    }
    @Test
    public void testSetWingMirrorLeftY() throws Exception {

    }
    @Test
    public void testSetWingMirrorRightX() throws Exception {

    }
    @Test
    public void testSetWingMirrorRightY() throws Exception {

    }
    @Test
    public void testSetSeatHeight() throws Exception {

    }
    @Test
    public void testSetSeatDepth() throws Exception {

    }
    @Test
    public void testSetSeatBackAngle() throws Exception {

    }
    @Test
    public void testSetSeatHeadAngle() throws Exception {

    }
    @Test
    public void testSetSeatBackDepth() throws Exception {

    }
    @Test
    public void testSetTemperature() throws Exception {

    }
}
package c3pio;

import org.junit.After;
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

    @After
    public void tearDown() throws Exception {
        car = null;
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
            //Nice! Test was approved
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
            fail("IllegalArgumentException expected: values can not be over 10");
        }catch(IllegalArgumentException iae){
        }
    }
    @Test
    public void testSetRadioStation() throws Exception {
        car.setRadioStation("NRK");
        assertEquals("NRK", car.getRadioStation());
    }

    @Test
    public void testThrowExceptionIfRadioStationStringIsEmpty(){
        try{
            car.setRadioStation("");
            fail("IllegalArgumentException expected: String cannot be empty");
        }
        catch(IllegalArgumentException iae){
        }
    }

    @Test
    public void testSetWingMirrorLeftX() throws Exception {
        car.setWingMirrorLeftX(25);
        assertEquals(25, car.getWingMirrorLeftX());
    }

    @Test
    public void testThrowExceptionIfWingMirrorLeftXIsUnderMinus25(){
        try{
            car.setWingMirrorLeftX(-26);
            fail("IllegalArgumentException expected: values cannot be under -25");
        }
        catch(IllegalArgumentException iae){
        }
    }

    @Test
    public void testThrowExceptionIfWingMirrorLeftXIsOver25(){
        try{
            car.setWingMirrorLeftX(26);
            fail("IllegalArgumentException expected: values cannot be over 25");
        }
        catch(IllegalArgumentException iae){
        }
    }

    @Test
    public void testSetWingMirrorLeftY() throws Exception {
        car.setWingMirrorLeftY(-25);
        assertEquals(-25, car.getWingMirrorLeftY());
    }

    @Test
    public void testThrowExceptionIfWingMirrorLeftYIsUnderMinus25(){
        try{
            car.setWingMirrorLeftY(-26);
            fail("IllegalArgumentException expected: values cannot be under -25");
        }
        catch(IllegalArgumentException iae){
        }
    }

    @Test
    public void testThrowExceptionIfWingMirrorLeftYIsOver25(){
        try{
            car.setWingMirrorLeftY(26);
            fail("IllegalArgumentException expected: values cannot be over 25");
        }
        catch(IllegalArgumentException iae){
        }
    }
    @Test
    public void testSetWingMirrorRightX() throws Exception {
        car.setWingMirrorRightX(25);
        assertEquals(25, car.getWingMirrorRightX());
    }

    @Test
    public void testThrowExceptionIfWingMirrorRightXIsUnderMinus25(){
        try{
            car.setWingMirrorRightX(-26);
            fail("IllegalArgumentException expected: values cannot be under -25");
        }
        catch(IllegalArgumentException iae){
        }
    }

    @Test
    public void testThrowExceptionIfWingMirrorRightXIsOver25(){
        try{
            car.setWingMirrorRightX(26);
            fail("IllegalArgumentException expected: values cannot be over 25");
        }
        catch(IllegalArgumentException iae){
        }
    }

    @Test
    public void testSetWingMirrorRightY() throws Exception {
        car.setWingMirrorRightY(-25);
        assertEquals(-25, car.getWingMirrorRightY());
    }

    @Test
    public void testThrowExceptionIfWingMirrorRightYIsUnderMinus25(){
        try{
            car.setWingMirrorRightY(-26);
            fail("IllegalArgumentException expected: values cannot be under -25");
        }
        catch(IllegalArgumentException iae){
        }
    }

    @Test
    public void testThrowExceptionIfWingMirrorRightYIsOver25(){
        try{
            car.setWingMirrorRightY(26);
            fail("IllegalArgumentException expected: values cannot be over 25");
        }
        catch(IllegalArgumentException iae){
        }
    }

    @Test
    public void testSetSeatHeight() throws Exception {
        car.setSeatHeight(10);
        assertEquals(10, car.getSeatHeight());
    }

    @Test
    public void testThrowExceptionIfSeatHeightIsOver10(){
        try{
            car.setSeatHeight(11);
            fail("IllegalArgumentException expected: values cannot be over 10");
        }
        catch(IllegalArgumentException iae){
        }
    }
    @Test
    public void testThrowExceptionIfSeatHeightIsUnder0(){
        try{
            car.setSeatHeight(-1);
            fail("IllegalArgumentException expected: values cannot be under 0");
        }
        catch(IllegalArgumentException iae){
        }
    }

    @Test
    public void testSetSeatDepth() throws Exception {
        car.setSeatDepth(0);
        assertEquals(0, car.getSeatDepth());
    }
    @Test
    public void testThrowExceptionIfSeatDepthIsOver10(){
        try{
            car.setSeatDepth(11);
            fail("IllegalArgumentException expected: values cannot be over 10");
        }
        catch(IllegalArgumentException iae){
        }
    }
    @Test
    public void testThrowExceptionIfSeatDepthIsUnder0(){
        try{
            car.setSeatDepth(-1);
            fail("IllegalArgumentException expected: values cannot be under 0");
        }
        catch(IllegalArgumentException iae){
        }
    }

    @Test
    public void testSetSeatBackAngle() throws Exception {
        car.setSeatBackAngle(45);
        assertEquals(45, car.getSeatBackAngle());
    }
    @Test
    public void testThrowExceptionIfSeatBackAngleIsOVer90(){
        try{
            car.setSeatBackAngle(46);
            fail("IllegalArgumentException expected: values cannot be over 90");
        }
        catch(IllegalArgumentException iae){
        }
    }
    @Test
    public void testThrowExceptionIfSeatBackAngleIsUnderMinus90(){
        try{
            car.setSeatBackAngle(-91);
            fail("IllegalArgumentException expected: values cannot be under 90");
        }
        catch(IllegalArgumentException iae){
        }
    }

    @Test
    public void testSetSeatHeadAngle() throws Exception {
        car.setSeatHeadAngle(-90);
        assertEquals(-90, car.getSeatHeadAngle());
    }

    @Test
    public void testThrowExceptionIfSeatHeadAngleIsOVer90(){
        try{
            car.setSeatHeadAngle(91);
            fail("IllegalArgumentException expected: values cannot be over 90");
        }
        catch(IllegalArgumentException iae){
        }
    }
    @Test
    public void testThrowExceptionIfSeatHeadAngleIsUnderMinus90(){
        try{
            car.setSeatHeadAngle(-91);
            fail("IllegalArgumentException expected: values cannot be under 90");
        }
        catch(IllegalArgumentException iae){
        }
    }

    @Test
    public void testSetSeatBackDepth() throws Exception {
        car.setSeatBackDepth(10);
        assertEquals(10, car.getSeatBackDepth());
    }

    @Test
    public void testThrowExceptionIfSeatBackDepthIsOver10(){
        try{
            car.setSeatBackDepth(11);
            fail("IllegalArgumentException expected: values cannot be over 10");
        }
        catch(IllegalArgumentException iae){
        }
    }
    @Test
    public void testThrowExceptionIfSeatBackDepthIsUnder0(){
        try{
            car.setSeatBackDepth(-1);
            fail("IllegalArgumentException expected: values cannot be under 0");
        }
        catch(IllegalArgumentException iae){
        }
    }

    @Test
    public void testSetTemperature() throws Exception {
        car.setTemperature(20);
        assertEquals(20, car.getTemperature());
    }

    @Test
    public void testThrowExceptionIfTemperatureIsOver25(){
        try{
            car.setTemperature(26);
            fail("IllegalArgumentException expected: values cannot be over 25");
        }
        catch(IllegalArgumentException iae){
        }
    }
    @Test
    public void testThrowExceptionIfTemperatureIsUnder15() {
        try {
            car.setTemperature(14);
            fail("IllegalArgumentException expected: values cannot be under 15");
        } catch (IllegalArgumentException iae) {
        }
    }

}
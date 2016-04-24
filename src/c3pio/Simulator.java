package c3pio;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Simulator {

    private Controller controller;
    private CarSettings carSettings;

    private Socket clientSocket;
    private static PrintStream ps;

    /*
     * Simulator constructor that takes in a Controller- and CarSettings-object
     * and assigns them to its local variables.
     *
     * It also tries to start the connection with the car/EV3, if it fails to
     * do so, the stackTrace is printed.
     *
     * In the end, the local run() method is called.
     */

    public Simulator(Controller c, CarSettings carSettings) {
        Controller controller = c;
        this.carSettings = carSettings;

        try {
            this.clientSocket = new Socket("10.0.1.1", 4321);
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            this.ps = new PrintStream(clientSocket.getOutputStream());
        }
        catch (IOException e){
            print("Couldn't connect to legoCar.");
        }
        this.run();
    }

    /*
     * This method prints out whatever it gets as parameter.
     */

    public static void print(Object o){
        System.out.println(o);
    }

    /*
     * The run() method is a simple input based program that reacts different
     * on specific user-based input.
     */

    public void run() {

        Scanner scanner = new Scanner(System.in);

        //This String contains all the commands recognized by the run() method.
        String help = "\nType: \n" +
                "settings - to print current settings\n" +
                "change - to change a setting \n" +
                "check - to check your blood alcohol concentration \n" +
                "quit - to quit program\n \n";

        print("Welcome to your car.\n");
        while(true){
            print(help);
            String in = scanner.nextLine();
            if (in.equals("")){

                /*In case the input is empty/enter, which also happens when you
                 * write something to the scanner and then press 'enter', you get
                 * another chance to write a command.
                 */
                in = scanner.nextLine();
            }
            if(in.equals("settings")){
                print(carSettings);
            }
            else if(in.equals("check")){

                /*
                 * Calls the method that measures your alcohol-level and prints the result.
                 */
                print("Your Blood Alcohol Concentration is : ");
                print(alcoholMeasurement());
            }
            else if(in.equals("change")){

                /*
                 * Method that lists all setting-numbers and enters new menu
                 * that allows you to choose what to change and enter input.
                 */
                print(carSettings.toString()+ "\n");
                print("Type 0 to change all settings. \nType 1-14 to change one setting at a time.");
                String change = scanner.nextLine();
                switch (change){
                    case "0":
                        changeSteeringWheelTilt(carSettings, scanner);
                        changeSteeringWheelDepth(carSettings, scanner);
                        changeRadioStation(carSettings, scanner);
                        changeWingMirrorLeftX(carSettings, scanner);
                        changeWingMirrorLeftY(carSettings, scanner);
                        changeWingMirrorRightX(carSettings, scanner);
                        changeWingMirrorRightY(carSettings, scanner);
                        changeSeatHeight(carSettings, scanner);
                        changeSeatDepth(carSettings, scanner);
                        changeSeatBackAngle(carSettings, scanner);
                        changeSeatHeadAngle(carSettings, scanner);
                        changeSeatBackDepth(carSettings, scanner);
                        changeTemperature(carSettings, scanner);
                        break;
                    case "1":
                        changeSteeringWheelTilt(carSettings, scanner);
                        break;
                    case "2":
                        changeSteeringWheelDepth(carSettings, scanner);
                        break;
                    case "3":
                        changeRadioStation(carSettings, scanner);
                        break;
                    case "4":
                        changeWingMirrorLeftX(carSettings, scanner);
                        break;
                    case "5":
                        changeWingMirrorLeftY(carSettings, scanner);
                        break;
                    case "6":
                        changeWingMirrorRightX(carSettings, scanner);
                        break;
                    case "7":
                        changeWingMirrorRightY(carSettings, scanner);
                        break;
                    case "8":
                        changeSeatHeight(carSettings, scanner);
                        break;
                    case "9":
                        changeSeatDepth(carSettings, scanner);
                        break;
                    case "10":
                        changeSeatBackAngle(carSettings, scanner);
                        break;
                    case "11":
                        changeSeatHeadAngle(carSettings, scanner);
                        break;
                    case "12":
                        changeSeatBackDepth(carSettings, scanner);
                        break;
                    case "13":
                        changeTemperature(carSettings, scanner);
                        break;
                    default:
                        print(change+ " wasn't recognized as a command.");
                        break;
                }
            }
            else if(in.equals("quit")){

                /*
                 * A quit command is send to the car/EV3 that tells it to shut down/end the
                 * program and the simulator program ends.
                 */
                ps.println("quit");
                System.out.println("Ending program...");
                break;

            }
            else{
                if(in.equals("")){
                    print("Please enter a command.");
                }
                else{
                    print(in+ " wasn't recognized as a command. \n");
                }
            }
        }
    }

    /*
     * Changes current Temperature in the Car. Not implemented in the legoCar.
     */
    private static void changeTemperature(CarSettings c, Scanner scanner) {

        print("Choose a value between 15 and 25 to change temperature: ");
        int tem = scanner.nextInt();

        while(tem < 15 || tem > 25){ //accepted temperatures in °C
            print("Number must be between 15 and 25 \n");
            tem = scanner.nextInt();
        }
        c.setTemperature(tem);
        print("Temperature was changed to " + tem);
    }

    /*
     * Changes the current seatBackDepth. Not implemented in the legoCar.
     */
    private static void changeSeatBackDepth(CarSettings c, Scanner scanner) {

        print("Choose a value between 0 and 10 to change seat back depth: ");
        int sbd = scanner.nextInt();

        while(sbd < 0 || sbd > 10){ //accepted angle values
            print("Number must be between 0 and 10 \n");
            sbd = scanner.nextInt();
        }
        c.setSeatBackDepth(sbd);
        print("Seat back depth was changed to " + sbd);
    }

    /*
     * Changes the current seatHeadAngle. Not implemented in the legoCar.
     */
    private static void changeSeatHeadAngle(CarSettings c, Scanner scanner) {

        print("Choose a value between -90 and 90 to change seat head angle: ");
        int sha = scanner.nextInt();

        while(sha < -90 || sha > 90){ //accepted angle values
            print("Number must be between -90 and 90 \n");
            sha = scanner.nextInt();
        }
        c.setSeatHeadAngle(sha);
        print("Seat head angle was changed to " + sha);
    }

    /*
     * Changes the current seatBackAngle. Implemented in the legoCar.
     */
    private static void changeSeatBackAngle(CarSettings c, Scanner scanner) {

        ps.println("seatBackAngle"); //Tells the legoCar what the user want to change.
        print("Choose a value between -90 and 45 to change seat back angle: ");
        int sba = scanner.nextInt();

        while(sba < -90 || sba > 45){ //accepted angle values
            print("Number must be between -90 and 45 \n");
            sba = scanner.nextInt();
        }
        c.setSeatBackAngle(sba);
        ps.println(0); //Tells the legoCar which state is needed to change the right angle.
        ps.println(2); //Tells the legoCar which motor to use
        ps.println(sba); //Tells the legoCar what angle to change to.
        print("Seat back angle was changed to " + sba);
        waitForMotors(); //Calls a method that gives the motors time to change the angles.
    }

    /*
     * Changes the current seatBackDepth. Implemented in the legoCar.
     */
    private static void changeSeatDepth(CarSettings c, Scanner scanner) {
        ps.println("seatDepth"); //Tells the legoCar what the user want to change.
        print("Choose a value between 0 and 10 to change seat depth: ");
        int sd = scanner.nextInt();

        while(sd < 0 || sd > 10){ //accepted angle values
            print("Number must be between 0 and 10 \n");
            sd = scanner.nextInt();
        }
        c.setSeatDepth(sd);
        ps.println(160); //Tells the legoCar which state is needed to change the right angle.
        ps.println(2); //Tells the legoCar which motor to use
        ps.println(sd); //Tells the legoCar what angle to change to.
        print("Seat depth was changed to " + sd);
        waitForMotors(); //Calls a method that gives the motors time to change the angles.
    }

    /*
     * Changes the current seatBackHeight. Not implemented in the legoCar.
     */
    private static void changeSeatHeight(CarSettings c, Scanner scanner) {
        print("Choose a value between 0 and 10 to change seat height");
        int sh = scanner.nextInt();

        while(sh < 0 || sh > 10){ //accepted angle values
            print("Number must be between 0 and 10 \n");
            sh = scanner.nextInt();
        }
        c.setSeatHeight(sh);
        print("Seat height was changed to " + sh);
    }

    /*
     * Changes the current WingMirrorRightY. Implemented in the legoCar.
     */
    private static void changeWingMirrorRightY(CarSettings c, Scanner scanner) {
        ps.println("wingMirrorRightY"); //Tells the legoCar what the user want to change.
        print("Choose a value between -25 and 25 to change wing mirror right y-axis: ");
        int wmry = scanner.nextInt();

        while(wmry < -25 || wmry > 25){ //accepted angle values
            print("Number must be between -25 and 25 \n");
            wmry = scanner.nextInt();
        }
        c.setWingMirrorRightY(wmry);
        ps.println(320); //Tells the legoCar which state is needed to change the right angle.
        ps.println(1); //Tells the legoCar which motor to use
        ps.println(wmry); //Tells the legoCar what angle to change to.
        print("Wing mirror right y-axis was changed to " + wmry);
        waitForMotors(); //Calls a method that gives the motors time to change the angles.
    }

    /*
     * Changes the current WingMirrorRightX. Not implemented in the legoCar.
     */
    private static void changeWingMirrorRightX(CarSettings c, Scanner scanner) {
        print("Choose a value between -25 and 25 to change wing mirror right x-axis: ");
        int wmrx = scanner.nextInt();

        while(wmrx < -25 || wmrx > 25){ //accepted angle values
            print("Number must be between -25 and 25 \n");
            wmrx = scanner.nextInt();
        }
        c.setWingMirrorRightX(wmrx);
        print("Wing mirror right x-axis was changed to " + wmrx);
    }

    /*
     * Changes the current WingMirrorLeftY. Implemented in the legoCar.
     */
    private static void changeWingMirrorLeftY(CarSettings c, Scanner scanner) {
        ps.println("wingMirrorLeftY"); //Tells the legoCar what the user want to change.
        print("Choose a value between -25 and 25 to change wing mirror left y-axis: ");
        int wmly = scanner.nextInt();

        while(wmly < -25 || wmly > 25){ //accepted angle values
            print("Number must be between -25 and 25 \n");
            wmly = scanner.nextInt();
        }
        c.setWingMirrorLeftY(wmly);
        ps.println(160); //Tells the legoCar which state is needed to change the right angle.
        ps.println(3); //Tells the legoCar which motor to use
        ps.println(wmly); //Tells the legoCar what angle to change to.
        print("Wing mirror left y-axis was changed to " + wmly);
        waitForMotors(); //Calls a method that gives the motors time to change the angles.
    }

    /*
     * Changes the current WingMirrorLeftX. Not implemented in the legoCar.
     */
    private static void changeWingMirrorLeftX(CarSettings c, Scanner scanner) {
        print("Choose a value between -25 and 25 to change wing mirror left x-axis: ");
        int wmlx = scanner.nextInt();

        while(wmlx < -25 || wmlx > 25){ //accepted angle values
            print("Number must be between -25 and 25 \n");
            wmlx = scanner.nextInt();
        }
        c.setWingMirrorLeftX(wmlx);
        print("Wing mirror left x-axis was changed to " + wmlx);
    }

    /*
     * Changes the current RadioStation. Implemented in the legoCar.
     */
    private static void changeRadioStation(CarSettings c, Scanner scanner) {
        ps.println("radioStation"); //Tells the legoCar what the user want to change.
        print("Choose a radio station: ");
        String radioStation = scanner.nextLine();
        if(radioStation.equals("")){ //In case the 'enter' you press to come here is used as input
            radioStation = scanner.nextLine();
        }
        while(radioStation.equals("")){ //In case you pressed 'enter' instead of typing in a radioStation
            print("Radio station cannot be empty \n");
            radioStation = scanner.nextLine();
        }
        c.setRadioStation(radioStation);
        ps.println(radioStation); //Tells the legoCar what radioStation to change to.
        print("Radio station has been changed to " + radioStation);
    }

    /*
     * Changes the current SteeringWheelDepth. Implemented in the legoCar.
     */
    private static void changeSteeringWheelDepth(CarSettings c, Scanner scanner) {
        ps.println("steeringWheelDepth"); //Tells the legoCar what the user want to change.
        print("Choose a value between 0 and 10 to change steering wheel depth: ");
        int swd = scanner.nextInt();

        while(swd < 0 || swd > 10){ //accepted angle values
            print("Number must be between 0 and 10 \n");
            swd = scanner.nextInt();
        }
        c.setSteeringWheelDepth(swd);
        ps.println(0); //Tells the legoCar which state is needed to change the right angle.
        ps.println(3); //Tells the legoCar which motor to use
        ps.println(swd); //Tells the legoCar what angle to change to.
        print("Steering wheel depth was changed to " + swd);
        waitForMotors(); //Calls a method that gives the motors time to change the angles.
    }

    /*
     * Changes the current SteeringWheelTilt. Implemented in the legoCar.
     */
    private static void changeSteeringWheelTilt(CarSettings c, Scanner scanner) {
        ps.println("steeringWheelTilt"); //Tells the legoCar what the user want to change.
        print("Choose a value between 0 and 90 to change steering wheel tilt: ");
        int swt = scanner.nextInt();

        while(swt < 0 || swt > 90){ //accepted angle values
            print("Number must be between 0 and 90 \n");
            swt = scanner.nextInt();
        }
        c.setSteeringWheelTilt(swt);
        ps.println(320); //Tells the legoCar which state is needed to change the right angle.
        ps.println(3); //Tells the legoCar which motor to use
        ps.println(swt); //Tells the legoCar what angle to change to.
        print("Steering wheel tilt was changed to " + swt);
        waitForMotors(); //Calls a method that gives the motors time to change the angles.
    }

    public static double alcoholMeasurement(){
        double permille = -1.0; // In case the measurement fails, the value stays -1.0 to signalize
                                // that there is a problem with the readings/sensor/...
        try {
            /*
             * run the command to start the arduinoReader.py python-script
             * using the Runtime exec method
             */
            Process p = Runtime.getRuntime().exec("python /home/pi/PiCode/pythonscripts/arduino.py");

            // read the output from the command
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            long startTime = System.currentTimeMillis();
            String s;

            /*
             * An Array where the values, read from Arduino, are saved in the meantime.
             */
            ArrayList<String> alcoholValues = new ArrayList<>();

            while((System.currentTimeMillis()-startTime)<10000){
                s = stdInput.readLine(); //read the values from Arduino
                //The readings aren't error free, so invalid readings are sorted out.
                if (s != null && !s.equals("") && ! s.equals(", ") && ! s.equals(" ") && ! s.equals(",")) {
                    alcoholValues.add(s);
                    Thread.sleep(1); //very small break to reduce the amount of readings collected.
                }
            }
            //Gets the highest + converted alcoholValue from the Array
            permille = calculatePermille(alcoholValues);
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return permille;
    }

    /*
     * Converts the values from the AlcoholSensor to an actual alcohol value and returns
     * the the highest measurement.
     */
    public static double calculatePermille(ArrayList<String> s) {
        double highest = 0.0;
        for (String value : s) {
            int alcoholValue = parseToInt(value);
            if (alcoholValue > highest) {
                highest = alcoholValue;
            }
        }
        return highest/10000;
    }

    /*
     * Takes a String (its parameter) and converts it to an integer. The result is returned.
     * If the result is invalid -1 is returned.
     */
    public static int parseToInt(String s) {
        int result = -1;
        try{
            result = Integer.parseInt(s.replaceAll("[\\D]", ""));
        }
        catch (Exception e){

        }
        if((result > 999) || result < 0){
            return -1;
        }
        return result;
    }

    /*
     * This method stops the simulator code for 2 seconds each times its called, to give motors time to
     * reach the given angles.
     */
    private static void waitForMotors() {
        try{
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
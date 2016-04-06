package c3pio;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulator {

    private JSONObject JSON = new JSONObject();
    private Controller controller;
    private CarSettings carSettings;

    public Simulator(Controller controller, CarSettings carSettings) {
        this.controller = controller;
        this.carSettings = carSettings;
        this.run();
    }

    public static void print(Object o){
        System.out.println(o);
    }

    public void run() {
        // System.out.println(carSettings);

        Scanner scanner = new Scanner(System.in);
        String help = "\nType: \n" +
                "settings - to print current settings\n" +
                "change - to change a setting \n" +
                "BT - to read from app via bluetooth \n" +
                "check - to check your alcoholconsentration \n" +
                "quit - to quit program\n \n";

        print("Welcome to your car.\n");
        while(true){
            print(help);
            String in = scanner.nextLine();
            if (in.equals("")){
                in = scanner.nextLine();
            }
            if(in.equals("settings")){
                print(carSettings);
            }
            else if(in.equals("BT") || in.equals("bt") || in.equals("Bt") || in.equals("bT")){
                JSONParser parser = new JSONParser();
                try{
                    Object obj = parser.parse(new FileReader("/home/pi/Documents/PiCode/PiCode/src/data/username.json"));
                    JSONArray array = (JSONArray)obj;
                    controller.setCarSettingsFromJSON(array.toString());

                }
                catch (FileNotFoundException e){
                    System.err.println("File not found.");
                }

                catch (Exception e){
                    System.err.println("An error has occured!");
                    System.out.println(e);
                }

            }
            else if(in.equals("check")){
                alcoholMeasurement(); // change to controller.alcoholMeasrement();
            }
            else if(in.equals("change")){
                // Method that lists all setting-numbers and enters new menu
                // that allows you to choose what to change and enter input
                print(carSettings.toString()+ "\n");
                print("Type 0 to change all settings. \nType 1-14 to change one setting at a time.");
                String change = scanner.nextLine();
                switch (change){
                    case "0":
                        changeIgnitionType(carSettings, scanner);
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
                        changeIgnitionType(carSettings, scanner);
                        break;
                    case "2":
                        changeSteeringWheelTilt(carSettings, scanner);
                        break;
                    case "3":
                        changeSteeringWheelDepth(carSettings, scanner);
                        break;
                    case "4":
                        changeRadioStation(carSettings, scanner);
                        break;
                    case "5":
                        changeWingMirrorLeftX(carSettings, scanner);
                        break;
                    case "6":
                        changeWingMirrorLeftY(carSettings, scanner);
                        break;
                    case "7":
                        changeWingMirrorRightX(carSettings, scanner);
                        break;
                    case "8":
                        changeWingMirrorRightY(carSettings, scanner);
                        break;
                    case "9":
                        changeSeatHeight(carSettings, scanner);
                        break;
                    case "10":
                        changeSeatDepth(carSettings, scanner);
                        break;
                    case "11":
                        changeSeatBackAngle(carSettings, scanner);
                        break;
                    case "12":
                        changeSeatHeadAngle(carSettings, scanner);
                        break;
                    case "13":
                        changeSeatBackDepth(carSettings, scanner);
                        break;
                    case "14":
                        changeTemperature(carSettings, scanner);
                        break;
                    default:
                        print(change+ " wasn't recognized as a command.");
                        break;
                }
            }
            else if(in.equals("quit")){
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

    private static void changeTemperature(CarSettings c, Scanner scanner) {
        print("Choose a value between 15 and 25 to change temperature: ");
        int tem = scanner.nextInt();
        while(tem < 15 || tem > 25){
            print("Number must be between 15 and 25 \n");
            tem = scanner.nextInt();
        }
        c.setTemperature(tem);
        print("Temperature was changed to " + tem);
    }

    private static void changeSeatBackDepth(CarSettings c, Scanner scanner) {
        print("Choose a value between 0 and 10 to change seat back depth: ");
        int sbd = scanner.nextInt();
        while(sbd < 0 || sbd > 10){
            print("Number must be between 0 and 10 \n");
            sbd = scanner.nextInt();
        }
        c.setSeatBackDepth(sbd);
        print("Seat back depth was changed to " + sbd);
    }

    private static void changeSeatHeadAngle(CarSettings c, Scanner scanner) {
        print("Choose a value between -90 and 90 to change seat head angle: ");
        int sha = scanner.nextInt();
        while(sha < -90 || sha > 90){
            print("Number must be between -90 and 90 \n");
            sha = scanner.nextInt();
        }
        c.setSeatHeadAngle(sha);
        print("Seat head angle was changed to " + sha);
    }

    private static void changeSeatBackAngle(CarSettings c, Scanner scanner) {
        print("Choose a value between -90 and 90 to change seat back angle: ");
        int sba = scanner.nextInt();
        while(sba < -90 || sba > 90){
            print("Number must be between -90 and 90 \n");
            sba = scanner.nextInt();
        }
        c.setSeatBackAngle(sba);
        print("Seat back angle was changed to " + sba);
    }

    private static void changeSeatDepth(CarSettings c, Scanner scanner) {
        print("Choose a value between 0 and 10 to change seat depth: ");
        int sd = scanner.nextInt();
        while(sd < 0 || sd > 10){
            print("Number must be between 0 and 10 \n");
            sd = scanner.nextInt();
        }
        c.setSeatDepth(sd);
        print("Seat depth was changed to " + sd);
    }

    private static void changeSeatHeight(CarSettings c, Scanner scanner) {
        print("Choose a value between 0 and 10 to change seat height");
        int sh = scanner.nextInt();
        while(sh < 0 || sh > 10){
            print("Number must be between 0 and 10 \n");
            sh = scanner.nextInt();
        }
        c.setSeatHeight(sh);
        print("Seat height was changed to " + sh);
    }

    private static void changeWingMirrorRightY(CarSettings c, Scanner scanner) {
        print("Choose a value between -25 and 25 to change wing mirror right y-axis: ");
        int wmry = scanner.nextInt();
        while(wmry < -25 || wmry > 25){
            print("Number must be between -25 and 25 \n");
            wmry = scanner.nextInt();
        }
        c.setWingMirrorRightY(wmry);
        print("Wing mirror right y-axis was changed to " + wmry);
    }

    private static void changeWingMirrorRightX(CarSettings c, Scanner scanner) {
        print("Choose a value between -25 and 25 to change wing mirror right x-axis: ");
        int wmrx = scanner.nextInt();
        while(wmrx < -25 || wmrx > 25){
            print("Number must be between -25 and 25 \n");
            wmrx = scanner.nextInt();
        }
        c.setWingMirrorRightX(wmrx);
        print("Wing mirror right x-axis was changed to " + wmrx);
    }

    private static void changeWingMirrorLeftY(CarSettings c, Scanner scanner) {
        print("Choose a value between -25 and 25 to change wing mirror left y-axis: ");
        int wmly = scanner.nextInt();
        while(wmly < -25 || wmly > 25){
            print("Number must be between -25 and 25 \n");
            wmly = scanner.nextInt();
        }
        c.setWingMirrorLeftY(wmly);
        print("Wing mirror left y-axis was changed to " + wmly);
    }

    private static void changeWingMirrorLeftX(CarSettings c, Scanner scanner) {
        print("Choose a value between -25 and 25 to change wing mirror left x-axis: ");
        int wmlx = scanner.nextInt();
        while(wmlx < -25 || wmlx > 25){
            print("Number must be between -25 and 25 \n");
            wmlx = scanner.nextInt();
        }
        c.setWingMirrorLeftX(wmlx);
        print("Wing mirror left x-axis was changed to " + wmlx);
    }

    private static void changeRadioStation(CarSettings c, Scanner scanner) {
        print("Choose a radio station: ");
        String radioStation = scanner.nextLine();
        if(radioStation.equals("")){
            radioStation = scanner.nextLine();
        }
        while(radioStation.equals("")){
            print("Radio station cannot be empty \n");
            radioStation = scanner.nextLine();
        }
        c.setRadioStation(radioStation);
        print("Radio station has been changed to " + radioStation);
    }

    private static void changeSteeringWheelDepth(CarSettings c, Scanner scanner) {
        print("Choose a value between 0 and 10 to change steering wheel depth: ");
        int swd = scanner.nextInt();
        while(swd < 0 || swd > 10){
            print("Number must be between 0 and 10 \n");
            swd = scanner.nextInt();
        }
        c.setSteeringWheelDepth(swd);
        print("Steering wheel depth was changed to " + swd);
    }

    private static void changeSteeringWheelTilt(CarSettings c, Scanner scanner) {
        print("Choose a value between 0 and 90 to change steering wheel tilt: ");
        int swt = scanner.nextInt();
        while(swt < 0 || swt > 90){
            print("Number must be between 0 and 90 \n");
            swt = scanner.nextInt();
        }
        c.setSteeringWheelTilt(swt);
        print("Steering wheel tilt was changed to " + swt);
    }

    private static void changeIgnitionType(CarSettings c, Scanner scanner) {
        print("To change select one of the ignition types type: \n");
        String ignitionTypes = "\noff - for OFF \n" +
                "start - for START \n" +
                "accessory - for ACCESSORY \n" +
                "run - for RUN \n";
        print(ignitionTypes);
        String ignitionTypeString = scanner.nextLine();

        while(!ignitionTypeString.equals("off") && !ignitionTypeString.equals("start")
                && !ignitionTypeString.equals("run") && !ignitionTypeString.equals("accessory")){
            print(ignitionTypeString+ " wasn't recognized as a command. \n");
            print(ignitionTypes);
            ignitionTypeString = scanner.nextLine();
        }

        convertToIgnitionType(c, ignitionTypeString);
    }

    private static void convertToIgnitionType(CarSettings c, String ignitionTypeString) {
        if(ignitionTypeString.toLowerCase().equals("off")){
            c.setIgnitionStatus(CarSettings.IgnitionStatusType.OFF);
            print("Ignition status was changed to off");
        }
        else if(ignitionTypeString.toLowerCase().equals("start")){
            c.setIgnitionStatus(CarSettings.IgnitionStatusType.START);
            print("Ignition status was changed to start");
        }
        else if(ignitionTypeString.toLowerCase().equals("accessory")){
            c.setIgnitionStatus(CarSettings.IgnitionStatusType.ACCESSORY);
            print("Ignition status was changed to accessory");
        }
        else if(ignitionTypeString.toLowerCase().equals("run")){
            c.setIgnitionStatus(CarSettings.IgnitionStatusType.RUN);
            print("Ignition status was changed to run");
        }
    }

    public static double alcoholMeasurement(){
        System.out.println("Your Blood Alcohol Concentration is : ");
        double permille = -1.0;
        try {

            // run the Unix "ps -ef" command
            // using the Runtime exec method:
            Process p = Runtime.getRuntime().exec("python /home/pi/PiCode/pythonscripts/arduinoReader.py");

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command

            long startTime = System.currentTimeMillis();
            String s = null;
            ArrayList<String> alcoholValues = new ArrayList<>();

            while(false||(System.currentTimeMillis()-startTime)<10000){
                s = stdInput.readLine();
                if (s != null && !s.equals("") && !s.equals(", ") && !s.equals(" ") && !s.equals(",")) {
                    alcoholValues.add(s);

                    Thread.sleep(1);
                }

            }
            permille = calculatePermille(alcoholValues);
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(permille);
        return permille;
    }

    private static double calculatePermille(ArrayList<String> s) {
        double highest = 0.0;
        for (String value : s) {
            int alcoholValue = parseToDouble(value);
            if (alcoholValue > highest) {
                highest = alcoholValue;
            }
        }
        return highest/10000;
    }

    private static int parseToDouble(String s) {

        int result = Integer.parseInt(s.replaceAll("[\\D]", ""));

/*

	s = s.replaceAll("[^-?0-9]+", " ");
	ArrayList<String> sList = Arrays.asList(str.trim().split(" "));
*/
        if(result > 999){
            return -1;
        }
        return result;
    }
}

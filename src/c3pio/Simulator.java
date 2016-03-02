package c3pio;

import java.util.Scanner;

public class Simulator {

    public static void print(Object o){
            System.out.println(o);
    }

    public static void main(String[] args) {
	    CarSettings c = new CarSettings();
        // System.out.println(c);

        Scanner scanner = new Scanner(System.in);
        String help = "\nType: \n" +
                "settings - to print current settings\n" +
                "change - to change a setting \n" +
                "quit - to quit program\n \n";

        print("Welcome to your car.\n");
        while(true){
            print(help);
            String in = scanner.nextLine();
            if (in.equals("")){
                in = scanner.nextLine();
            }
            if(in.equals("settings")){
                print(c);
            }
            else if(in.equals("change")){
                // Method that lists all setting-numbers and enters new menu
                // that allows you to choose what to change and enter input
                print(c.toString()+ "\n");
                print("Type 0 to change all settings. \nType 1-14 to change one setting at a time.");
                String change = scanner.nextLine();
                switch (change){
                    case "0":
                        changeIgnitionType(c, scanner);
                        changeSteeringWheelTilt(c, scanner);
                        changeSteeringWheelDepth(c, scanner);
                        changeRadioStation(c, scanner);
                        changeWingMirrorLeftX(c, scanner);
                        changeWingMirrorLeftY(c, scanner);
                        changeWingMirrorRightX(c, scanner);
                        changeWingMirrorRightY(c, scanner);
                        changeSeatHeight(c, scanner);
                        changeSeatDepth(c, scanner);
                        changeSeatBackAngle(c, scanner);
                        changeSeatHeadAngle(c, scanner);
                        changeSeatBackDepth(c, scanner);
                        changeTemperature(c, scanner);
                        break;
                    case "1":
                        changeIgnitionType(c, scanner);
                        break;
                    case "2":
                        changeSteeringWheelTilt(c, scanner);
                        break;
                    case "3":
                        changeSteeringWheelDepth(c, scanner);
                        break;
                    case "4":
                        changeRadioStation(c, scanner);
                        break;
                    case "5":
                        changeWingMirrorLeftX(c, scanner);
                        break;
                    case "6":
                        changeWingMirrorLeftY(c, scanner);
                        break;
                    case "7":
                        changeWingMirrorRightX(c, scanner);
                        break;
                    case "8":
                        changeWingMirrorRightY(c, scanner);
                        break;
                    case "9":
                        changeSeatHeight(c, scanner);
                        break;
                    case "10":
                        changeSeatDepth(c, scanner);
                        break;
                    case "11":
                        changeSeatBackAngle(c, scanner);
                        break;
                    case "12":
                        changeSeatHeadAngle(c, scanner);
                        break;
                    case "13":
                        changeSeatBackDepth(c, scanner);
                        break;
                    case "14":
                        changeTemperature(c, scanner);
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
}

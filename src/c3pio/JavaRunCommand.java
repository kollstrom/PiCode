package c3pio;
/**
 * Write a description of class JavaRunCommand here.
 * http://alvinalexander.com/java/edu/pj/pj010016
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

public class JavaRunCommand {
    public static void main(String args[]) {

        try {

            // run the Unix "ps -ef" command
            // using the Runtime exec method:
            Process p = Runtime.getRuntime().exec("python ../PiCode/pythonscripts/printsomething.py");

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");

            long startTime = System.currentTimeMillis();
            String s = null;

            while(false||(System.currentTimeMillis()-startTime)<10000){
                    if ((s = stdInput.readLine()) != null) {
                        System.out.println(s);
                    }
            }


            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

            System.exit(0);
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
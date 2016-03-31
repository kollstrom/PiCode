package controllerDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ControllerDemo{
	public static void main(String[] args) throws UnknownHostException, IOException {
		try{
			String out, in;
			Socket clientSocket = new Socket("10.0.1.1", 4321);
			Scanner scanner = new Scanner(System.in);
			BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintStream ps = new PrintStream(clientSocket.getOutputStream());
			
			while (true){
				System.out.println("Input that sends to EV3: ");
				out = scanner.nextLine().toLowerCase();
				
				System.out.println("Sending...");
				ps.print(out + "\n");
				
				if (out.equals("seat")){
					System.out.println("W8ing 4 answer...");
					in = input.readLine();
					System.out.println(in);
					out = scanner.nextLine();
					ps.print(out + "\n");
					in = input.readLine();
					System.out.println(in);
					TimeUnit.SECONDS.sleep(2);
				}
				else if (out.equals("quit")){
					System.out.println("W8ing 4 answer...");
					in = input.readLine();
					System.out.println(in);
					TimeUnit.MILLISECONDS.sleep(1500);
					clientSocket.close();
					System.out.println("Ending program...");
				}
				else{
					System.out.println("W8ing 4 answer...");
					in = input.readLine();
					System.out.println(in);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}


/*
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ControllerDemo {
	
	public ControllerDemo() throws IOException{
		Scanner scanner = new Scanner(System.in);
		try (
			ServerSocket serverSocket = new ServerSocket(4321);
			Socket clientSocket = serverSocket.accept();
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			) {
			while (true){
				System.out.print("Two commands can be used (seat/quit): ");
				String toSend = scanner.nextLine();
				System.out.println("");
				while (!toSend.equals("seat") || !toSend.equals("quit")){
					System.out.print("Oops, try again: ");
					toSend = scanner.nextLine();
					System.out.println("");
				}
				out.print(toSend);
				System.out.println(toSend + " was send to the EV3.");
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		ControllerDemo demo = new ControllerDemo();
	}		
}

*/

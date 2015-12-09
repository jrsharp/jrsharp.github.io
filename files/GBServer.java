// GBServer.java
// Gameboy Daemon
// by Montie Schmiege and Jon Sharp
// written for CPTR 328
// December 2000
// (Original shell of code provided by Dr. Rick Halterman)

import java.net.Socket;
import java.net.ServerSocket;
import java.io.*;
import java.util.StringTokenizer;

public class GBServer  {
    public static void main(String[] args) {
        try {
            //  Make the connection to the server
            ServerSocket listener = new ServerSocket(2000);
            System.out.println("Server started");
            String response;
			char[] gbinput = new char[5];
			char[] procinput = new char[80];
			char[] procinput2 = new char[80];
            while ( true ) {
                //  Wait for a connection
                Socket client = listener.accept();
				if (client != null)
					System.out.println("Client connected");
                //  Set up the basic I/O streams
				PrintStream psout = new PrintStream(client.getOutputStream());
				System.setOut(psout);
				Runtime myRuntime = Runtime.getRuntime();
				Process proc = myRuntime.exec("uptime");
				InputStream procin = proc.getInputStream();
				BufferedReader buffprocin = new BufferedReader( new InputStreamReader( procin ) );
				int j = buffprocin.read(procinput,0,80);
				for ( int index = 0; procinput[index] != '\n' ;index++ ) {
					psout.print(procinput[index]);
				}
				Runtime myRuntime2 = Runtime.getRuntime();
				Process proc2 = myRuntime2.exec("cputemp");
				InputStream procin2 = proc2.getInputStream();
				BufferedReader buffprocin2 = new BufferedReader( new InputStreamReader( procin2 ) );
				int k = buffprocin2.read(procinput2,0,80);
				for ( int index = 0; procinput2[index] != '\n' ;index++ ) {
					psout.print(procinput2[index]);
				}
			}
        } catch ( IOException e) {
            System.out.println("*** I/O error (main)");
            System.out.println(e.getMessage());
        } catch ( Exception e) {
            System.out.println("*** Some *other* error (main)");
            System.out.println(e.getMessage());
        }
    }
}


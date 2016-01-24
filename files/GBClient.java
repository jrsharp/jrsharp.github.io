// GBClient.java
// Gameboy client
// written for execution on TINI
// by Montie Schmiege and Jon Sharp
// written for CPTR 328
// December 2000
// portions of code taken from Dallas Semiconductor example source:
// CommTester.java

/*
 * Copyright (C) 1996, 97, 98 Dallas Semiconductor Corporation.
 * All rights Reserved. Printed in U.S.A.
 * This software is protected by copyright laws of
 * the United States and of foreign countries.
 * This material may also be protected by patent laws of the United States
 * and of foreign countries.
 * This software is furnished under a license agreement and/or a
 * nondisclosure agreement and may only be used or copied in accordance
 * with the terms of those agreements.
 * The mere transfer of this software does not imply any licenses
 * of trade secrets, proprietary technology, copyrights, patents,
 * trademarks, maskwork rights, or any other form of intellectual
 * property whatsoever. Dallas Semiconductor retains all ownership rights.
 */

package GBClient;

import javax.comm.*;
import java.io.*;
import java.net.*;
import com.dalsemi.tininet.*;

public class GBClient
{
   public static void main(String[] args)
   {
      GBClient GBC = new GBClient();
      GBC.run();
   }

   public void run()
   {
      try
      {
         CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier("serial0");
         SerialPort sp = (SerialPort)portId.open("testApp", 0);

         sp.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

         sp.enableReceiveThreshold(1024);
         sp.enableReceiveTimeout(1000);

		// Set output to GB
		OutputStream out = sp.getOutputStream();

		// Open a socket connection
		Socket client = new Socket("216.229.233.233", 2000);
		InputStream clientin = client.getInputStream();

		int num = 0;
		int clientnum = 0;

		// Array to be used for data read.
		byte[] clientdata = new byte[80];

		while (true)
		{
			clientnum = clientin.read(clientdata,0,5);
			if ( clientnum > 0 )
			{
				for ( int j = 0 ; j < clientnum; j++ ) {
					System.out.print((char)clientdata[j]);
					out.write(clientdata[j]);
				}
			}
		}
	}
	catch(Exception e)
	{
		System.out.println("GOT AN EXCEPTION");
		System.out.println(e.toString());

		com.dalsemi.system.Debug.debugDump("Exception");
		com.dalsemi.system.Debug.debugDump(e.toString());
	}
	}
}

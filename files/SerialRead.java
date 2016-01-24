
package SerialRead;

import javax.comm.*;
import java.io.*;
import java.net.*;
import com.dalsemi.tininet.*;

public class SerialRead
{
   public static void main(String[] args)
   {
   try
      {
         CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier("serial0");
         SerialPort sp = (SerialPort)portId.open("testApp", 0);

         sp.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

         sp.enableReceiveThreshold(1024);
         sp.enableReceiveTimeout(1000);

		// Set output to GB
		OutputStream gbout = sp.getOutputStream();
		InputStream gbin = sp.getInputStream();

		int gbnum = 0;

		// Array to be used for data read.
		byte[] gbdata = new byte[80];

		while (true)
		{
			gbnum = gbin.read(gbdata,0,5);
			if ( gbnum > 0 )
			{
				for ( int j = 0 ; j < gbnum; j++ ) {
					System.out.print((char)gbdata[j]);
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

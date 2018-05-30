import java.io.*; 
import java.net.*; 
import java.io.IOException;
import java.net.UnknownHostException;
import java.net.SocketTimeoutException;



public class UDPClientex {
    public static void main(String args[]) throws Exception, IOException 
    { 
    	final int TTL = 3000;
      // Create input stream
      BufferedReader inFromUser = 
        new BufferedReader(new InputStreamReader(System.in)); 

      // Create client socket
      DatagramSocket clientSocket = new DatagramSocket(); 
  
      // Translate hostname to IP address using DNS
      // cal substituir hostname pel nom del host del vostre company, ex: d602.labdeim.net
      //InetAddress IPAddress = InetAddress.getByName("hostname");
      InetAddress IPAddress = InetAddress.getByName("d623.labdeim.net");
     
      byte[] sendData = new byte[1024]; 
      byte[] receiveData = new byte[1024]; 
  
      String sentence = inFromUser.readLine(); 
      sendData = sentence.getBytes();
      
      // Create datagram with data-to-send, length, IP addr, port
      DatagramPacket sendPacket = 
          new DatagramPacket(sendData, sendData.length, IPAddress, 9876); 
   
       // Send datagram to server
  try { 
	  
      clientSocket.send(sendPacket); 
      } catch (IOException e){
  	   e.printStackTrace();
  	   System.out.println("Error al fer ....... ");
  	   System.exit(0);
  	  }  
  
  
       DatagramPacket receivePacket = 
          new DatagramPacket(receiveData, receiveData.length); 
      
       clientSocket.setSoTimeout(TTL);
       

	  
	   try {
       // Read datagram from server
		   clientSocket.receive(receivePacket); 
			}  
			catch(SocketTimeoutException timeout) 
				{
				timeout.printStackTrace();
				System.out.println("BOOOM!");
				}
    		
   
   
   
       String modifiedSentence = 
           new String(receivePacket.getData()); 
   
       
       
       
       
       
       System.out.println("FROM SERVER:" + modifiedSentence); 
  
       
       
       
       
       
     
       
       clientSocket.close(); 
       
    
       
       
       

    	   

       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       } 
}

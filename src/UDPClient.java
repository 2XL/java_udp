import java.io.*; 
import java.net.*; 
  
class UDPClient { 
    public static void main(String args[]) throws Exception 
    { 
  
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
      clientSocket.send(sendPacket); 
   
       DatagramPacket receivePacket = 
          new DatagramPacket(receiveData, receiveData.length); 
   
       // Read datagram from server
       clientSocket.receive(receivePacket); 
   
       String modifiedSentence = 
           new String(receivePacket.getData()); 
   
       System.out.println("FROM SERVER:" + modifiedSentence); 
       clientSocket.close(); 
       } 
 } 
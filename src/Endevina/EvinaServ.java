package Endevina;


import java.io.*; 
import java.net.*;


public class EvinaServ {
	 
	  public static void main(String args[]) throws Exception 
	    { 
	      // Create datagram socket at port 9876
		  DatagramSocket serverSocket = new DatagramSocket(9876); 
	  
	      byte[] receiveData = new byte[1024]; 
	      byte[] sendData  = new byte[1024]; 
	  
	      while(true) 
	        { 
	  
	    	  // Create space for received datagram
	    	  DatagramPacket receivePacket = 
	             new DatagramPacket(receiveData, receiveData.length);
	    	  
	    	  // Receive datagram
	          serverSocket.receive(receivePacket);
	          String sentence = new String(receivePacket.getData()); 
	  
	          // Get IP addr port #, of sender
	          InetAddress IPAddress = receivePacket.getAddress(); 
	  
	          int port = receivePacket.getPort(); 
	  
	                      String capitalizedSentence = sentence.toUpperCase(); 

	   
	    
	        
	          sendData = capitalizedSentence.getBytes(); 
	          
	          int i=0;
	          // Create datagram to send to client
	          for(i=0; i<sendData.length;i++)
	        	 if(sendData[i]=='\0')
	        		 break;
	          
	          String d = new String(sendData, 0, i);
//		d.trim() --> LOL
	          DatagramPacket sendPacket = 
	             new DatagramPacket(d.getBytes(), d.length(), IPAddress, port);
	  
	          // Write out datagram to socket
	          serverSocket.send(sendPacket); 
	        } 
	    } 
	}  
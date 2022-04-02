import java.net.*;
import java.io.*;
import java.util.Scanner;

class Ports_Scanning_v1 {

    public static void main(String[] args) throws Exception {
     // Taking From The User The ( Hostname, Port )
     char fp = 0;
     while (true){
     
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter The Host That You Want To Check - [ To Exit Type (EXIT) ] : ");
        String Hostname = sc.nextLine();
        
        // To Exit if The USER Wants To Exit The Program >>
        if (Hostname.equals("Exit") || Hostname.equals("exit") || Hostname.equals("EXIT")){
        	System.exit(0);
        }
        System.out.print("Please Enter The Port That You Want To Check : ");
        int Port = sc.nextInt();
        System.out.println("Your Host is : ["+Hostname+"] And Your Port is : ["+Port+"]");
        Socket S = null;
							
        try {
        	// Find The IP For The Hostname given
            InetAddress ipaddress;
            ipaddress = InetAddress.getByName(Hostname);

            try {
                // Check for Port
                S = new Socket(Hostname, Port);
                System.out.println("The Server is Running on Port " + Port + " ^^");
                S.close();
                System.out.println("Do You Want To Print The Source Code For The Page ? Y / N ");
                fp = sc.next().charAt(0);

            } catch (IOException e) {
                System.out.println("Not Working!!, on Port > " + Port + ":(");
                
            }
         if (fp == 'Y' || fp == 'y'){
            try {
                // Start Buffer
                URL userInput = new URL("http://" + Hostname);
                BufferedReader buffer = new BufferedReader(
                        new InputStreamReader(
                                userInput.openStream()));
                
                System.out.println("The Source Code For The Host : ");
                String inputLine;
                while ((inputLine = buffer.readLine()) != null) {
                    System.out.println(inputLine);
                }
                buffer.close();
            } catch (Exception e) {
				System.out.println(e.getMessage());
            }
           }
           
        } catch (UnknownHostException e) {
            System.out.println("Couldn't not Find The Host : " +Hostname);
        }
  // Check If The Socket is Close or Not 
       if (S!= null) {

            try {
                S.close();
            } catch (IOException e) {
                System.out.println("Couldn't Close Socket!");
            }
        }
    }
}
}
package cwiczenie2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;

        System.out.println("Type a message: ");
        boolean war = true;
        int id =0;

        String patternStr1 = "LOGIN ([A-Za-z]+);([A-Za-z]+)";
        Pattern pattern1 = Pattern.compile(patternStr1);

        while (war&&(userInput = stdIn.readLine()) != null ) {


        try {
            echoSocket = new Socket("localhost", 3000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }

        out.println(userInput);
        Matcher matcher1 = pattern1.matcher(userInput);

        if(matcher1.matches()){
            id= Integer.parseInt(in.readLine());
            System.out.println(id);
        }
        else{
            System.out.println("echo: " + in.readLine());
        }

            if(userInput.equals("LOGOUT "+String.valueOf(id))){
                war=false;
            }
            if(war){
                System.out.println("Type a message: ");
            }
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}


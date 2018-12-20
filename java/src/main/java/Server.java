

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(3000);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 3000");
            System.exit(-1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 3000");
            System.exit(-1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            if(inputLine.equals("LOGIN login;password")){
                out.println("po co ci?");
            }
            if(inputLine.equals("LOGOUT ID")){

            }
            if(inputLine.equals("LS ID")){

            }
            if(inputLine.equals("GET ID plik")){

            }

        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();

    }
}
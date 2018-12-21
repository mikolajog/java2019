package cwiczenie2;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
    public static void main(String[] args) throws IOException {
        boolean warunek = true;
        int id = 1000000000;

        ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(3000);
            } catch (IOException e) {
                System.out.println("Could not listen on port: 3000");
                System.exit(-1);
            }

        while (warunek) {
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

            String patternStr1 = "LOGIN ([A-Za-z]+);([A-Za-z]+)";
            String patternStr2 = "LOGOUT "+String.valueOf(id-1);
            String patternStr3 = "LS "+String.valueOf(id-1);
            String patternStr4 = "GET "+String.valueOf(id-1)+" ([A-Za-z]+[0-9]+\\.[a-z]+)";
            Pattern pattern1 = Pattern.compile(patternStr1);
            Pattern pattern2 = Pattern.compile(patternStr2);
            Pattern pattern3 = Pattern.compile(patternStr3);
            Pattern pattern4 = Pattern.compile(patternStr4);

            if ((inputLine = in.readLine()) != null) {

                Matcher matcher1 = pattern1.matcher(inputLine);
                Matcher matcher2 = pattern2.matcher(inputLine);
                Matcher matcher3 = pattern3.matcher(inputLine);
                Matcher matcher4 = pattern4.matcher(inputLine);

                boolean wszedl = false;

                if (matcher1.matches()) {
                    File file = new File("/home/mikolaj/Desktop/passwords.txt");
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String st;
                    while ((st = br.readLine()) != null) {
                        if (matcher1.group(1).equals("szymon") && matcher1.group(2).equals(st)) {
                            out.println(id);
                            id++;
                            wszedl = true;
                            break;

                        }
                    }
                }

                if (matcher2.matches()) {
                    out.println(true);
                    warunek = false;
                    wszedl = true;

                }
                if (matcher3.matches()) {
                    out.println("plik1;plik2;plik3");
                    wszedl = true;

                }
                if (matcher4.matches()) {
                    if(matcher4.group(1).equals("plik1.txt")){
                        Scanner odczyt = new Scanner(new File("plik1.txt"));
                        out.println(odczyt.nextLine());
                        wszedl = true;
                    }
                    if(matcher4.group(1).equals("plik2.txt")){
                        Scanner odczyt = new Scanner(new File("plik3.txt"));
                        out.println(odczyt.nextLine());
                        wszedl = true;
                    }
                    if(matcher4.group(1).equals("plik3.txt")){
                        Scanner odczyt = new Scanner(new File("plik3.txt"));
                        out.println(odczyt.nextLine());
                        wszedl = true;
                    }


                }

                if(!wszedl){
                    out.println(false);
                    warunek=false;
                }


            }
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }

}
package database1;

import java.sql.*;
import java.util.Scanner;

public class DB {

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public void connect(int _number){
        int number=_number;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/nazwa", "nazwa", "haslo");


        } catch (SQLException ex) {
            number++;
            if(number<=3){
                System.out.println("Proba"+String.valueOf(number));
                connect(number);
            }
        }catch(Exception e){e.printStackTrace();}
    }

    public void listAll(){
        try {
            connect(0);
            stmt = conn.createStatement();

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            rs = stmt.executeQuery("SELECT * FROM books");

            while(rs.next()){
                System.out.println(rs.getString(1) + " " +  rs.getString(2) + " " +  rs.getString(3) + " " + rs.getString(4));
            }
        }catch (SQLException ex){

        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
    }

    public void listGivenAttributeAndValue(String atribute, String authorName){

        try {
            connect(0);
            stmt = conn.createStatement();

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            rs = stmt.executeQuery("SELECT * FROM books"+" where books."+atribute+"='"+authorName+"'");

            while(rs.next()){
                System.out.println(rs.getString(1) + " " +  rs.getString(2) + " " +  rs.getString(3) + " " + rs.getString(4));
            }
        }catch (SQLException ex){
            // handle any errors

        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
    }

    public void addBook(String isbn, String title, String author, String year){

        try {
            connect(0);
            stmt = conn.createStatement();

            stmt.executeUpdate(
                    "INSERT INTO books (isbn, title, author, year) "
                            + "values ('"+isbn+"','"+title+"','"+author+"','"+year+"')");


        }catch (SQLException ex){
            // handle any errors

        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
    }

    public static void main(String[] args){
        DB d1 = new DB();
        Scanner userInput = new Scanner(System.in);
        String variable;
        String isbn; String title; String author; String year;
        boolean stan=true;

        while(stan){
            System.out.println("Podaj\n1 - jeśli chcesz wczytac po autorze\n2 - jeśli chcesz wczytać po isbn\n3- dodaj ksiazke\n4-zakończ program");
            variable = userInput.next();
            switch(variable){
                case "1":
                    System.out.println("Podaj imie i nazwisko autora:");
                    variable = userInput.next();
                    d1.listGivenAttributeAndValue("author", variable);
                    break;
                case "2":
                    System.out.println("Podaj isbn:");
                    variable = userInput.next();
                    d1.listGivenAttributeAndValue("isbn", variable);
                    break;
                case "3":
                    System.out.println("Podaj isbn:");
                    isbn = userInput.next();
                    System.out.println("Podaj title:");
                    title = userInput.next();
                    System.out.println("Podaj author:");
                    author = userInput.next();
                    System.out.println("Podaj year:");
                    year = userInput.next();
                    d1.addBook(isbn, title, author, year);
                    break;
                case "4":
                    stan = false;
                    break;
                default:
                    System.out.println("Nie podano prawidlowych danych. Try again");

            }
        }
        userInput.close();
    }
}


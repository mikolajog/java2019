package pracownikDataBase;

import java.sql.*;


public class Kadry {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public void connect(){

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/nazwa", "nazwa", "haslo");

        } catch (SQLException ex) {

        }catch(Exception e){e.printStackTrace();}
    }

    void dodajPracownikaDoBazy(Pracownik p){

        try {
            connect();
            stmt = conn.createStatement();

            stmt.executeUpdate(
                    "INSERT INTO employees(pesel, pensjabrutto, pensjanetto) VALUES('"+p.getPesel()+"','"+p.getWynagrodzenieBrutto()+"','"+p.wynagrodzenieNetto()+"')");


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

    void usunPracownikaZBazy(String pesel){
    try {
            connect();
            stmt = conn.createStatement();

            stmt.executeUpdate(
                    "DELETE FROM employees where pesel='"+pesel+"'");


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

    void zmienBruttoWBazie(Pracownik p){
    try {
            connect();
            stmt = conn.createStatement();

            stmt.executeUpdate(
                    "UPDATE employees SET pensjaBrutto='"+p.getWynagrodzenieBrutto()+"', pensjanetto='"+p.wynagrodzenieNetto()+"' where pesel='"+p.getPesel()+"'");


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

    public void listAll(){
        try {
            connect();
            stmt = conn.createStatement();

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            rs = stmt.executeQuery("SELECT * FROM employees");

            while(rs.next()){
                System.out.println(rs.getString(1) + " " +  rs.getString(2) + " " +  rs.getString(3));
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

    public static void main(String[] args){
        Kadry k1 = new Kadry();
        Pracownik p1 = new Student("12345678911", 2000.00);
        Pracownik p2 = new PracownikEtatowy("12345678912", 2000.00);
        k1.dodajPracownikaDoBazy(p1);
        k1.dodajPracownikaDoBazy(p2);

        k1.listAll();
        k1.usunPracownikaZBazy(p1.getPesel());

        p2.setWynagrodzenieBrutto(5000.00);
        k1.zmienBruttoWBazie(p2);
        k1.listAll();
    }

}

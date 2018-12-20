package osoby;

import javafx.beans.property.SimpleStringProperty;

public class Osoba {
    private SimpleStringProperty fullName;
    private SimpleStringProperty telephone;
    private SimpleStringProperty pesel;

    public Osoba(String fullName_, String telephone_, String pesel_){
        this.fullName=new SimpleStringProperty(fullName_);
        this.telephone=new SimpleStringProperty(telephone_);
        this.pesel=new SimpleStringProperty(pesel_);
    }

    public String getFullname() {
        return fullName.get();
    }

    public void setFullName(String fullName) {
        this.fullName = new SimpleStringProperty(fullName);
    }

    public void setTelephone(String telephone) {
        this.telephone = new SimpleStringProperty(telephone);
    }

    public void setPesel(String pesel) {
        this.pesel = new SimpleStringProperty(pesel);
    }

    public String getPesel() {
        return pesel.get();
    }

    public String getTelephone() {
        return telephone.get();
    }
}

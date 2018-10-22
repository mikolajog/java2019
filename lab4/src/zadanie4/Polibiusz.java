package zadanie4;

import java.util.Map;
import java.util.TreeMap;

public class Polibiusz implements Algorithm {

    Map<String, String> klucze = new TreeMap<>();

    Polibiusz(){
        klucze.put("11", "a");
        klucze.put("12", "b");
        klucze.put("13", "c");
        klucze.put("14", "d");
        klucze.put("15", "e");

        klucze.put("21", "f");
        klucze.put("22", "g");
        klucze.put("23", "h");
        klucze.put("24", "i");
        klucze.put("25", "k");

        klucze.put("31", "l");
        klucze.put("32", "m");
        klucze.put("33", "n");
        klucze.put("34", "o");
        klucze.put("35", "p");

        klucze.put("41", "q");
        klucze.put("42", "r");
        klucze.put("43", "s");
        klucze.put("44", "t");
        klucze.put("45", "u");

        klucze.put("51", "v");
        klucze.put("52", "w");
        klucze.put("53", "x");
        klucze.put("54", "y");
        klucze.put("55", "z");

    }


    @Override
    public String crypt(String word){
        String ret="";
        int k;
        for(int i=0; i<word.length();i++){
            k=0;
            for(Map.Entry<String, String> x: klucze.entrySet()){
                if(word.substring(i, i+1).toLowerCase().equals(x.getValue())){
                    ret+=x.getKey();
                    k=1;
                }
            }
            if(word.substring(i, i+1).toLowerCase().equals("j")){
                ret+="24";
                k=1;
            }

            if(k!=1){
                ret+= word.substring(i, i+1);
            }
        }

        return ret;
    }

    @Override
    public String decrypt(String word){
        String ret="";
        int k;
        for(int i=0; i<word.length(); i=i+2){
            k=0;
            if(i+1<word.length()) {
                for (Map.Entry<String, String> x : klucze.entrySet()) {
                    if (word.substring(i, i + 2).toLowerCase().equals(x.getKey())) {
                        ret += x.getValue();
                        k = 1;
                    }
                }
            }
            if(k!=1){
                ret+= word.substring(i, i+1);
                i=i-1;
            }
        }
        return ret;
    }
}

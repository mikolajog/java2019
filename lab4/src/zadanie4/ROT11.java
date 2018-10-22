package zadanie4;

public class ROT11 implements Algorithm {

    static int translation = 11;

    @Override
    public String crypt(String word){
        char c;
        int asci;
        String ret="";
        word = word.toLowerCase();
        for(int i=0; i<word.length(); i++){
            c=word.charAt(i);
            asci= (int)c;

            if(asci<97 || asci>122){
                ret+=c;
                continue;
            }

            if(asci+translation>122){
                asci-= 26;
            }

            asci+= translation;

            c = (char)asci;
            ret+=c;
        }

        return ret;

    }

    @Override
    public String decrypt(String word){
        char c;
        int asci;
        String ret="";
        word = word.toLowerCase();
        for(int i=0; i<word.length(); i++){
            c=word.charAt(i);
            asci= (int)c;

            if(asci<97 || asci>122){
                ret+=c;
                continue;
            }

            if(asci-translation<97){
                asci+= 26;
            }

            asci-= translation;

            c = (char)asci;
            ret+=c;
        }
        return ret;
    }

}

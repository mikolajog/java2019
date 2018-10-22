package zadanie5;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMessage {

        private String from; //required (must be e-mail)
        private LinkedList<String> to; //required at least one (must be e-mail)
        private String subject; //optional
        private String content; //optional
        private String mimeType;  // optional
        private LinkedList<String> cc; //optional
        private LinkedList<String> bcc; // optional

    private EmailMessage(Builder builder) {
        if(builder==null) {
            return;
        }

        from = builder.from;
        to = builder.to;
        subject = builder.subject;
        content = builder.content;
        mimeType = builder.mimeType;
        cc = builder.cc;
        bcc = builder.bcc;

    }

    public String getContent() {
        return content;
    }

    public String getFrom() {
        return from;
    }

    public String getMimeType() {
        return mimeType;
    }

    public String getSubject() {
        return subject;
    }

    public LinkedList<String> getBcc() {
        return bcc;
    }

    public LinkedList<String> getCc() {
        return cc;
    }

    public LinkedList<String> getTo() {
        return to;
    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }


    public static class Builder {
        private String from; //required (must be e-mail)
        private LinkedList<String> to = new LinkedList<>(); //required at least one (must be e-mail)
        private String subject; //optional
        private String content; //optional
        private String mimeType;  // optional
        private LinkedList<String> cc = new LinkedList<>();  //optional
        private LinkedList<String> bcc = new LinkedList<>();  // optional

        public boolean checkIfEmail(String email){
            Pattern compiledPattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
            Matcher matcher = compiledPattern.matcher(email);

            if(matcher.matches()){
                return true;
            }
            else{
                return false;
            }
        }

        public EmailMessage build () {
            return new EmailMessage(this);
        }

        public Builder addFrom(String from_){
            if(checkIfEmail(from_)){
                from = from_;
                return this;
            }
            else{
                System.out.println("Niepoprawny adres email");
                from = null;
                return this;
            }
        }

        public Builder addTo(String to_){
            if(checkIfEmail(to_)){
                to.add(to_);
                return this;
            }
            else{
                System.out.println("Niepoprawny adres email");
                return this;
            }
        }

        public Builder addSubject(String subject_){
            subject = subject_;
            return this;
        }

        public Builder addContent(String content_){
            content = content_;
            return this;
        }

        public Builder addMimeType(String mimeType_){
            mimeType = mimeType_;
            return this;
        }

        public Builder addCC(String cc_){
            if(checkIfEmail(cc_)){
                cc.add(cc_);
                return this;
            }
            else{
                System.out.println("Niepoprawny adres email ");
                return this;
            }
        }

        public Builder addBCC(String BCC_){
            if(checkIfEmail(BCC_)){
                bcc.add(BCC_);
                return this;
            }
            else{
                System.out.println("Niepoprawny adres emaila. ");
                return this;
            }
        }
    }
}



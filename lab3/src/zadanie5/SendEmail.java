package zadanie5;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
    public static void main(String[] args) {

        EmailMessage wiadomosc = EmailMessage.builder()
                .addFrom("ogarek@student.agh.edu.pl")
                .addTo("ogarek@student.agh.edu.pl")
                .addSubject("Mail testowy")
                .addContent("Brak tresci")
                .build();


        final String username = "*******";//change accordingly
        final String password = "*******";//change accordingly



        // Assuming you are sending email through relay.jangosmtp.net
        String host = "poczta.agh.edu.pl";

        Properties props = new Properties();

        props.put("mail.smtp.host", host);
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(wiadomosc.getFrom()));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(wiadomosc.getTo().getFirst()));

            message.setSubject(wiadomosc.getSubject());

            message.setText(wiadomosc.getContent());

            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
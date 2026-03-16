//API que usa Jakarta Mail que se conecta com o servidor de email do Google atraves do SMTP (Simple Mail Transfer Protocol) que é um protocolo padrao da internet para enviar emails
//Passo a passo para instalar a API: 1= abrir o site https://mvnrepository.com/artifact/com.sun.mail/jakarta.mail/2.0.1 , clicar no jar, baixar o arquivo jakarta.mail-2.0.1.jar
//2- Jakarta Activation: Abrir https://mvnrepository.com/artifact/com.sun.activation/jakarta.activation/2.0.1 , clicar no jar, baixar  https://mvnrepository.com/artifact/com.sun.activation/jakarta.activation/2.0.1
//3-Clicar no botao direito no projeto, propiedades, biblioteca, clicar em adicionarJarPasta, seliconar os arquivlos .jar
//Esse passo a passo faz com que o Java reconheça 
package lojadosprograma;

import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class EmailService {

    public static void enviarEmail(String destinatario, String nome) {

        //Aqui define quem vai enviar o email
        final String remetente = "lojadosprograma@gmail.com";
        final String senha = "dfdj pteb hakg hklt";

        //Aqui configura como o java vai se conectar ao server de email
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

//     Aqui o java cira um sessao de conexao com o server de email, nessa sessao contem configuração SMTP (Simple Mail Transfer Protocol), contem o login do rementente e senha do rementente (quem envia o email)
        Session session = Session.getInstance(props,
                new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente, senha);
            }
        });

        try {
            //Define quem envia
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(remetente));
            
            //Define quem recebe
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(destinatario)
            );
            
            //Assunto do email
            message.setSubject("Confirmação de Cadastro");
            
            //Conteudo da mensagem do email
            message.setText(
                    "Olá " + nome + ",\n\n"
                    + "você foi cadastrado na Loja dos Programas.\n"
                    + "Obrigado por utilizar o sistema!"
            );
              
            
            //Aqui envia o email pro recebedor
            Transport.send(message);

            System.out.println("Email enviado com sucesso!");

        } catch (MessagingException e) {
            System.out.println("Erro ao enviar email: " + e.getMessage());
        }
    }
}

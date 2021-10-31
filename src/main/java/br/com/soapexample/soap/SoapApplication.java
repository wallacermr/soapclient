package br.com.soapexample.soap;

import br.com.soapexample.soap.client.SOAPClient;
import br.com.soapexample.soap.wsdl.Add;
import br.com.soapexample.soap.wsdl.AddResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(SOAPClient soapClient) {
        return args -> {
            Add addPayload = new Add();
            addPayload.setIntA(2);
            addPayload.setIntB(3);

            //soapAction uri is defined in wsdl file contract at <action> tag
            AddResponse response = (AddResponse) soapClient.callSoapService(addPayload, "http://tempuri.org/Add");
            System.out.println("Got Response As below ========= : ");
            System.out.println("Name : " + response.getAddResult());
        };
    }

}

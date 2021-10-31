package br.com.soapexample.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SOAPClient extends WebServiceGatewaySupport {

    public Object callSoapService(Object requestPayload, String soapAction) {
        return getWebServiceTemplate().marshalSendAndReceive(requestPayload, new SoapActionCallback(soapAction));
    }
}

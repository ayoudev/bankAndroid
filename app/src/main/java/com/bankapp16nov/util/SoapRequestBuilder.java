package com.bankapp16nov.utils;

public class SoapRequestBuilder {

    public static String createCompteRequest(double solde, String type) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://ws.soap.com/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <ws:createCompte>\n" +
                "         <solde>" + solde + "</solde>\n" +
                "         <type>" + type + "</type>\n" +
                "      </ws:createCompte>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
    }
}

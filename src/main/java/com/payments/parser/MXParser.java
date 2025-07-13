package com.payments.parser;


import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class MXParser implements MessageParser {
    @Override
    public GenericMessage parse(File file) throws Exception {
        GenericMessage message = new GenericMessage();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        doc.getDocumentElement().normalize();

        message.put("Document", doc.getDocumentElement()); // Entire DOM for XPath-style access
        return message;
    }
}

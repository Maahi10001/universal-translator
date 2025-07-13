package com.payments.parser;

import java.io.*;
import java.util.regex.*;

public class MTParser implements MessageParser {
    @Override
    public GenericMessage parse(File file) throws Exception {
        GenericMessage message = new GenericMessage();
        String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));

        Pattern pattern = Pattern.compile(":(\\d{2}[A-Z]?):(.*?)\\r?\\n", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            message.put(":" + matcher.group(1) + ":", matcher.group(2).trim());
        }

        return message;
    }
}

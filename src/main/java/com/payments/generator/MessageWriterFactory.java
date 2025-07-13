package com.payments.generator;

public class MessageWriterFactory {
    public static MessageWriter getWriter(String messageContent) {
        System.out.println("At Parser: "+messageContent);
        if (messageContent == null || messageContent.trim().isEmpty()) {
            throw new IllegalArgumentException("Message content is empty or null.");
        }

        String trimmed = messageContent.trim();

        if (trimmed.startsWith("<?xml") || messageContent.contains("pacs")) {
            return new MXWriter(); // Handles pacs.008, pacs.009, camt.053, etc.
        } else {
//            if (trimmed.startsWith("{1:") || trimmed.matches("(?s).*\\{\\d:.*"))
            return new MTWriter(); // Handles MT103, MT202, etc.
        }
    }
}
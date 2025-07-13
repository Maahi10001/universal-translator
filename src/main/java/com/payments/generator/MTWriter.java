package com.payments.generator;

import com.payments.parser.GenericMessage;

import java.io.File;
import java.nio.file.Files;
import java.util.Map;

public class MTWriter implements MessageWriter {
    @Override
    public void write(GenericMessage message, File file) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : message.getData().entrySet()) {
            sb.append(entry.getKey()).append(entry.getValue()).append("\n");
        }
        Files.write(file.toPath(), sb.toString().getBytes());
    }
}

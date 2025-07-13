package com.payments.generator;

import com.payments.parser.GenericMessage;

import java.io.File;

public interface MessageWriter {
    void write(GenericMessage message, File file) throws Exception;
}
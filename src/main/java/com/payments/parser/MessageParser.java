package com.payments.parser;


import java.io.File;

public interface MessageParser {
    GenericMessage parse(File file) throws Exception;
}

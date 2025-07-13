package com.payments;


import com.payments.generator.MessageWriter;
import com.payments.generator.MessageWriterFactory;
import com.payments.model.Mapping;
import com.payments.parser.GenericMessage;
import com.payments.parser.MessageParserFactory;
import com.payments.transformer.MappingEngine;
import com.payments.transformer.YamlMappingLoader;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
//        if (args.length < 6) {
//            System.out.println("Usage: java -jar message-translator.jar --mapping <file.yaml> --input <input.txt> --output <output.txt>");
//            return;
//        }

//        String mappingPath = args[1];
//        String inputPath = args[3];
//        String outputPath = args[5];

        String mappingPath = "src/main/resources/mapping.yml";
        String inputPath = "input/input.txt";
        String outputPath = "output/output.txt";

        Mapping mapping = YamlMappingLoader.load(new File(mappingPath));
        GenericMessage sourceMsg = MessageParserFactory.getParser(mapping.getSourceFormat()).parse(new File(inputPath));

        GenericMessage targetMsg = new MappingEngine().apply(mapping, sourceMsg);
        System.out.println("targetMessage: "+targetMsg);
        MessageWriter writer = MessageWriterFactory.getWriter(mapping.getTargetFormat());
        writer.write(targetMsg, new File(outputPath));

        System.out.println("Conversion completed successfully!");
    }
}



package com.payments.transformer;

import com.payments.model.Mapping;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class YamlMappingLoader {
    public static Mapping load(File file) throws Exception {
        Yaml yaml = new Yaml();
        try (InputStream input = new FileInputStream(file)) {
            return yaml.loadAs(input, Mapping.class);
        }
    }
}

package com.payments.transformer;

import com.payments.model.FieldMapping;
import com.payments.model.Mapping;
import com.payments.parser.GenericMessage;

public class MappingEngine {
    public GenericMessage apply(Mapping mapping, GenericMessage source) {
        GenericMessage target = new GenericMessage();
        for (FieldMapping rule : mapping.getMapping()) {
            Object value = source.get(rule.getSource());
            if (value != null) {
                // Transformation logic can be extended here with scripting
                target.put(rule.getTarget(), value);
            }
        }
        return target;
    }
}
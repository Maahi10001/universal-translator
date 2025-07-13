package com.payments.model;


import java.util.List;

public class Mapping {
    private String sourceFormat;
    private String targetFormat;
    private List<FieldMapping> mapping;

    public String getSourceFormat() { return sourceFormat; }
    public void setSourceFormat(String sourceFormat) { this.sourceFormat = sourceFormat; }

    public String getTargetFormat() { return targetFormat; }
    public void setTargetFormat(String targetFormat) { this.targetFormat = targetFormat; }

    public List<FieldMapping> getMapping() { return mapping; }
    public void setMapping(List<FieldMapping> mapping) { this.mapping = mapping; }
}
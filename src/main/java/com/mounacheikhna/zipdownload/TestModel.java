package com.mounacheikhna.zipdownload;

import java.util.List;

public class TestModel {

    public String field1;
    public String field2;
    public SubvalueModel[] subvalues;

    public TestModel(String field1, String field2, SubvalueModel[] subvalues) {
        this.field1 = field1;
        this.field2 = field2;
        this.subvalues = subvalues;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                //", subvalues=" + subvalues +
                '}';
    }
}

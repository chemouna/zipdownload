package com.mounacheikhna.zipdownload;

import java.io.InputStream;

public class MyValidator {

    public void validate(InputStream inputStream) {
        MyReader myReader = new MyReader();
        myReader.read(inputStream);
    }

}

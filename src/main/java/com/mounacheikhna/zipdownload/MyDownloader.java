package com.mounacheikhna.zipdownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyDownloader {

    // just downloads a zip file and passes it to a reader
    public void download() {
        try {
            DriveDownload.download();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // once downloaded we have a file
        File downloadedFile = new File("test.zip");

        MyValidator validator = new MyValidator();
        try {
            validator.validate(new FileInputStream(downloadedFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}

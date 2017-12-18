package com.mounacheikhna.zipdownload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class MyReader {

    public TestModel read(InputStream inputStream) {
        System.out.println("test");
        //TODO: parse the file into a test model

        try {
            //not sure if this the best way though, maybe using the new FileSystem API is better ?
            ZipInputStream zin = new ZipInputStream(inputStream);
            ZipEntry ze;
            while ((ze = zin.getNextEntry()) != null) {
                System.out.println("Unzipping " + ze.getName());
                FileOutputStream fout = new FileOutputStream(ze.getName());
                Copier.copy(zin, fout);
                zin.closeEntry();
                fout.close();
            }
            zin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}

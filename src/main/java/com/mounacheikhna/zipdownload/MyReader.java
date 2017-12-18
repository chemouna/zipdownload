package com.mounacheikhna.zipdownload;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MyReader {

    private Gson gson;

    // temp here
    Map<String, byte[]> images;

    public MyReader() {
        gson = new Gson();
        images = new HashMap<>();
    }

    public TestModel read(InputStream inputStream) {
        System.out.println("test");
        //TODO: parse the file into a test model

        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile("test.zip");
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                File entryDestination = new File(new File("content"),  entry.getName());
                if (entry.isDirectory()) {
                    entryDestination.mkdirs();
                } else {
                    entryDestination.getParentFile().mkdirs();
                    InputStream in = zipFile.getInputStream(entry);

                    if (entry.getName().contains("file.json")) {
                        TestModel testModel = parseJsonFile(in);
                        System.out.println(testModel);
                    }
                    else if (entry.getName().endsWith(".png") && !entry.getName().contains("MACOSX")) {
                        images.put(entry.getName(), IOUtils.toByteArray(in));
                    }

                    OutputStream out = new FileOutputStream(entryDestination);
                    IOUtils.copy(in, out);
                    IOUtils.closeQuietly(in);
                    out.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (zipFile != null) {
                    zipFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    private TestModel parseJsonFile(InputStream in) {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        return gson.fromJson(reader, TestModel.class);
    }

}

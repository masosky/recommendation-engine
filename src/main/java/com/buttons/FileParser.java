package com.buttons;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Singleton
class FileParser {

    private final String csvFile = "dataset.csv";
    private final Cache cache;

    @Inject
    public FileParser(Cache cache) {
        this.cache = cache;
    }

    void parseFile() {
        InputStream csvInputStream = Main.class.getClassLoader().getResourceAsStream(csvFile);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(csvInputStream));
            reader.readLine();
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(",");
                String id = split[0];
                String userId = split[1];
                String tagId = split[2];
                String productName = split[3];

                /*System.out.println("Id: " + id);
                System.out.println("User Id: " + userId);
                System.out.println("Tag Id: " + tagId);
                System.out.println("Product Name: " + productName);
                System.out.println("----");*/

                cache.addVisit(tagId, userId);

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

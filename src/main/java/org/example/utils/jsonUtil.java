package org.example.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class jsonUtil {

    public static String getJson(String path) throws IOException {
        System.out.println("Path:: "+path);
        try (InputStream is = jsonUtil.class.
                    getClassLoader().
                    getResourceAsStream(path))
        {
        BufferedReader reader =new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        System.out.println(reader);

        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    } catch (Exception e) {
        throw new RuntimeException("Unable to load XML file", e);
    }
    }
}

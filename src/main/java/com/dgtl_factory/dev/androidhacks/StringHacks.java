package com.dgtl_factory.dev.androidhacks;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by adrian on 1/1/16.
 */
public class StringHacks {

    public static String readFile( String file ) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader(file));
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();
        String         ls = System.getProperty("line.separator");

        try {
            while( ( line = reader.readLine() ) != null ) {
                stringBuilder.append( line );
                stringBuilder.append( ls );
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }


    /**
     *
     * Function reads in an input stream and converts it to a string in memory. Recommended for small
     * streams
     *
     * @param stream Input Stream
     * @return
     * @throws IOException
     * @throws UnsupportedEncodingException
     */
    public static String readStream(InputStream stream) throws IOException, UnsupportedEncodingException {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();

        reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }
/*
    public static JsonArray parseJsonStringAsArray(String data) throws JsonParseException {
        String jsonString0 = data.replaceAll("^\"|\"$", "");
        String jsonString1 = StringEscapeUtils.unescapeJava(jsonString0);

        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(jsonString1);
        return jsonElement.getAsJsonArray();
    }

    public static JsonObject parseJsonString(String data) throws JsonParseException {
        String jsonString0 = data.replaceAll("^\"|\"$", "");
        String jsonString1 = StringEscapeUtils.unescapeJava(jsonString0);

        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(jsonString1);
        return jsonElement.getAsJsonObject();
    }
    */
}

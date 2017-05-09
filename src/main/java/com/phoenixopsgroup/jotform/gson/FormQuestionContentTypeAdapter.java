/**
 * $Id$
 * <p>
 * Copyright (c) 2017
 */
package com.phoenixopsgroup.jotform.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class FormQuestionContentTypeAdapter
        extends TypeAdapter
{

    private static final Logger logger = LoggerFactory.getLogger(FormQuestionContentTypeAdapter.class);

    @Override
    public Object read(JsonReader jsonReader)
            throws IOException
    {

        FormQuestion formQuestion = new FormQuestion();

        // Is this an Object or a String?
        JsonToken objOrString = jsonReader.peek();
//        System.out.println("PEEK: " + objOrString);

        /*
        HANDLE STRING TYPE
          "content": {
            "2": {
              "buttonAlign": "Center",
              "buttonStyle": "simple_grey",
              "clear": "No",
              "clearText": "Clear Form",
              "encryptIcon": "No",
              "name": "submit",
              "order": "17",
              "print": "No",
              "printText": "Print Form",
              "qid": "2",
              "text": "Submit",
              "type": "control_button"
            }
          },
         */
        if (JsonToken.STRING.equals(objOrString))
        {
            formQuestion.getKeyValuePairs().put("key", jsonReader.nextString());
            return formQuestion;
        }

        /*
        HANDLE OBJECT TYPE
          "content": {
            "2": {
              "buttonAlign": "Center",
              "buttonStyle": "simple_grey",
              "clear": "No",
              "clearText": "Clear Form",
              "encryptIcon": "No",
              "name": "submit",
              "order": "17",
              "print": "No",
              "printText": "Print Form",
              "qid": "2",
              "text": "Submit",
              "type": "control_button"
            }
          },
        */
        jsonReader.beginObject();

        String mapkey = null;
        String mapvalue = null;

        while (jsonReader.hasNext())
        {
            JsonToken nextToken = jsonReader.peek();
//            System.out.println("PEEK: " + nextToken);

            if (JsonToken.BEGIN_OBJECT.equals(nextToken))
            {
                jsonReader.beginObject();
                // sublabels
                String prefix = mapkey;
                while (jsonReader.hasNext())
                {
                    nextToken = jsonReader.peek();
                    if (JsonToken.END_OBJECT.equals(nextToken))
                    {
                        continue;
                    }
                    else if (JsonToken.NAME.equals(nextToken))
                    {
                        mapkey = prefix + "." + jsonReader.nextName();
                    }
                    else if (JsonToken.STRING.equals(nextToken))
                    {
                        mapvalue = jsonReader.nextString();
                        formQuestion.getKeyValuePairs().put(mapkey, mapvalue);
                        mapkey = null;
                        mapvalue = null;

                    }
                    else if (JsonToken.NUMBER.equals(nextToken))
                    {
                        jsonReader.nextLong();
                    }
                }
                jsonReader.endObject();

            }
            else if (JsonToken.NAME.equals(nextToken))
            {
                String name = jsonReader.nextName();
//                System.out.println("NAME: " + name);
                mapkey = name;

            }
            else if (JsonToken.STRING.equals(nextToken))
            {

                String value = jsonReader.nextString();
                mapvalue = value;
                formQuestion.getKeyValuePairs().put(mapkey, mapvalue);
                mapkey = null;
                mapvalue = null;

            }
            else if (JsonToken.NUMBER.equals(nextToken))
            {

                long value = jsonReader.nextLong();
//                System.out.println("NUMBER VALUE:" + value);

            }
            else if (JsonToken.END_OBJECT.equals(nextToken))
            {
                jsonReader.endObject();
//                System.out.println("\nEND OBJECT");
            }

        }

        JsonToken lastToken = jsonReader.peek();
//            System.out.println("PEEK: " + lastToken);

        jsonReader.endObject();

        return formQuestion;

    }


    @Override
    public void write(final JsonWriter jsonWriter, Object answers)
            throws IOException
    {

    }

}

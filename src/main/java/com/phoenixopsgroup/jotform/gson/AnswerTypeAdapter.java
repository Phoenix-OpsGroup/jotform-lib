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

public class AnswerTypeAdapter
        extends TypeAdapter
{

    private static final Logger logger = LoggerFactory.getLogger(AnswerTypeAdapter.class);

    @Override
    public Object read(JsonReader jsonReader)
            throws IOException
    {

        Answer answer = new Answer();

        // Is this an Object or a String?
        JsonToken objOrString = jsonReader.peek();
//        System.out.println("PEEK: " + objOrString);

        /*
        HANDLE STRING TYPE
            "answers": {
              "5": {
                "text": "Comments:",
                "type": "control_textarea",
                "answer": "123425234"
              },

         */
        if (JsonToken.STRING.equals(objOrString))
        {
            answer.getKeyValuePairs().put("key", jsonReader.nextString());
            return answer;
        }

        /*
        HANDLE OBJECT TYPE
            "answers": {
              "4": {
                "text": "Languages",
                "type": "control_matrix",
                "answer": {
                  "Java\t": "Proficient",
                  "C\/C++\t\t\t\t": "Familiar",
                  "Scala": "None",
                  "Groovy": "Familiar",
                  "Python": "Proficient",
                  "Perl": "Familiar",
                  "Bash": "None"
                },
                "prettyFormat": "<table summary=\"\" cellpadding=\"4\" cellspacing=\"0\" border=\"0\" style=\"font-size:10px;border-collapse:collapse;\"><tr><th style=\"border:none\">&nbsp;<\/th><th style=\"background:#eee;border:1px solid #ccc;text-align:center;width:33.333333333333%\">Proficient<\/th><th style=\"background:#eee;border:1px solid #ccc;text-align:center;width:33.333333333333%\">Familiar<\/th><th style=\"background:#eee;border:1px solid #ccc;text-align:center;width:33.333333333333%\">None<\/th><\/tr><tr><th style=\"background:#eee;border:1px solid #ccc;text-align:left;\" nowrap=\"nowrap\">Java\t<\/th><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" ><img src=\"https:\/\/submit.jotform.us\/images\/tick.png\" height=\"16\" width=\"16\" alt=\"X\" align=\"top\" \/><\/td><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" >-<\/td><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" >-<\/td><\/tr><tr><th style=\"background:#eee;border:1px solid #ccc;text-align:left;\" nowrap=\"nowrap\">C\/C++\t\t\t\t<\/th><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" >-<\/td><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" ><img src=\"https:\/\/submit.jotform.us\/images\/tick.png\" height=\"16\" width=\"16\" alt=\"X\" align=\"top\" \/><\/td><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" >-<\/td><\/tr><tr><th style=\"background:#eee;border:1px solid #ccc;text-align:left;\" nowrap=\"nowrap\">Scala<\/th><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" >-<\/td><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" >-<\/td><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" ><img src=\"https:\/\/submit.jotform.us\/images\/tick.png\" height=\"16\" width=\"16\" alt=\"X\" align=\"top\" \/><\/td><\/tr><tr><th style=\"background:#eee;border:1px solid #ccc;text-align:left;\" nowrap=\"nowrap\">Groovy<\/th><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" >-<\/td><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" ><img src=\"https:\/\/submit.jotform.us\/images\/tick.png\" height=\"16\" width=\"16\" alt=\"X\" align=\"top\" \/><\/td><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" >-<\/td><\/tr><tr><th style=\"background:#eee;border:1px solid #ccc;text-align:left;\" nowrap=\"nowrap\">Python<\/th><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" ><img src=\"https:\/\/submit.jotform.us\/images\/tick.png\" height=\"16\" width=\"16\" alt=\"X\" align=\"top\" \/><\/td><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" >-<\/td><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" >-<\/td><\/tr><tr><th style=\"background:#eee;border:1px solid #ccc;text-align:left;\" nowrap=\"nowrap\">Perl<\/th><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" >-<\/td><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" ><img src=\"https:\/\/submit.jotform.us\/images\/tick.png\" height=\"16\" width=\"16\" alt=\"X\" align=\"top\" \/><\/td><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" >-<\/td><\/tr><tr><th style=\"background:#eee;border:1px solid #ccc;text-align:left;\" nowrap=\"nowrap\">Bash<\/th><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" >-<\/td><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" >-<\/td><td align=\"center\" style=\"background:#ffffff;border:1px solid #ccc;\" ><img src=\"https:\/\/submit.jotform.us\/images\/tick.png\" height=\"16\" width=\"16\" alt=\"X\" align=\"top\" \/><\/td><\/tr><\/table>"
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
//                System.out.println("\nNEXT OBJECT");
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
                answer.getKeyValuePairs().put(mapkey, mapvalue);
                mapkey = null;
                mapvalue = null;

            }
            else if (JsonToken.NUMBER.equals(nextToken))
            {

                long value = jsonReader.nextLong();
                System.out.println("NUMBER VALUE:" + value);

            }
        }

        jsonReader.endObject();


//        String jsonReaderName;
//        while (jsonReader.hasNext())
//        {
//            jsonReaderName = jsonReader.nextName();
//
//            counter++;
//            System.out.println(counter + " jsonReadName:" + jsonReaderName);
//            if (null == answer)
//            {
//                // First entry is the answerNumber
//                answer = new Answer();
//                answer.setAnswerNumber(Integer.parseInt(jsonReaderName));
//            }

//
//            switch (jsonReaderName)
//            {
//
//                case "isbn":
////                    answers.setIsbn(jsonReader.nextString());
//                    break;
//                case "title":
////                    answers.setTitle(jsonReader.nextString());
//                    break;
//                case "authors":
////                    answers.setAuthors(jsonReader.nextString().split(";"));
//                    break;
//                default:
//                    System.out.println("*** case:" + jsonReaderName);
//                    System.out.println("************* value:" + jsonReader.nextString());

//            }
//        }


        return answer;

    }


    @Override
    public void write(final JsonWriter jsonWriter, Object answers)
            throws IOException
    {

    }

}

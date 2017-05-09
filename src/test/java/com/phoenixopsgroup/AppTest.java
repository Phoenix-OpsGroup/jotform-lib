package com.phoenixopsgroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.phoenixopsgroup.jotform.gson.*;
import com.phoenixopsgroup.jotform.util.JotformResponse;
import com.phoenixopsgroup.jotform.util.JotformUtil;
import org.apache.commons.io.FileUtils;
import org.junit.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AppTest
{

    /**
     * Create the test case
     */
    public AppTest()
    {

    }

    /**
     * Runs ONCE before ALL @Test(s)
     */
    @BeforeClass
    public static void runBeforeClass() {

    }

    /**
     * Runs before EACH @Test
     */
    @Before
    public void runBeforeEachTest() {

    }
    @Test
    @Ignore
    public void JotformSubmissionTest()
    {

        File fSubmission = new File("../test-data/jotform-lib/jotform.outreach.submission.json");
        File fFormSchema = new File("../test-data/jotform-lib/jotform.outreach.form.questions.json");

        try
        {
            String submissionJson = FileUtils.readFileToString(fSubmission, StandardCharsets.UTF_8);
            String formSchemaJson = FileUtils.readFileToString(fFormSchema, StandardCharsets.UTF_8);


            final GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Answer.class, new AnswerTypeAdapter());
            final Gson gson = gsonBuilder.create();

            JotformSubmission jotformSubmission
                    = gson.fromJson(submissionJson, JotformSubmission.class);


            final GsonBuilder gsonBuilder2 = new GsonBuilder();
            gsonBuilder2.registerTypeAdapter(FormQuestion.class, new FormQuestionContentTypeAdapter());
            final Gson gson2 = gsonBuilder2.create();

            FormQuestionResponse formQuestionResponse
                    = gson2.fromJson(formSchemaJson, FormQuestionResponse.class);
            
            JotformUtil jotformUtil = new JotformUtil();
            JotformResponse jotformResponse = jotformUtil.getResponse(jotformSubmission, formQuestionResponse);
            
//            jotformResponse.dump();
            System.out.println(jotformResponse.toJson(false));

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    @Ignore
    public void JotformQuestionTest()
    {

        File fFormQuestions = new File("../test-data/jotform-lib/jotform.outreach.form.questions.json");

        try
        {
            String formQuestionsJson = FileUtils.readFileToString(fFormQuestions, StandardCharsets.UTF_8);

            final GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(FormQuestion.class, new FormQuestionContentTypeAdapter());
            final Gson gson = gsonBuilder.create();

            FormQuestionResponse formQuestionResponse
                    = gson.fromJson(formQuestionsJson, FormQuestionResponse.class);

            System.out.println(formQuestionResponse.toString());

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Runs after EACH @Test
     */
    @After
    public void runAfterEachTest() {

    }

    /**
     * Runs ONCE after ALL @Test(s)
     */
    @AfterClass
    public static void runAfterClass() {

    }

}

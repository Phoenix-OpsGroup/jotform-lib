package com.phoenixopsgroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.phoenixopsgroup.jotform.gson.Answer;
import com.phoenixopsgroup.jotform.gson.AnswerTypeAdapter;
import com.phoenixopsgroup.jotform.gson.JotformSubmission;
import com.phoenixopsgroup.jotform.util.JotformResponse;
import com.phoenixopsgroup.jotform.util.JotformUtil;
import org.apache.commons.io.FileUtils;
import org.junit.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
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
    @Test  @Ignore
    public void JotformSubmissionTest()
    {

        URL url = this.getClass().getResource("/data/jotform.spi.submission.result.json");
        File file = new File(url.getFile());

        try
        {
            String jsonString = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            final GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Answer.class, new AnswerTypeAdapter());
            final Gson gson = gsonBuilder.create();

            JotformSubmission jotformSubmission
                    = gson.fromJson(jsonString, JotformSubmission.class);

            JotformUtil jotformUtil = new JotformUtil();
            JotformResponse jotformResponse = jotformUtil.getResponse(jotformSubmission);
            
            jotformResponse.dump();

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

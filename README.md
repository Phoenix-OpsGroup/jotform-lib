
## Getting Started ##



### Retrieve Jotform JSON Response from jotform.com ###
```
curl -X GET "https://api.jotform.com/submission/{submissionID}?apiKey={apiKey}"
```

### Read the JSON into a JotformResponse ###

```
final GsonBuilder gsonBuilder = new GsonBuilder();
gsonBuilder.registerTypeAdapter(Answer.class, new AnswerTypeAdapter());
final Gson gson = gsonBuilder.create();

JotformSubmission jotformSubmission
    = gson.fromJson(jsonString, JotformSubmission.class);

JotformUtil jotformUtil = new JotformUtil();
JotformResponse jotformResponse 
    = jotformUtil.getResponse(jotformSubmission);
            
jotformResponse.dump();
```

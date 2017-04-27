
package com.phoenixopsgroup.jotform.gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Answers implements Serializable
{

    private final static long serialVersionUID = -4384061673508836206L;


    private List<Answer> answerList = new ArrayList<>();

    public List<Answer> getAnswerList()
    {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList)
    {
        this.answerList = answerList;
    }
}

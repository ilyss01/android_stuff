package com.example.myapplication;

public class Question {
    private int mtextResId; // id ресурса с текстом ресурса
    private boolean mAnswerTrue; // правильность ответа

    // конструктор
    public Question(int textResId, boolean answerTrue) {
        mtextResId  = textResId;
        mAnswerTrue = answerTrue;
    }
    public int getMtextResId() {
        return mtextResId;
    }

    public void setMtextResId(int mtextResId) {
        this.mtextResId = mtextResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

}

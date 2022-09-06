package com.hb03.onetoone;

public class CustomResult {

    private String stdName;

    private String diaryName;

    public CustomResult(String stdName, String diaryName) {
        this.stdName = stdName;
        this.diaryName = diaryName;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getDiaryName() {
        return diaryName;
    }

    public void setDiaryName(String diaryName) {
        this.diaryName = diaryName;
    }

    @Override
    public String toString() {
        return "CustomResult{" +
                "stdName='" + stdName + '\'' +
                ", diaryName='" + diaryName + '\'' +
                '}';
    }
}

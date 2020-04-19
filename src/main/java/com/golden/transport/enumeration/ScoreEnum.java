package com.golden.transport.enumeration;

/**
 * Created by Temri Mustapha on 05/12/2016.
 */
public enum ScoreEnum {

    WIN("Win"), ACTIVE("Active"), LOSTMATKET("LostMatket"), PROJECTCANCELS("ProjectsCancels"), STOPED("Stoped");

    private final String scoreEnum;

    ScoreEnum(String scoreEnum) {
        this.scoreEnum = scoreEnum;
    }

    public String getScoreEnum() {
        return scoreEnum;
    }
}

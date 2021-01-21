package com.IntroductionSpringBoot.IntroductionSpringBoot.model;

public enum Type {
    WIZZARD("Wizzard"),
    WARRIOR("Warrior");



    private final String displayValue;

    private Type(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}

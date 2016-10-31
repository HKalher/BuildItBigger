package com.example;

import java.util.Random;

public class MyClass {

    private String[] joke = {
            "If at first you don't succeed; call it version 1.0.",
            "If you give someone a program, you will frustrate them for a day; if you teach them how to program, you will frustrate them for a lifetime.",
            "My attitude isn't bad. It's in beta.",
            "SUPERCOMPUTER: what it sounds like before you bought it.",
            "There are only 10 types of people in the world: those that understand binary and those that don't.",
            "CAPS LOCK - Preventing Login Since 1980.",
            "An infinite crowd of mathematicians enters a bar. The first one orders a pint, the second one a half pint, the third one a quarter pint... \"I understand\", says the bartender - and pours two pints.",
            "There are three kinds of people: those who can count and those who can't.",
            "A SEO couple had twins. For the first time they were happy with duplicate content.",
            "These two strings walk into a bar and sit down. The bartender says, \"So what'll it be?\" \n" +
                    "The first string says, \"I think I'll have a beer quag fulk boorg jdk^CjfdLk jk3s d#f67howe%^U r89nvy~~owmc63^Dz x.xvcu\"\n" +
                    "\"Please excuse my friend,\" the second string says, \"He isn't null-terminated.\""
    };

    public String getJoke() {
        int index = new Random().nextInt(joke.length);
        return joke[index];
    }


}

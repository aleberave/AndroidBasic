package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloUnitTest {

    final GreetingStrings greetingStrings = new GreetingStrings() {
        @Override
        public String getHelloer() { return "GB"; }
        @Override
        public String getMorning() { return "Good morning"; }
        @Override
        public String getAfternoon() { return "Good afternoon"; }
        @Override
        public String getEvening() { return "Good evening"; }
        @Override
        public String getNight() { return "Good night"; }
    };

    @Test
    public void BuilderGreetingPhrase_Morning_Test() {
        BuilderGreetingPhrase builderGreetingPhrase =
                new BuilderGreetingPhrase(greetingStrings, 9);
        String expected = "Good morning GB!";
        String actual = builderGreetingPhrase.get();
        assertEquals(expected, actual);
    }

    @Test
    public void BuilderGreetingPhrase_Afternoon_Test() {
        BuilderGreetingPhrase builderGreetingPhrase =
                new BuilderGreetingPhrase(greetingStrings, 12);
        String expected = "Good afternoon GB!";
        String actual = builderGreetingPhrase.get();
        assertEquals(expected, actual);
    }

    @Test
    public void BuilderGreetingPhrase_Evening_Test() {
        BuilderGreetingPhrase builderGreetingPhrase
                = new BuilderGreetingPhrase(greetingStrings, 18);
        String expected = "Good evening GB!";
        String actual = builderGreetingPhrase.get();
        assertEquals(expected, actual);
    }

    @Test
    public void BuilderGreetingPhrase_Night_Test() {
        BuilderGreetingPhrase builderGreetingPhrase
                = new BuilderGreetingPhrase(greetingStrings, 22);
        String expected = "Good night GB!";
        String actual = builderGreetingPhrase.get();
        assertEquals(expected, actual);
    }
}

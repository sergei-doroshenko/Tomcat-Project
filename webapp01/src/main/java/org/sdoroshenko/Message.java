package org.sdoroshenko;

public class Message {

    private final String input;

    public Message(String input) {
        this.input = input;
    }

    public String print() {
        return String.format("Message[%s]", input);
    }
}

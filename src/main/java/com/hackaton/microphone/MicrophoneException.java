package com.hackaton.microphone;

public class MicrophoneException extends Exception {

    public MicrophoneException() {
        super("Mikrofon nie wspierany");
    }

    public MicrophoneException(String message) {
        super(message);
    }
}

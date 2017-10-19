package com.hackaton.microphone;

import com.hackaton.exception.MicrophoneException;

import javax.sound.sampled.*;

public class Microphone {
    private TargetDataLine line;
    private DataLine.Info info;
    private AudioFormat format;

    public Microphone(AudioFormat format) throws MicrophoneException {
        this.info = new DataLine.Info(TargetDataLine.class, format);
        if (!AudioSystem.isLineSupported(info)) {
            throw new MicrophoneException();
        }
        this.format = format;
    }

    public void openStream() {
        try {
            this.line = (TargetDataLine) AudioSystem.getLine(this.info);
            this.line.open(this.format);
        } catch (LineUnavailableException e) {
            System.err.println(e.getMessage());
        }
    }

    public void startRecording() {

    }

    public void closeStream() {
        this.line.close();
    }

}

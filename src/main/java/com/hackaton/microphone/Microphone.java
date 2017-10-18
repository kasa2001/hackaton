package com.hackaton.microphone;

import javax.sound.sampled.*;

public class Microphone {
    private TargetDataLine line;
    private DataLine.Info info;
    private AudioFormat format;

    public Microphone(AudioFormat format) {
        this.info = new DataLine.Info(TargetDataLine.class, format);
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

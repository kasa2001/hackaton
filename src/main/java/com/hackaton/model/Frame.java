package com.hackaton.model;

public class Frame {
  private int id;
  private int mpeg_version;
  private int layer;
  private boolean protection_bit;
  private int bitrate;
  private int sampling;
  private boolean padding;
  private int channel;
  private int mode_extension;
  private boolean copyright;
  private boolean original;
  private int emphasis;

  public Frame(int id, int mpeg_version, int layer,
               boolean protection_bit, int bitrate,
               int sampling, boolean padding, int channel,
               int mode_extension, boolean copyright,
               boolean original, int emphasis) {
    this.id = id;
    this.mpeg_version = mpeg_version;
    this.layer = layer;
    this.protection_bit = protection_bit;
    this.bitrate = bitrate;
    this.sampling = sampling;
    this.padding = padding;
    this.channel = channel;
    this.mode_extension = mode_extension;
    this.copyright = copyright;
    this.original = original;
    this.emphasis = emphasis;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getMpeg_version() {
    return mpeg_version;
  }

  public void setMpeg_version(int mpeg_version) {
    this.mpeg_version = mpeg_version;
  }

  public int getLayer() {
    return layer;
  }

  public void setLayer(int layer) {
    this.layer = layer;
  }

  public boolean isProtection_bit() {
    return protection_bit;
  }

  public void setProtection_bit(boolean protection_bit) {
    this.protection_bit = protection_bit;
  }

  public int getBitrate() {
    return bitrate;
  }

  public void setBitrate(int bitrate) {
    this.bitrate = bitrate;
  }

  public int getSampling() {
    return sampling;
  }

  public void setSampling(int sampling) {
    this.sampling = sampling;
  }

  public boolean isPadding() {
    return padding;
  }

  public void setPadding(boolean padding) {
    this.padding = padding;
  }

  public int getChannel() {
    return channel;
  }

  public void setChannel(int channel) {
    this.channel = channel;
  }

  public int getMode_extension() {
    return mode_extension;
  }

  public void setMode_extension(int mode_extension) {
    this.mode_extension = mode_extension;
  }

  public boolean isCopyright() {
    return copyright;
  }

  public void setCopyright(boolean copyright) {
    this.copyright = copyright;
  }

  public boolean isOriginal() {
    return original;
  }

  public void setOriginal(boolean original) {
    this.original = original;
  }

  public int getEmphasis() {
    return emphasis;
  }

  public void setEmphasis(int emphasis) {
    this.emphasis = emphasis;
  }
}

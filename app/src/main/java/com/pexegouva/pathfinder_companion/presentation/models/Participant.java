package com.pexegouva.pathfinder_companion.presentation.models;

public class Participant {

  private String name;
  private int thrown = 1;

  public Participant(String name, int thrown) {
    this.name = name;
    this.thrown = thrown;
  }

  public String getName() {
    return name;
  }

  public int getThrown() {
    return thrown;
  }
}

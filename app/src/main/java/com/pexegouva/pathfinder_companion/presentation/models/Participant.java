package com.pexegouva.pathfinder_companion.presentation.models;

public class Participant {

  private String name;
  private String thrown;

  public Participant(String name, String thrown) {
    this.name = name;
    this.thrown = thrown;
  }

  public String getName() {
    return name;
  }

  public String getPrettyThrown() {
    return "Tirada: " + thrown;
  }
}

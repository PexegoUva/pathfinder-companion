package com.pexegouva.pathfinder_companion.features.initiativeTurn;

public class ParticipantModel {

  private String name;
  private String thrown;

  public ParticipantModel(String name, String thrown) {
    this.name = name;
    this.thrown = thrown;
  }

  public String getName() {
    return name;
  }

  public String getThrown() {
    return thrown;
  }
}

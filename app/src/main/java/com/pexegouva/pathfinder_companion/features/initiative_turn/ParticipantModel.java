package com.pexegouva.pathfinder_companion.features.initiative_turn;

public class ParticipantModel {

  private String name;
  private String thrown;

  ParticipantModel(String name, String thrown) {
    this.name = name;
    this.thrown = thrown;
  }

  public String getName() {
    return name;
  }

  String getThrown() {
    return thrown;
  }
}

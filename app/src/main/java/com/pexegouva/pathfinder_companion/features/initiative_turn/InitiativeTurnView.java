package com.pexegouva.pathfinder_companion.features.initiative_turn;

import com.pexegouva.pathfinder_companion.core.platform.ViewInitializer;

public interface InitiativeTurnView extends ViewInitializer {
  void showNewParticipantFragment();
  void hideNewParticipantFragment();
  void addNewParticipantToList(ParticipantModel participant);
  void nextParticipant(String participantName);
  void nextTurn();
  void showTurnManagementContainer();
  void enableNextParticipantButton();
  void disableNextParticipantButton();
}

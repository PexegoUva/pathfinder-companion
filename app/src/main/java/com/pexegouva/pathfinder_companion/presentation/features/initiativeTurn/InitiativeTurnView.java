package com.pexegouva.pathfinder_companion.presentation.features.initiativeTurn;

import com.pexegouva.pathfinder_companion.presentation.ViewInitializer;
import com.pexegouva.pathfinder_companion.presentation.models.ParticipantModel;

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

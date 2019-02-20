package com.pexegouva.pathfinder_companion.presentation.features.initiativeTurn;

import com.pexegouva.pathfinder_companion.presentation.models.Participant;

public interface InitiativeTurnView {
  void showNewParticipantFragment();
  void hideNewParticipantFragment();
  void addNewParticipantToList(Participant participant);
}

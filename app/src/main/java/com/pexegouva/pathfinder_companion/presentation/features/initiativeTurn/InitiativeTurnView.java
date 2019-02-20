package com.pexegouva.pathfinder_companion.presentation.features.initiativeTurn;

import com.pexegouva.pathfinder_companion.presentation.models.ParticipantModel;

public interface InitiativeTurnView {
  void showNewParticipantFragment();
  void hideNewParticipantFragment();
  void addNewParticipantToList(ParticipantModel participant);
}

package com.pexegouva.pathfinder_companion.presentation.features.initiativeTurn;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.pexegouva.pathfinder_companion.presentation.Presenter;
import com.pexegouva.pathfinder_companion.presentation.models.Participant;

public class InitiativeTurnPresenter implements Presenter {

  private InitiativeTurnView initiativeTurnView;

  @Override
  public void resume() {

  }

  @Override
  public void pause() {

  }

  @Override
  public void destroy() {

  }

  @Override
  public void setView(@NonNull InitiativeTurnView view) {
    this.initiativeTurnView = view;
  }

  void toggleNewParticipantFragmentVisibility(Fragment newParticipantFragment) {
    if (newParticipantFragment.isVisible()) {
      initiativeTurnView.hideNewParticipantFragment();
    } else {
      initiativeTurnView.showNewParticipantFragment();
    }
  }

  void addNewParticipantToList(String name, String thrown) {
    Participant newParticipant = new Participant(name, thrown);
    initiativeTurnView.addNewParticipantToList(newParticipant);
  }
}

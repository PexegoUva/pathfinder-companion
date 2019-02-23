package com.pexegouva.pathfinder_companion.features.initiative_turn;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.pexegouva.pathfinder_companion.R;
import com.pexegouva.pathfinder_companion.core.platform.Presenter;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class InitiativeTurnPresenter implements Presenter {

  private Context context;
  private InitiativeTurnView initiativeTurnView;

  private HashMap<String, Integer> thrownList = new HashMap<>();

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

  void setContext(@NonNull Context context) { this.context = context; }

  void setThrownList(List<ParticipantModel> participantList) {
    initThrownList(participantList);
  }

  void toggleNewParticipantFragmentVisibility(Fragment newParticipantFragment) {
    if (newParticipantFragment.isVisible()) {
      initiativeTurnView.hideNewParticipantFragment();
    } else {
      initiativeTurnView.showNewParticipantFragment();
    }
  }

  void addNewParticipantToList(String name, String thrown) {
    if (name.equals("") || thrown.equals("")) {
      initiativeTurnView.showError(context.getString(R.string.error_participant_name_or_thrown_empty));
    } else {
      ParticipantModel newParticipant = new ParticipantModel(name, thrown);
      initiativeTurnView.addNewParticipantToList(newParticipant);
      initiativeTurnView.showTurnManagementContainer();
    }
  }

  void nextParticipant() {
    String nextParticipantName = Collections.max(
        thrownList.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
    thrownList.remove(nextParticipantName);
    initiativeTurnView.nextParticipant(nextParticipantName);

    if (thrownList.size() == 0) {
      initiativeTurnView.disableNextParticipantButton();
    }
  }

  void nextTurn() {
    initiativeTurnView.nextTurn();
    initiativeTurnView.enableNextParticipantButton();
  }

  private void initThrownList(List<ParticipantModel> participantList) {
    for(ParticipantModel participant : participantList) {
      thrownList.put(participant.getName(), Integer.parseInt(participant.getThrown()));
    }
  }
}

package com.pexegouva.pathfinder_companion.features.initiative_turn;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pexegouva.pathfinder_companion.R;

public class NewParticipantFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.new_participant_fragment, container, false);
  }
}

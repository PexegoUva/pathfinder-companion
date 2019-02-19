package com.pexegouva.pathfinder_companion.presentation;

import com.pexegouva.pathfinder_companion.presentation.features.initiativeTurn.InitiativeTurnView;
import androidx.annotation.NonNull;

public interface Presenter {
  void resume();

  void pause();

  void destroy();

  void setView(@NonNull InitiativeTurnView view);
}

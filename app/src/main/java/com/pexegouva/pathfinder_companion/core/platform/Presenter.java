package com.pexegouva.pathfinder_companion.core.platform;

import com.pexegouva.pathfinder_companion.features.initiativeTurn.InitiativeTurnView;
import androidx.annotation.NonNull;

public interface Presenter {
  void resume();

  void pause();

  void destroy();

  void setView(@NonNull InitiativeTurnView view);
}

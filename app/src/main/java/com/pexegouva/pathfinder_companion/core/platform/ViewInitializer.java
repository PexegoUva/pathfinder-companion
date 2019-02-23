package com.pexegouva.pathfinder_companion.core.platform;

public interface ViewInitializer {

  void initializeData();

  void initializeUI();

  void showError(String errorMessage);
}

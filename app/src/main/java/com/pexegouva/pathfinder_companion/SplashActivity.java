package com.pexegouva.pathfinder_companion;

import android.content.Intent;
import android.os.Bundle;

import com.pexegouva.pathfinder_companion.features.initiative_turn.InitiativeTurnActivity;

import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    startActivity(new Intent(SplashActivity.this, InitiativeTurnActivity.class));
    finish();
  }
}
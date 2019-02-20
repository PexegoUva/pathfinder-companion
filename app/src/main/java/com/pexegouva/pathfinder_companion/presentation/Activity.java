package com.pexegouva.pathfinder_companion.presentation;

import android.annotation.SuppressLint;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("Registered")
public class Activity extends AppCompatActivity {

  @SuppressLint("ShowToast")
  public Toast initError(String error) {
    return Toast.makeText(this, error, Toast.LENGTH_LONG);
  }
}

package com.pexegouva.pathfinder_companion.presentation.features.initiativeTurn;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pexegouva.pathfinder_companion.R;
import com.pexegouva.pathfinder_companion.presentation.ViewInitializer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class InitiativeTurnActivity extends AppCompatActivity implements ViewInitializer, InitiativeTurnView {

  private InitiativeTurnPresenter initiativeTurnPresenter;
  private ParticipantsListAdapter participantsListAdapter;

  @BindView(R.id.participant_list)
  RecyclerView participantList;

  Fragment newParticipantFragment;
  FragmentManager fragmentManager;
  FragmentTransaction transaction;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    initializeData();
    initializeUI();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public void initializeData() {
    initiativeTurnPresenter = new InitiativeTurnPresenter();
    initiativeTurnPresenter.setView(this);

    participantsListAdapter = new ParticipantsListAdapter(this);
  }

  @Override
  public void initializeUI() {
    setContentView(R.layout.initiative_turn_activity);
    ButterKnife.bind(this);

    initializeToolbar();
    initializeFloatingButton();
    initializeParticipantList();
    initializeNewParticipantsFragment();
  }

  private void initializeToolbar() {
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }

  private void initializeFloatingButton() {
    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(view -> initiativeTurnPresenter.toggleNewParticipantFragmentVisibility(newParticipantFragment));
  }

  private void initializeParticipantList() {
    participantList.setHasFixedSize(true); // Improve performance due to fixed Height.
    participantList.setAdapter(new ParticipantsListAdapter(this));
  }

  private void initializeNewParticipantsFragment() {
    fragmentManager = getSupportFragmentManager();
    newParticipantFragment = fragmentManager.findFragmentById(R.id.new_participant);

    transaction = fragmentManager.beginTransaction();
    transaction.hide(newParticipantFragment);
    transaction.commit();
  }

  @Override
  public void showNewParticipantFragment() {
    transaction = fragmentManager.beginTransaction();
    transaction.show(newParticipantFragment);
    transaction.commit();
  }

  @Override
  public void hideNewParticipantFragment() {
    transaction = fragmentManager.beginTransaction();
    transaction.hide(newParticipantFragment);
    transaction.commit();
  }
}

package com.pexegouva.pathfinder_companion.presentation.features.initiativeTurn;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.pexegouva.pathfinder_companion.R;
import com.pexegouva.pathfinder_companion.presentation.ViewInitializer;
import com.pexegouva.pathfinder_companion.presentation.models.ParticipantModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InitiativeTurnActivity extends AppCompatActivity implements ViewInitializer, InitiativeTurnView {

  private InitiativeTurnPresenter initiativeTurnPresenter;
  private ParticipantsListAdapter participantsListAdapter;

  @BindView(R.id.participant_list)
  RecyclerView participantList;

  @BindView(R.id.new_participant_name_edit_text)
  EditText participantName;
  @BindView(R.id.new_participant_thrown_edit_text)
  EditText participantThrown;

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
    participantList.setLayoutManager(new LinearLayoutManager(this));
    participantList.setAdapter(participantsListAdapter);
  }

  private void initializeNewParticipantsFragment() {
    fragmentManager = getSupportFragmentManager();
    newParticipantFragment = fragmentManager.findFragmentById(R.id.new_participant);

    transaction = fragmentManager.beginTransaction();
    transaction.hide(newParticipantFragment);
    transaction.commit();
  }

  @OnClick(R.id.add_new_participant_button)
  void onNewParticipantClick() {
    String newParticipantName = participantName.getText().toString();
    String newParticipantThrown = participantThrown.getText().toString();
    initiativeTurnPresenter.addNewParticipantToList(newParticipantName, newParticipantThrown);
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

  @Override
  public void addNewParticipantToList(ParticipantModel participant) {
    participantsListAdapter.addItem(participant);
  }
}

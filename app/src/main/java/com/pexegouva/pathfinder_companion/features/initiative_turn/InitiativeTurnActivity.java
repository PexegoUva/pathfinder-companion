package com.pexegouva.pathfinder_companion.features.initiative_turn;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pexegouva.pathfinder_companion.R;
import com.pexegouva.pathfinder_companion.core.platform.BaseActivity;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InitiativeTurnActivity extends BaseActivity implements InitiativeTurnView {

  private InitiativeTurnPresenter initiativeTurnPresenter;
  private ParticipantsListAdapter participantsListAdapter;

  @BindView(R.id.toolbar)
  Toolbar toolbar;
  @BindView(R.id.participant_list)
  RecyclerView participantList;

  @BindView(R.id.new_participant_name_edit_text)
  EditText participantName;
  @BindView(R.id.new_participant_thrown_edit_text)
  EditText participantThrown;
  @BindView(R.id.turn_order)
  TextView turnOrder;
  @BindView(R.id.turn)
  TextView newTurn;
  @BindView(R.id.turn_management_container)
  LinearLayout turnManagementContainer;
  @BindView(R.id.next_participant_turn)
  Button nextParticipant;

  Fragment newParticipantFragment;
  FragmentManager fragmentManager;
  FragmentTransaction transaction;

  private int currentTurn;

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
    initiativeTurnPresenter.setContext(this);

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

  @Override
  public void showError(String error) {
    initError(error).show();
  }

  private void initializeToolbar() {
    setSupportActionBar(toolbar);
    Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.toolbar_title);
    getSupportActionBar().setSubtitle(R.string.participant_list_sub_title);
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

  @OnClick(R.id.new_turn)
  void onNewTurnClick() {
    currentTurn++;
    initiativeTurnPresenter.setThrownList(participantsListAdapter.getItemList());
    initiativeTurnPresenter.nextTurn();
  }

  @OnClick(R.id.next_participant_turn)
  void onNextParticipantClick() {
    initiativeTurnPresenter.nextParticipant();
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

  @Override
  public void nextParticipant(String participantName) {
    turnOrder.setText(getString(R.string.participant_list_text_view_next_turn, participantName));
  }

  @Override
  public void nextTurn() {
    newTurn.setText(getString(R.string.participant_list_text_view_new_turn, currentTurn));
  }

  @Override
  public void showTurnManagementContainer() {
    turnManagementContainer.setVisibility(View.VISIBLE);
  }

  @Override
  public void enableNextParticipantButton() {
    nextParticipant.setEnabled(true);
  }

  @Override
  public void disableNextParticipantButton() {
    nextParticipant.setEnabled(false);
  }
}

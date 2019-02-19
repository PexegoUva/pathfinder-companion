package com.pexegouva.pathfinder_companion.presentation.features.initiativeTurn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pexegouva.pathfinder_companion.R;
import com.pexegouva.pathfinder_companion.presentation.models.Participant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ParticipantsListAdapter extends RecyclerView.Adapter<ParticipantsListAdapter.ViewHolder> {
  private Context context;

  private final LayoutInflater layoutInflater;

  private List<Participant> participantsCollection;

  public ParticipantsListAdapter(Context context) {
    this.context = context;
    layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
    View participantsList = this.layoutInflater.inflate(R.layout.initiative_turn_list_item, parent, false);
    return new ViewHolder(participantsList);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
    final Participant participant = this.getItem(position);

    viewHolder.participantName.setText(participant.getName());
    viewHolder.participantThrown.setText(participant.getThrown());
  }

  @Override
  public int getItemCount() {
    return (participantsCollection != null) ? participantsCollection.size() : 0;
  }

  public Participant getItem(int position) {
    return participantsCollection.get(position);
  }

  public void addItem(Participant participant) {
    List<Participant> participants = new ArrayList<>(participantsCollection);

    this.validateCollection(participants);
    this.participantsCollection.add(participant);
    this.notifyItemInserted(participantsCollection.size() - 1);
  }

  private void validateCollection(Collection<Participant> participants) {
    if (participants == null) {
      throw new IllegalArgumentException("The list cannot be null");
    }
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.participant_name)
    TextView participantName;

    @BindView(R.id.participant_thrown)
    TextView participantThrown;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}

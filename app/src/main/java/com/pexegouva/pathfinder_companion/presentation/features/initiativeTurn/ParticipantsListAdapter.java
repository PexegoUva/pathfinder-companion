package com.pexegouva.pathfinder_companion.presentation.features.initiativeTurn;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pexegouva.pathfinder_companion.R;
import com.pexegouva.pathfinder_companion.presentation.models.ParticipantModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ParticipantsListAdapter extends RecyclerView.Adapter<ParticipantsListAdapter.ItemViewHolder> {

  private Context context;

  private final LayoutInflater layoutInflater;

  private List<ParticipantModel> participantsCollection;

  ParticipantsListAdapter(Context context) {
    layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    this.context = context;
    this.participantsCollection = new ArrayList<>();
  }

  @NonNull
  @Override
  public ParticipantsListAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View participantItem = layoutInflater.inflate(R.layout.participant_list_item, parent, false);
    return new ItemViewHolder(participantItem);
  }

  @Override
  public void onBindViewHolder(@NonNull ItemViewHolder viewHolder, int position) {
    final ParticipantModel participant = this.getItem(position);

    viewHolder.participantName.setText(participant.getName());

    String prettyThrown =
        context.getString(R.string.participant_list_text_view_pretty_thrown, participant.getThrown());
    viewHolder.participantThrown.setText(prettyThrown);
  }

  @Override
  public int getItemCount() {
    return (participantsCollection != null) ? participantsCollection.size() : 0;
  }

  ParticipantModel getItem(int position) {
    return participantsCollection.get(position);
  }

  void addItem(ParticipantModel participant) {
    this.validateCollection(participantsCollection);

    participantsCollection.add(participant);
    this.notifyItemInserted(participantsCollection.size() - 1);
  }

  private void validateCollection(Collection<ParticipantModel> participants) {
    if (participants == null) {
      throw new IllegalArgumentException("The list cannot be null");
    }
  }

  class ItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.participant_list_name)
    TextView participantName;

    @BindView(R.id.participant_list_thrown)
    TextView participantThrown;

    ItemViewHolder(@NonNull View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}

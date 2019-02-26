package com.pexegouva.pathfinder_companion.features.enemies_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.pexegouva.pathfinder_companion.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class EnemyListAdapter extends RecyclerView.Adapter<EnemyListAdapter.EnemiesViewHolder> {


    class EnemiesViewHolder extends RecyclerView.ViewHolder {
        private final EditText tvName;
        private final EditText tvPG;
        private final EditText tvCA;
        private final EditText tvFlatFooted;
        private final EditText tvTouch;
        private final EditText tvFort;
        private final EditText tvRef;
        private final EditText tvVol;
        private final EditText tvResists;
        private final EditText tvSpeed;
        private final EditText tvInitiative;
        private final EditText tvAttack;
        private final EditText tvDamage;
        private final EditText tvFeats;
        private final EditText tvSpecials;
        private final EditText tvExperience;

        private EnemiesViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.enemy_list_name);

            // Defense
            tvPG = itemView.findViewById(R.id.enemy_list_pg);
            tvCA = itemView.findViewById(R.id.enemy_list_ca);
            tvFlatFooted = itemView.findViewById(R.id.enemy_list_flat_footed);
            tvTouch = itemView.findViewById(R.id.enemy_list_touch);
            tvFort = itemView.findViewById(R.id.enemy_list_fort);
            tvRef = itemView.findViewById(R.id.enemy_list_ref);
            tvVol = itemView.findViewById(R.id.enemy_list_vol);
            tvResists = itemView.findViewById(R.id.enemy_list_resists);

            // Combat
            tvSpeed = itemView.findViewById(R.id.enemy_list_speed);
            tvInitiative = itemView.findViewById(R.id.enemy_list_initiative);
            tvAttack = itemView.findViewById(R.id.enemy_list_attack_bonus);
            tvDamage = itemView.findViewById(R.id.enemy_list_damage);

            // Skills
            tvFeats = itemView.findViewById(R.id.enemy_list_feats);
            tvSpecials = itemView.findViewById(R.id.enemy_list_specials);
            tvExperience = itemView.findViewById(R.id.enemy_list_experience);
        }
    }

    private final LayoutInflater mInflater;
    private List<Enemy> enemyList; // Cached copy of words

    EnemyListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public EnemiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.enemy_list_item, parent, false);
        return new EnemiesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EnemiesViewHolder holder, int position) {
        if (enemyList != null) {
            Enemy current = enemyList.get(position);
            if (current.getName() != null) {
                holder.tvName.setText(current.getName());
            }
            if (current.getDamage() != null) {
                holder.tvDamage.setText(current.getDamage());
            }
            if (current.getFeats() != null) {
                holder.tvFeats.setText(current.getFeats());
            }
            if (current.getResists() != null) {
                holder.tvResists.setText(current.getResists());
            }
            if (current.getFeats() != null) {
                holder.tvSpecials.setText(current.getSpecials());
            }
            holder.tvPG.setText(String.valueOf(current.getPg()));
            holder.tvCA.setText(String.valueOf(current.getCa()));
            holder.tvFlatFooted.setText(String.valueOf(current.getFlatFooted()));
            holder.tvTouch.setText(String.valueOf(current.getTouch()));
            holder.tvFort.setText(String.valueOf(current.getFort()));
            holder.tvRef.setText(String.valueOf(current.getRef()));
            holder.tvVol.setText(String.valueOf(current.getVol()));
            holder.tvSpeed.setText(String.valueOf(current.getSpeed()));
            holder.tvInitiative.setText(String.valueOf(current.getInitiative()));
            holder.tvAttack.setText(String.valueOf(current.getAttack()));
            holder.tvExperience.setText(String.valueOf(current.getExperiencePoints()));
        }
    }

    void setEnemies(List<Enemy> enemies){
        enemyList = enemies;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (enemyList != null)
            return enemyList.size();
        else return 0;
    }
}

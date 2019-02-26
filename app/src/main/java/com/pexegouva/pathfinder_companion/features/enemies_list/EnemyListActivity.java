package com.pexegouva.pathfinder_companion.features.enemies_list;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.pexegouva.pathfinder_companion.R;

import java.util.List;

public class EnemyListActivity extends AppCompatActivity {

    private EnemyViewModel enemyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enemies_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.rv_enemy_list);
        final EnemyListAdapter adapter = new EnemyListAdapter(this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        enemyViewModel = ViewModelProviders.of(this).get(EnemyViewModel.class);
        enemyViewModel.getAllWords().observe(this, new Observer<List<Enemy>>() {
            @Override
            public void onChanged(@Nullable final List<Enemy> enemies) {
                // Update the cached copy of the words in the adapter.
                adapter.setEnemies(enemies);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Enemy enemy = new Enemy();
                enemyViewModel.insert(enemy);
            }
        });
    }

}

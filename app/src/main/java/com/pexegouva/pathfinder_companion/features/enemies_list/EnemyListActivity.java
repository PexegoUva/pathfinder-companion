package com.pexegouva.pathfinder_companion.features.enemies_list;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.pexegouva.pathfinder_companion.R;

import java.util.List;

public class EnemyListActivity extends AppCompatActivity {

    private EnemyViewModel enemyViewModel;
    private MenuItem deleteMenuItem;
    private EnemyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enemies_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        RecyclerView recyclerView = findViewById(R.id.rv_enemy_list);
        adapter = new EnemyListAdapter(this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        enemyViewModel = ViewModelProviders.of(this).get(EnemyViewModel.class);
        enemyViewModel.getAllEnemies().observe(this, new Observer<List<Enemy>>() {
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
                updateEnemies();
                Enemy enemy = new Enemy();
                enemyViewModel.insert(enemy);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enemies, menu);
        deleteMenuItem = menu.getItem(0);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_delete) {
            updateEnemies();
            deleteEnemies();
            adapter.resetSelectedList();
            hideDelete();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showDelete() {
        this.deleteMenuItem.setVisible(true);
    }

    public void hideDelete() {
        this.deleteMenuItem.setVisible(false);
    }

    @Override
    public void onPause() {
        super.onPause();
        updateEnemies();
    }

    private void updateEnemies() {
        List<Enemy> enemies = enemyViewModel.getAllEnemies().getValue();
        for (Enemy enemy: enemies) {
            enemyViewModel.insert(enemy);
        }
    }

    private void deleteEnemies() {
        List<Enemy> enemiesToDelete = adapter.getSelectedEnemies();
        for (Enemy enemy: enemiesToDelete) {
            enemyViewModel.delete(enemy);
        }
    }
}

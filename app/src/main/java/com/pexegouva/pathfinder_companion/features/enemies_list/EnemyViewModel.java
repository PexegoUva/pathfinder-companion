package com.pexegouva.pathfinder_companion.features.enemies_list;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class EnemyViewModel extends AndroidViewModel {
    private EnemiesRepository mRepository;

    private LiveData<List<Enemy>> allEnemies;

    public EnemyViewModel (Application application) {
        super(application);
        mRepository = new EnemiesRepository(application);
        allEnemies = mRepository.getAllEnemies();
    }

    LiveData<List<Enemy>> getAllEnemies() { return allEnemies; }

    void insert(Enemy enemy) { mRepository.insert(enemy); }

    void delete(Enemy enemy) { mRepository.delete(enemy); }

}

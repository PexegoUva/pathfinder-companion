package com.pexegouva.pathfinder_companion.features.enemies_list;

import android.app.Application;
import android.os.AsyncTask;

import com.pexegouva.pathfinder_companion.core.persistence.PathfinderDatabase;

import java.util.List;

import androidx.lifecycle.LiveData;

public class EnemiesRepository {

    private EnemyDao enemyDao;
    private LiveData<List<Enemy>> allEnemies;

    public EnemiesRepository(Application application) {
        PathfinderDatabase db = PathfinderDatabase.getDatabase(application);
        enemyDao = db.enemyDao();
        allEnemies = enemyDao.getAllEnemies();
    }

    public LiveData<List<Enemy>> getAllEnemies() {
        return allEnemies;
    }

    public void insert(Enemy enemy) {
        new insertAsyncTask(enemyDao).execute(enemy);
    }

    private static class insertAsyncTask extends AsyncTask<Enemy, Void, Void> {

        private EnemyDao mAsyncTaskDao;

        insertAsyncTask(EnemyDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Enemy... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}

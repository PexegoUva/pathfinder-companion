package com.pexegouva.pathfinder_companion.features.enemies_list;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface EnemyDao {
    @Query("SELECT * from enemy ORDER BY name ASC")
    LiveData<List<Enemy>> getAllEnemies();

    @Query("SELECT * FROM enemy WHERE id IN (:enemyIds)")
    List<Enemy> loadAllByIds(int[] enemyIds);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Enemy enemy);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Enemy... enemies);

    @Delete
    void delete(Enemy enemy);

    @Query("DELETE FROM Enemy")
    void deleteAll();
}

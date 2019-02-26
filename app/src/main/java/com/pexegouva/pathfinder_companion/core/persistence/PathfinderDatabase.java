package com.pexegouva.pathfinder_companion.core.persistence;

import android.content.Context;

import com.pexegouva.pathfinder_companion.features.enemies_list.Enemy;
import com.pexegouva.pathfinder_companion.features.enemies_list.EnemyDao;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Enemy.class}, version = 1)
public abstract class PathfinderDatabase extends RoomDatabase {

    public abstract EnemyDao enemyDao();

    private static volatile PathfinderDatabase INSTANCE;

    public static PathfinderDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PathfinderDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PathfinderDatabase.class, "pathfinder_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

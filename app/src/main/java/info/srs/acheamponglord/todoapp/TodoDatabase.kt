package info.srs.acheamponglord.todoapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import info.srs.acheamponglord.todoapp.dao.TodoDao
import info.srs.acheamponglord.todoapp.models.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = false)
 abstract class TodoDatabase: RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        // Singleton function to prevent multiple instances of the same database
        private var INSTANCE: TodoDatabase? = null

        fun getDatabase(context: Context): TodoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance  = Room.databaseBuilder(context.applicationContext,
                    TodoDatabase::class.java,"todo")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
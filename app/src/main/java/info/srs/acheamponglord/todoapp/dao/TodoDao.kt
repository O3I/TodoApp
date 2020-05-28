package info.srs.acheamponglord.todoapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import info.srs.acheamponglord.todoapp.models.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    fun getAll(): LiveData<List<Todo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(todo: Todo)

    @Query("UPDATE todo SET name = :name, description = :description WHERE uid = :uid")
    suspend fun update(uid: Int, name: String, description: String?)

    @Query("DELETE FROM todo")
    suspend fun deleteAll()
}
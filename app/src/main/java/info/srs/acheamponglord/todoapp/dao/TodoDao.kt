package info.srs.acheamponglord.todoapp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import info.srs.acheamponglord.todoapp.models.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    fun getAll(): LiveData<List<Todo>>

    @Query("SELECT * FROM  todo WHERE uid = :uid")
    fun findByUID(uid: Int)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(todo: Todo)

    @Query("DELETE FROM todo")
    suspend fun deleteAll()
}
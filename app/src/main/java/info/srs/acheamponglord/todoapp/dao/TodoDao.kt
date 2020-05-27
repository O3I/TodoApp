package info.srs.acheamponglord.todoapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import info.srs.acheamponglord.todoapp.models.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    fun getAll(): LiveData<List<Todo>>

    @Query("SELECT * FROM  todo WHERE uid = :uid")
    fun findByUID(uid: Int)
}
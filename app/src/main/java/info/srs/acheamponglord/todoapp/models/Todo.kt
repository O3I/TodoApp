package info.srs.acheamponglord.todoapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class Todo (@PrimaryKey(autoGenerate = true) val uid: Int,
                 val name: String,
                 val description: String?,
                 val isCompleted: Boolean)
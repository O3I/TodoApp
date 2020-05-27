package info.srs.acheamponglord.todoapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo (@PrimaryKey val uid: Int,
                 var name: String,
                 var description: String?,
                 var isCompleted: Boolean)
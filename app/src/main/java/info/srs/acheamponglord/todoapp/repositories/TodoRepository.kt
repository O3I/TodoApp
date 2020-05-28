package info.srs.acheamponglord.todoapp.repositories

import androidx.lifecycle.LiveData
import info.srs.acheamponglord.todoapp.dao.TodoDao
import info.srs.acheamponglord.todoapp.models.Todo

class TodoRepository(private val todoDao: TodoDao) {
    // Getting the live data of all the tasks that will be added to the database
    val todos: LiveData<List<Todo>> = todoDao.getAll()

    suspend fun insert(todo: Todo) {
        todoDao.insert(todo)
    }

}
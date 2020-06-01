package info.srs.acheamponglord.todoapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import info.srs.acheamponglord.todoapp.databinding.ActivityMainBinding
import info.srs.acheamponglord.todoapp.models.Todo
import info.srs.acheamponglord.todoapp.viewmodels.TodoViewModel

class TodoListActivity : AppCompatActivity() {
    private lateinit var todoViewModel: TodoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)


        todoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)



        binding.addTodo.setOnClickListener {
            val intent = Intent(this@TodoListActivity, AddTodoActivity::class.java)
            startActivityForResult(intent, todoRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == todoRequestCode && resultCode == Activity.RESULT_OK) {
            val name = data?.getStringExtra(AddTodoActivity.EXTRA_NAME)
            val description = data?.getStringExtra(AddTodoActivity.EXTRA_DESCRIPTION)
            val todo = name?.let { Todo(0, it, description, false) }
            todo?.let { todoViewModel.insert(todo) }
        }
    }

    companion object {
        private const val todoRequestCode = 1
    }
}

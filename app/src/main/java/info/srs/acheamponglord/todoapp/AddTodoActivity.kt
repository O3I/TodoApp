package info.srs.acheamponglord.todoapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import info.srs.acheamponglord.todoapp.databinding.ActivityAddTodoBinding

class AddTodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAddTodoBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_add_todo)

        val name = binding.name.text.toString()
        val description = binding.description.text.toString()

        binding.save.setOnClickListener {
            val todoIntent = Intent()
            if (name.isEmpty()) {
                Toast.makeText(applicationContext, R.string.empty_todo_name, Toast.LENGTH_LONG)
                    .show()
            } else {
                todoIntent.putExtra(EXTRA_NAME, name)
                todoIntent.putExtra(EXTRA_DESCRIPTION, description)
                setResult(Activity.RESULT_OK, todoIntent)
                finish()
            }
        }

    }

    companion object {
        const val EXTRA_NAME = "info.srs.acheamponglord.todoapp.TODO_NAME"
        const val EXTRA_DESCRIPTION = "info.srs.acheamponglord.todoapp.TODO_DESCRIPTION"
    }
}
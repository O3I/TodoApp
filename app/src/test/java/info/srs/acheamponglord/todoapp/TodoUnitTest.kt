package info.srs.acheamponglord.todoapp

import info.srs.acheamponglord.todoapp.models.Todo
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TodoUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun sameObject_Value() {
        val todo = Todo(
            1, "Go to the grocery store",
            "Buying things like milk,sugar", false
        )
        assertEquals(todo.uid, 1)
        assertEquals(todo.isCompleted, false)
    }
}

package jp.tm.touchapp.repository.todo

import jp.tm.touchapp.model.todo.ToDo
import jp.tm.touchapp.model.todo.ToDoDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoRepositoryImpl(private val dao: ToDoDAO): ToDoRepository {

    override suspend fun create(title: String, detail: String) {
        val now = System.currentTimeMillis()
        val todo = ToDo(title = title, detail = detail, created = now, modified = now)
        withContext(Dispatchers.IO) {
            dao.create(todo)
        }
    }
}
package jp.tm.touchapp.repository.todo

interface ToDoRepository {
    // suspend ってなんだろう・・・
    suspend fun create(title: String, detail: String)
}
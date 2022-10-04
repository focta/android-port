package jp.tm.touchapp.repository.todo

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jp.tm.touchapp.model.todo.ToDo
import jp.tm.touchapp.model.todo.ToDoDAO
import jp.tm.touchapp.model.todo.ToDoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

class ToDoRepositoryImpl @Inject constructor(
    private val dao: ToDoDAO
): ToDoRepository {

    override suspend fun create(title: String, detail: String) {
        val now = System.currentTimeMillis()
        val todo = ToDo(title = title, detail = detail, created = now, modified = now)
        withContext(Dispatchers.IO) {
            dao.create(todo)
        }
    }

    @Module
    @InstallIn(SingletonComponent::class)
    object ToDoModule {

        @Singleton
        @Provides
        fun provideToDoDatabase(
            @ApplicationContext context: Context
        ): ToDoDatabase {
            return Room.databaseBuilder(
                context,
                ToDoDatabase::class.java,
                "todo.db"
            ).build()
        }

        @Singleton
        @Provides
        fun provideToDoDAO(db: ToDoDatabase): ToDoDAO {
            return db.todoDAO()
        }
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class ToDoRepositoryModule {
    @Singleton
    @Binds
    abstract fun bindToDoRepository(impl: ToDoRepositoryImpl): ToDoRepository
}
package com.compose.data.di

import android.app.Application
import com.compose.data.repoimpl.ToDoRepoImpl
import com.compose.data.source.local.*
import com.compose.domain.repos.ToDoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun providesRoomDatabase(application: Application): ToDoDatabase =
        DatabaseProperties.getInstance(application)

    @Provides
    fun provideToDoRepository(localDataSource: ToDoLocalDataSource): ToDoRepository = ToDoRepoImpl(localDataSource)

    @Provides
    fun provideToDoDao(toDoDatabase: ToDoDatabase): ToDoEntityDao = toDoDatabase.toDoDao()

    @Provides
    fun provideLocalSource(toDoEntityDao: ToDoEntityDao): ToDoLocalDataSource =
        ToDoLocalSourceImpl(toDoEntityDao)
}
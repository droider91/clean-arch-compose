package com.compose.domain.di

import com.compose.domain.repos.ToDoRepository
import com.compose.domain.usecase.AddToDoUseCase
import com.compose.domain.usecase.GetAllToDoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideToDoUseCase(toDoRepository: ToDoRepository): AddToDoUseCase =
        AddToDoUseCase(toDoRepository)

    @Provides
    fun provideGetAllToDoCase(toDoRepository: ToDoRepository): GetAllToDoUseCase =
        GetAllToDoUseCase(toDoRepository)
}
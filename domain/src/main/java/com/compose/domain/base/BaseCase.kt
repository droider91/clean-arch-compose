package com.compose.domain.base

import com.compose.domain.repos.ToDoRepository
import javax.inject.Inject


interface BaseCase<Request : Any?, Response> {
    suspend fun invoke(any: Request): Response
}
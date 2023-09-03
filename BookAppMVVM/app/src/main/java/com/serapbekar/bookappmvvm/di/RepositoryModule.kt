package com.serapbekar.bookappmvvm.di

import com.serapbekar.bookappmvvm.data.repository.BooksRepository
import com.serapbekar.bookappmvvm.data.source.remote.BookService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideBookRepository(bookService: BookService) : BooksRepository = BooksRepository(bookService)
}
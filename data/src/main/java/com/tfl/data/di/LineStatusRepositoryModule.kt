package com.tfl.data.di

import com.tfl.data.repository.LineStatusRepositoryImpl
import com.tfl.domain.repository.LineStatusRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class LineStatusRepositoryModule {

    @Binds
    abstract fun bindLineStatusRepo(lineStatusRepositoryImpl: LineStatusRepositoryImpl): LineStatusRepository
}

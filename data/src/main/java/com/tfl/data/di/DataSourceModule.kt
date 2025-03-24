package com.tfl.data.di

import com.tfl.data.repository.source.LineStatusDataSource
import com.tfl.data.repository.source.LineStatusDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindLineStatusMapDataSource(lineStatusDataSourceImpl: LineStatusDataSourceImpl):
            LineStatusDataSource
}
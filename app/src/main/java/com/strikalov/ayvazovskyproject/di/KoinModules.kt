package com.strikalov.ayvazovskyproject.di

import android.arch.persistence.room.Room
import com.strikalov.ayvazovskyproject.model.database.AppDatabase
import com.strikalov.ayvazovskyproject.model.interactors.PictureInteractor
import com.strikalov.ayvazovskyproject.model.interactors.PictureInteractorImpl
import com.strikalov.ayvazovskyproject.model.network.AyvazovskyApi
import com.strikalov.ayvazovskyproject.model.repositories.DatabaseRepository
import com.strikalov.ayvazovskyproject.model.repositories.DatabaseRepositoryImpl
import com.strikalov.ayvazovskyproject.model.repositories.NetworkRepository
import com.strikalov.ayvazovskyproject.model.repositories.NetworkRepositoryImpl
import com.strikalov.ayvazovskyproject.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module{
    single { Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "database").build() }
    single { AyvazovskyApi() }
    single<NetworkRepository> { NetworkRepositoryImpl(get())}
    single<DatabaseRepository> { DatabaseRepositoryImpl(get()) }
    single<PictureInteractor> { PictureInteractorImpl(get(), get())}
    viewModel { MainViewModel(get()) }
}
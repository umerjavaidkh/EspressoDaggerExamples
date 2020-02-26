package com.codingwithmitch.espressodaggerexamples.di

import android.app.Application
import com.codingwithmitch.espressodaggerexamples.api.ApiService
import com.codingwithmitch.espressodaggerexamples.api.FakeApiService
import com.codingwithmitch.espressodaggerexamples.repository.FakeMainRepositoryImpl
import com.codingwithmitch.espressodaggerexamples.repository.MainRepository
import com.codingwithmitch.espressodaggerexamples.ui.*
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
@Singleton
@Component(modules = [
    FragmentModule::class,
    TestViewModelModule::class,
    TestRepositoryModule::class,
    TestAppModule::class
])
interface TestAppComponent: AppComponent {

    val apiService: FakeApiService

    val mainRepository: FakeMainRepositoryImpl

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): TestAppComponent
    }

    fun inject(listFragmentTest: ListFragmentTests)

    fun inject(detailFragmentTest: DetailFragmentTest)

    fun inject(finalFragmentTest: FinalFragmentTest)

    fun inject(listFragmentErrorTests: ListFragmentErrorTests)

    fun inject(mainActivityIntegrationTests: MainActivityIntegrationTests)

}















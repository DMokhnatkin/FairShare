package com.example.fairshare.auth.signin

import com.example.fairshare.dagger.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class)])
interface SignInComponent {
    fun inject(fragment: SignInComponent)
}
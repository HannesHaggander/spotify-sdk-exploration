package com.towerowl.spotifytest.dagger

import com.towerowl.spotifytest.SpotifySDK
import com.towerowl.spotifytest.dagger.modules.ContextModule
import com.towerowl.spotifytest.dagger.modules.SpotifyModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, SpotifyModule::class])
interface AppComponent {
    fun spotifySdk(): SpotifySDK
}
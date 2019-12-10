package com.towerowl.spotifytest.dagger.modules

import com.towerowl.spotifytest.SpotifySDK
import dagger.Module
import dagger.Provides

@Module
class SpotifyModule {
    @Provides
    fun provideSpotifySDK(): SpotifySDK = SpotifySDK()
}
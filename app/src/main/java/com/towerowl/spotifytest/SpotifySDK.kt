package com.towerowl.spotifytest

import android.content.Context
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote

class SpotifySDK {
    fun auth(
        context: Context,
        onSuccess: (SpotifyAppRemote) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        SpotifyAppRemote.connect(context,
            ConnectionParams.Builder(context.getString(R.string.spotify_client_id))
                .setRedirectUri(context.getString(R.string.spotify_redirect_uri))
                .build(),
            object : Connector.ConnectionListener {
                override fun onFailure(error: Throwable?) {
                    onError(error)
                }

                override fun onConnected(spotifyAppRemote: SpotifyAppRemote?) {
                    spotifyAppRemote?.let(onSuccess)
                        ?: throw RuntimeException("Connected without spotify app remote")
                }
            })
    }
}
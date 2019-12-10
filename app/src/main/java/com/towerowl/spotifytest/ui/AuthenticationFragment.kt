package com.towerowl.spotifytest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.towerowl.spotifytest.App
import com.towerowl.spotifytest.R
import kotlinx.android.synthetic.main.fragment_authentication.*

class AuthenticationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.fragment_authentication, container, false).let {
            return it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authentication_auth_button.setOnClickListener {
            App.getInstance().appComponent.spotifySdk().auth(
                requireContext(),
                { findNavController().navigate(R.id.navigation_recommendation) },
                {
                    authentication_error_text.text =
                        it?.message ?: getString(R.string.unknown_error)
                }
            )
        }
    }
}
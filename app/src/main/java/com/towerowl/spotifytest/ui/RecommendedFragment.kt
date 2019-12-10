package com.towerowl.spotifytest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.towerowl.spotifytest.App
import com.towerowl.spotifytest.R

class RecommendedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.fragment_recommended, container, false).let {
            return it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.getInstance().appComponent.spotifySdk().auth(requireContext(),
            {
                true
            }, {
                false
            })
    }
}
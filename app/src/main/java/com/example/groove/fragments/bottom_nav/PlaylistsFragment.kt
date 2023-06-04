package com.example.groove.fragments.bottom_nav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.groove.R
import com.example.groove.databinding.FragmentPlaylistsBinding

class PlaylistsFragment : Fragment(R.layout.fragment_playlists) {

    private lateinit var binding: FragmentPlaylistsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding  = FragmentPlaylistsBinding.inflate(inflater, container, false)

        return binding.root
    }


}
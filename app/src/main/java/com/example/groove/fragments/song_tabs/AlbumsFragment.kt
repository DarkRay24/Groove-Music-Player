package com.example.groove.fragments.song_tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.groove.R
import com.example.groove.databinding.FragmentArtistsBinding

class AlbumsFragment : Fragment(R.layout.fragment_albums) {

    private lateinit var binding: FragmentArtistsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArtistsBinding.inflate(inflater, container, false)

        return binding.root
    }
}
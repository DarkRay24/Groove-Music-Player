package com.example.groove.fragments.song_tabs

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.groove.R
import com.example.groove.activities.MainActivity
import com.example.groove.adapter.ArtistAdapter
import com.example.groove.databinding.FragmentArtistsBinding
import com.example.groove.viewmodel.MainSongViewModel

class ArtistsFragment : Fragment(R.layout.fragment_artists) {

    private lateinit var binding: FragmentArtistsBinding
    private lateinit var artistAdapter: ArtistAdapter

    private lateinit var mainSongViewModel: MainSongViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArtistsBinding.inflate(inflater, container, false)

        mainSongViewModel = (activity as MainActivity).mainSongViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareArtistsRecyclerView()
        observeArtistHashMapLiveData()
        onArtistItemClick()
    }


    private fun prepareArtistsRecyclerView() {
        artistAdapter = ArtistAdapter()
        binding.rvArtists.apply {
            layoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
            adapter = artistAdapter
            setHasFixedSize(true)
        }
    }

    private fun observeArtistHashMapLiveData() {

        mainSongViewModel.observeArtistHashMapLiveData().observe(viewLifecycleOwner, Observer {
            binding.tvNoSongs.visibility = View.INVISIBLE  // -> Hiding No Songs Text

            artistAdapter.differ.submitList(it.values.toList())
        })
    }

    private fun onArtistItemClick() {
        artistAdapter.onItemClick = { artistTitle ->
            val mFrag: Fragment = ArtistSongsFragment.newInstance(artistTitle)
            replaceFragment(mFrag)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.commit {

//            setCustomAnimations(
//                R.anim.slide_up,  // -> enter
//                R.anim.fade_out,  // -> exit
//                R.anim.fade_in,  // -> pop enter
//                R.anim.slide_down  // -> pop exit
//            )

            replace(R.id.nav_host_fragment_container, fragment)
            addToBackStack(null)
        }


    }



}
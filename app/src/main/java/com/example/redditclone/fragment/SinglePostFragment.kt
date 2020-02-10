package com.example.redditclone.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.redditclone.R
import com.example.redditclone.databinding.FragmentSinglePostBinding
import com.example.redditclone.viewmodel.HomeViewModel

/**
 * Created by aizat on 10/2/2020
 */

class SinglePostFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSinglePostBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_single_post, container, false
        )
        binding.lifecycleOwner = this

        val viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.addBundle(arguments)
        viewModel.getTopicFromRepo()

        binding.viewmodel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as? AppCompatActivity)?.supportActionBar?.title =
            getString(R.string.popular_topic)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
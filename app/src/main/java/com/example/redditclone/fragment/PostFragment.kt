package com.example.redditclone.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.redditclone.R
import com.example.redditclone.databinding.FragmentPostBinding
import com.example.redditclone.viewmodel.PostViewModel

/**
 * Created by aizat on 10/2/2020
 */

class PostFragment : Fragment() {

    private var viewModel: PostViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentPostBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_post, container, false
        )
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(PostViewModel::class.java)

        binding.viewmodel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as? AppCompatActivity)?.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_clear_24px)
        (activity as? AppCompatActivity)?.supportActionBar?.title = getString(R.string.text_post)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_post, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                return true
            }
            R.id.action_post -> {
                if (viewModel?.title.isNullOrEmpty()) {
                    Toast.makeText(requireContext(), R.string.title_empty_error, Toast.LENGTH_LONG)
                        .show()
                    return false
                }
                viewModel?.postTopic()
                activity?.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
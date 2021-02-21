package com.example.super_hero.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.super_hero.HeroViewModel
import com.example.super_hero.R
import com.example.super_hero.databinding.FragmentFirstBinding
import com.example.super_hero.remote.HeroAdapter


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel:HeroViewModel by activityViewModels()


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter=HeroAdapter()
        binding.rvHero.adapter =adapter
        binding.rvHero.layoutManager= LinearLayoutManager(context)

        viewModel.getHeroList().observe(viewLifecycleOwner, Observer {
            it?.let{
                Log.d("base", "$it")
                adapter.update(it)

            }
        })

        adapter.selectedItem().observe(viewLifecycleOwner, Observer {
            it?.let {
                viewModel.getHeroList()
                val bundle= Bundle()
                bundle.putInt("id", it.id)
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)

            }
        })

    }
}
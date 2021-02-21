package com.example.super_hero.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.super_hero.HeroViewModel
import com.example.super_hero.R
import com.example.super_hero.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private val viewModel: HeroViewModel by activityViewModels()
    private var idHero: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idHero = it.getInt("id", -1)

        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getHeroById(idHero).observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.tvName2.text =it.name
                binding.tvFullName2.text= it.fullName
                binding.tvAlias2.text=it.aliases
                Glide.with(binding.image2).load(it.images).into(binding.image2)


            }

        })
        binding.punisher.setOnClickListener{
            findNavController().navigate(R.id.action_SecondFragment_to_mailFragment)
        }
    }
}








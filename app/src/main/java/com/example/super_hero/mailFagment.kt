package com.example.super_hero

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.super_hero.databinding.FragmentMailBinding

class mailFagment: Fragment()  {




        private lateinit var binding: FragmentMailBinding

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentMailBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            var mail="mail@mail.com"
            binding.tvcorreo.setText(mail)
            var asunto=""
            binding.tvasunto.toString()
            var descripcion=""
            binding.tvdescripcion.toString()



            binding.buttonenviar.setOnClickListener{
                sedMessage(mail,asunto,descripcion )
            }
        }

        private fun sedMessage(mail:String,asunto:String,descripcion:String) {
            val intent = Intent(Intent.ACTION_SEND)
            intent.data = Uri.parse("mailto:")
            intent.type = "text/plain"

            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(mail))
            intent.putExtra(Intent.EXTRA_SUBJECT, asunto)
            intent.putExtra(Intent.EXTRA_TEXT, descripcion)
        }
    }




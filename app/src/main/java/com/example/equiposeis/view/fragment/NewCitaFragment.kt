package com.example.equiposeis.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.equiposeis.R
import com.google.android.material.appbar.MaterialToolbar

class NewCitaFragment : Fragment(R.layout.fragment_new_cita) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbarNewCita)
        toolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_newCita_to_home)
        }
    }
}

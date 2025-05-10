package com.example.equiposeis.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.equiposeis.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflamos el layout usando DataBinding
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        // Configuramos el click sobre la animación de la huella dactilar
        binding.lottieView.setOnClickListener {
            // Acción al tocar la huella
            Toast.makeText(requireContext(), "Huella detectada", Toast.LENGTH_SHORT).show()

            // Aquí puedes realizar otra lógica, como navegar o validar usuario
            // Por ejemplo: findNavController().navigate(R.id.action_login_to_home)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

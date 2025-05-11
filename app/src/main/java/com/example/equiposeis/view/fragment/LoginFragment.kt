package com.example.equiposeis.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.equiposeis.databinding.FragmentLoginBinding
import java.util.concurrent.Executor

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Infla el layout usando ViewBinding
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ejemplo de configuración de BiometricPrompt
        val executor: Executor = ContextCompat.getMainExecutor(requireContext())
        val biometricPrompt = BiometricPrompt(this, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    Toast.makeText(requireContext(), "Autenticación exitosa", Toast.LENGTH_SHORT).show()
                }
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    Toast.makeText(requireContext(), "Error: $errString", Toast.LENGTH_SHORT).show()
                }
                override fun onAuthenticationFailed() {
                    Toast.makeText(requireContext(), "Autenticación fallida", Toast.LENGTH_SHORT).show()
                }
            })

        binding.btnFingerprint.setOnClickListener {
            val promptInfo = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Autenticación con Biometría")
                .setSubtitle("Ingrese su huella digital")
                .setNegativeButtonText("Cancelar")
                .build()
            biometricPrompt.authenticate(promptInfo)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


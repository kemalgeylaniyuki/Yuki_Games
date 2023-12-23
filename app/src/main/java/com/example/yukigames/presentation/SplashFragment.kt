package com.example.yukigames.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yukigames.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    //@Inject
    //lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val view = binding.root

        /*
        Handler(Looper.getMainLooper()).postDelayed({

            if (sessionManager.getIsFirstRun()){
                findNavController().navigate(R.id.action_splashFragment_to_appIntroFragment)
            }
            else {
                findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
            }


        }, 3000)

         */

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
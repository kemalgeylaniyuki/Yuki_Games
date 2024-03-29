package com.example.yukigames.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<VB: ViewBinding, VM: ViewModel> : Fragment() {

    open var useSharedViewModel : Boolean = false
    protected lateinit var viewModel : VM
    protected abstract fun getViewModelClass() : Class<VM>

    private var _binding: VB? = null
    protected val binding get() = _binding!!
    protected abstract fun getViewBinding() : VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        observeViewModel()
    }

    abstract fun setUpViews()

    abstract fun observeViewModel()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun init(){
        _binding = getViewBinding()
        viewModel = if (useSharedViewModel){
            ViewModelProvider(requireActivity())[getViewModelClass()]
        }
        else{
            ViewModelProvider(this)[getViewModelClass()]
        }
    }

}
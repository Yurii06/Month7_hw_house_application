package com.geektech.month7_hw.presentation.door

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.geektech.month7_hw.databinding.FragmentDoorBinding
import com.geektech.month7_hw.presentation.utils.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DoorFragment : Fragment() {
    private lateinit var binding: FragmentDoorBinding
    private val adapter = DoorAdapter()
    private val doorViewModel: DoorViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDoorBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
        getDoorsData()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getDoorsData() {
        doorViewModel.getAllDoors()
        lifecycleScope.launch {
            doorViewModel.doorsList.collect{state ->
                when(state) {
                    is UIState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.recyclerView.visibility = View.GONE
                    }
                    is UIState.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.recyclerView.visibility = View.VISIBLE
                        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
                        binding.recyclerView.adapter = adapter
                        adapter.notifyDataSetChanged()
                        adapter.setList(state.data!!)
                    }
                    is UIState.Empty -> {
                        binding.progressBar.visibility = View.GONE
                    }
                    is UIState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
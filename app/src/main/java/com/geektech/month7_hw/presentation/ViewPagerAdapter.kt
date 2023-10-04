package com.geektech.month7_hw.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.geektech.month7_hw.presentation.camera.CameraFragment
import com.geektech.month7_hw.presentation.door.DoorFragment
import com.geektech.month7_hw.presentation.favourite.FavouritesFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CameraFragment()
            1 -> DoorFragment()
            2 -> FavouritesFragment()
            else -> Fragment()
        }
    }
}
package com.geektech.month7_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektech.month7_hw.databinding.ActivityMainBinding
import com.geektech.month7_hw.presentation.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()

        val arrayNumbers = listOf<Int>(1,2,3,4,5,6)
        arrayNumbers.filter { it % 2 == 0 }
        val a = 0.0f
        arrayNumbers.map {
            9
        }
    }

    private fun initViews() {
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        val toolbar = binding.toolbar
        viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = CAMERA_TITLE
                1 -> tab.text = DOOR_TITLE
                2 -> tab.text = FAVOURITES_TITLE
            }
        }.attach()

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.toolbarTitle.text = TOOLBAR_TITLE
    }

    companion object {
        const val CAMERA_TITLE = "Камеры"
        const val DOOR_TITLE = "Двери"
        const val FAVOURITES_TITLE = "Избранные"
        const val TOOLBAR_TITLE = "Мой дом"
    }
}
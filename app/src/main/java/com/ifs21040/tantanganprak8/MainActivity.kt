package com.ifs21040.tantanganprak8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21040.tantanganprak8.R
import com.ifs21040.tantanganprak8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()
    }



    private fun setupView() {
        binding.navView.setCheckedItem(R.id.nav_allmess)

        binding.inAppBar.toolbar.overflowIcon =
            ContextCompat.getDrawable(this, R.drawable.ic_more_vert)
        loadFragment(FLAG_FRAGMENT_HOME)
    }

    private fun setupAction() {
        binding.inAppBar.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        binding.inAppBar.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_profile -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Memilih menu Add!")
                    true
                }

//                R.id.action_settings -> {
//                    loadFragment(FLAG_FRAGMENT_HOME, "Memilih menu Settings!")
//                    true
//                }

                R.id.action_logout -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Memilih menu Logout!")
                    true
                }

                else -> true
            }
        }

        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_allmess -> {
                    loadFragment(FLAG_FRAGMENT_HOME)
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_main -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Memilih menu Profile!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_promosi -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Memilih menu Notes!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_social -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Memilih menu Notes!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_bintang -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Memilih menu Notes!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_ditunda -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Memilih menu Notes!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_send -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Memilih menu Notes!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.draft -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Memilih menu Notes!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.spam -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Memilih menu Notes!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.sampah -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Memilih menu Notes!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.kalendar -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Memilih menu Notes!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.kontak -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Memilih menu Notes!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.setelan -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Memilih menu Notes!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.bantuan -> {
                    loadFragment(FLAG_FRAGMENT_HOME, "Memilih menu Notes!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }



                else -> true
            }
        }


    }
    private fun loadFragment(flag: String, message: String? = null) {
        val fragmentManager = supportFragmentManager
        val fragmentContainerId =
            binding.inAppBar.inContentMain.frameContainer.id

        when (flag) {
            FLAG_FRAGMENT_DASHBOARD -> {
                val dashboardFragment = DashboardFragment()
                val fragment = fragmentManager
                    .findFragmentByTag(DashboardFragment::class.java.simpleName)

                if (fragment !is DashboardFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            dashboardFragment,
                            DashboardFragment::class.java.simpleName
                        )
                        .commit()
                }
            }

        }

    }


    companion object {
        const val FLAG_FRAGMENT_HOME = "fragment_home"
        const val FLAG_FRAGMENT_DASHBOARD = "fragment_dashboard"
    }
}
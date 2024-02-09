package com.example.randomdemoday.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.randomdemoday.databinding.ActivityMainBinding
import com.example.randomdemoday.remote.model.MainResponseItem
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    private lateinit var adapter: UsersAdapter
    private val list = arrayListOf<MainResponseItem>()
    private var selectedImage: String? = null
    private var selectedName: String? = null
    private var selectedLevel: String? = null
    private var randomSelectionHandler: Handler? = null
    private var randomSelectionRunnable: Runnable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        launchData()
        constructListeners()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun constructListeners() {
        binding.btnRandom.setOnClickListener {
            startRandomSelection()
            Handler(Looper.getMainLooper()).postDelayed({
                stopRandomSelection()
                selectRandomImage()
                showSelectedImageDialog()
                adapter.notifyDataSetChanged()
            }, 2000)
        }
    }

    private fun showSelectedImageDialog() {
        selectedImage?.let {
            selectedName?.let { it1 ->
                selectedLevel?.let { it2 ->
                    WinnerDialogFragment(it, it1, it2).show(
                        supportFragmentManager,
                        ""
                    )
                }
            }
        }
    }

    private fun selectRandomImage() {
        val randomIndex = Random.nextInt(list.size)
        selectedImage = list[randomIndex].image
        selectedName = list[randomIndex].name
        selectedLevel = list[randomIndex].target
        adapter.setSelectedImage(selectedImage)
    }

    private fun stopRandomSelection() {
        randomSelectionHandler?.removeCallbacks(randomSelectionRunnable!!)
        randomSelectionHandler = null
        randomSelectionRunnable = null
    }

    private fun startRandomSelection() {
        randomSelectionHandler = Handler(Looper.getMainLooper())
        randomSelectionRunnable = object : Runnable {
            override fun run() {
                toggleImageBackground()
                randomSelectionHandler?.postDelayed(this, 200)
            }
        }
        randomSelectionHandler?.postDelayed(randomSelectionRunnable!!, 200)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun toggleImageBackground() {
        val randomIndex = Random.nextInt(list.size)
        selectedImage = list[randomIndex].image
        adapter.setSelectedImage(selectedImage)
        adapter.notifyDataSetChanged()
    }


    private fun launchData() {
        viewModel.getUsers()
        viewModel.liveData.observe(this) {
            adapter = UsersAdapter(it)
            binding.rvUsers.adapter = adapter
            list.addAll(it)
        }
    }
}
package com.example.foodapp2.client

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.foodapp2.R
import com.example.foodapp2.databinding.ActivityClientBinding
import com.example.foodapp2.foodlist.FoodListFragment
import com.example.foodapp2.foodlist.YourFoodFragment
import com.example.foodapp2.login.LoginActivity

class ClientActivity : AppCompatActivity() {
    private lateinit var binding : ActivityClientBinding
    private val clientViewModel by viewModels<ClientViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_client)
        binding.clientViewModel = clientViewModel
        observerEvent()
        createFragment()
    }

//    private fun intListener() {
//        val binding: ActivityClientBinding =
//            DataBindingUtil.setContentView(this, R.layout.activity_client)
//        binding.atv3ImgBack.setOnClickListener {
//            intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }
//        binding.avt3ImgHistory.setOnClickListener {
//            intent = Intent(this, ClientHistoryActivity::class.java)
//            startActivity(intent)
//        }
//    }
    private fun observerEvent(){
        clientViewModel.isBack.observe(this){
            it.getContentIfNotHandled()?.let{
                intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    clientViewModel.navigateToHistory.observe(this){
        it.getContentIfNotHandled()?.let{
            intent = Intent(this, ClientHistoryActivity::class.java)
            startActivity(intent)
        }
    }

    }

    private fun createFragment() {
        val fragmentOne = FoodListFragment()
        val fragmentTwo = YourFoodFragment()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.foodFragOne, fragmentOne)
        fragmentTransaction.add(R.id.foodFragTwo, fragmentTwo)
        fragmentTransaction.commit()
    }
}
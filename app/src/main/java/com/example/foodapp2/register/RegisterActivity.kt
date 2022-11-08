package com.example.foodapp2.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.foodapp2.R
import com.example.foodapp2.database.Database
import com.example.foodapp2.databinding.ActivityRegisterBinding
import com.example.foodapp2.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    private var username: String = ""
    private var password: String = ""
    private var repeatPassword: String = ""
    private lateinit var binding: ActivityRegisterBinding
    private val registerViewModel by viewModels<RegisterViewModel>()
    private val database by lazy { Database.getInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        binding.registerViewModel = registerViewModel
        observeEvent()

    }

    private fun observeEvent() {
        registerViewModel.username.observe(this, Observer {
            username = it
        })
//        Toast.makeText(this, username, Toast.LENGTH_SHORT).show()
//        registerViewModel.register.observe(this, Observer {
//            it.getContentIfNotHandled()?.let {

//                registerViewModel.password.observe(this, Observer {
//                    password = it
//                })
//                registerViewModel.repeatPassword.observe(this, Observer {
//                    repeatPassword = it
//                })
//                if (!database.isUsernameExists(username)) {
//                    if (password == repeatPassword) {
//                        database.insertIntoUsers(username, password)
//                        intent = Intent(this, LoginActivity::class.java)
//                        startActivity(intent)
//                    } else {
//                        Toast.makeText(this, "Nhắc lại mật khẩu chưa đúng!", Toast.LENGTH_SHORT)
//                            .show()
//                    }
//                } else {
//                    Toast.makeText(this, "Tên tài khoản đã tồn tại!", Toast.LENGTH_SHORT).show()
//                }
 //         }
   //     })
        registerViewModel.isBack.observe(this) {
            it.getContentIfNotHandled()?.let {
                intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }

    }

//    private fun initListener() {
//        binding.registerImgBack.setOnClickListener {
//            intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }
//        binding.registerBtnRegister.setOnClickListener {
//            val username = binding.registerEdtUsername.text.toString()
//            val password = binding.registerEdtPassword.text.toString()
//            val repeatPassword = binding.registerEdtRepeatPassword.text.toString()
//            if (!database.isUsernameExists(username)) {
//                if (password == repeatPassword) {
//                    database.insertIntoUsers(username, password)
//                    intent = Intent(this, LoginActivity::class.java)
//                    startActivity(intent)
//                } else {
//                    Toast.makeText(this, "Nhắc lại mật khẩu chưa đúng!", Toast.LENGTH_SHORT).show()
//                }
//            } else {
//                Toast.makeText(this, "Tên tài khoản đã tồn tại!", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
}
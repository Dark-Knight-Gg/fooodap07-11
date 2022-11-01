package com.example.foodapp2.login

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.foodapp2.R
import com.example.foodapp2.admin.AdminActivity
import com.example.foodapp2.database.Database
import com.example.foodapp2.databinding.ActivityLoginBinding
import com.example.foodapp2.register.RegisterActivity
import com.example.foodapp2.viewmodel.LoginViewModel


class LoginActivity : AppCompatActivity() {
    private val loginViewModel by viewModels<LoginViewModel>()
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val database by lazy { Database.getInstance(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.loginViewModel = loginViewModel
        sharedPreferences = getSharedPreferences("Data", MODE_PRIVATE)
        loginViewModel.user.observe(this, Observer {
                val username = it.username
                val password = it.password
                if (username == "Admin" && password == "admin123") {
                    intent = Intent(this, AdminActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Sai thông tin đăng nhập!", Toast.LENGTH_SHORT).show()
                }
        })
        loginViewModel.flag.observe(this, Observer{
            if(it){
                intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        })
        bindData()
        loginViewModel.checked.observe(this,Observer{
            if(it){
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    val username = binding.loginEdtUsername.text.toString()
                    val password = binding.loginEdtPassword.text.toString()
                    editor.putString("Username", username)
                    editor.putString("Password", password)
                    editor.putBoolean("Checked", true)
                    editor.apply()
                 } else {
                        val editor: SharedPreferences.Editor = sharedPreferences.edit()
                        editor.remove("Username")
                        editor.remove("Password")
                        editor.remove("Checked")
                        editor.apply()
                    }
        })
    }
    //    private lateinit var binding: ActivityLoginBinding
//    private val sharedPreferences: SharedPreferences by lazy {
//        getSharedPreferences(
//            "Data",
//            MODE_PRIVATE
//        )
//    }
//    private val database by lazy { Database.getInstance(this) }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
//        bindData()
//        initListener()
//    }
//
    private fun bindData() {
        binding.apply {
            val userName = sharedPreferences.getString("Username", "")
            val password = sharedPreferences.getString("Password", "")
            val isChecked = sharedPreferences.getBoolean("Checked", false)
            loginEdtUsername.setText(userName)
            loginEdtPassword.setText(password)
            loginCheckbox.isChecked = isChecked
        }
    }
//
//    private fun initListener() {
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
//        binding.apply {
//            loginBtnRegister.setOnClickListener {
//                intent = Intent(this@LoginActivity, RegisterActivity::class.java)
//                startActivity(intent)
//            }
//            loginBtnLogin.setOnClickListener {
//                val username = loginEdtUsername.text.toString()
//                val password = loginEdtPassword.text.toString()
//                val flag: Boolean = database.isLogin(User(username, password))
//                if (username == "Admin" && password == "admin123") {
//                    intent = Intent(this@LoginActivity, AdminActivity::class.java)
//                    startActivity(intent)
//                    return@setOnClickListener
//                }
//                if (flag) {
//                    if (loginCheckbox.isChecked) {
//                        val editor: SharedPreferences.Editor = sharedPreferences.edit()
//                        editor.putString("Username", username)
//                        editor.putString("Password", password)
//                        editor.putBoolean("Checked", true)
//                        editor.apply()
//                    } else {
//                        val editor: SharedPreferences.Editor = sharedPreferences.edit()
//                        editor.remove("Username")
//                        editor.remove("Password")
//                        editor.remove("Checked")
//                        editor.apply()
//                    }
//                    Toast.makeText(this@LoginActivity, "Đăng nhập thành công!", Toast.LENGTH_SHORT)
//                        .show()
//                    intent = Intent(this@LoginActivity, ClientActivity::class.java)
//                    startActivity(intent)
//                    return@setOnClickListener
//                }
//                Toast.makeText(
//                    this@LoginActivity,
//                    "Sai tên đăng nhập hoặc mật khẩu!",
//                    Toast.LENGTH_SHORT
//                )
//                    .show()
//            }
//        }
//
//    }


    //    override fun getBindingVariable(): Int = BR.loginViewModel
//
//    override fun getViewModel(): LoginViewModel {
//        return ViewModelProvider(this)[LoginViewModel::class.java]
//    }
//
//    override fun init() {
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(getLayoutId())
//        login()
//    }
//    override fun getLayoutId(): Int {
//        return R.layout.activity_login
//    }
//    private fun login() {
//        val username = loginViewModel.user.value?.username
//        val password = loginViewModel.user.value?.password
//        if (username == "Admin" && password == "admin123") {
//            intent = Intent(this, AdminActivity::class.java)
//            startActivity(intent)
//        } else {
//            Toast.makeText(this, "Sai thông tin đăng nhập!", Toast.LENGTH_SHORT).show()
//        }
//    }
}
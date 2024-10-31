package com.example.aboutme

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import com.example.aboutme.myName
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var myName= myName(name="Jagdish Samant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener{
            this.addName(it)
        }
    }

    fun addName(view: View){
//        binding.nameText.text = binding.userName.text
        binding.myName.nickName = binding.userName.text.toString()
        binding.invalidateAll()
        binding.userName.visibility = View.GONE
        binding.doneButton.visibility = View.GONE
        binding.nameText.visibility = View.VISIBLE
        this.hideKeyboard()
    }

    fun hideKeyboard(){
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}
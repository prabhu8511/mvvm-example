package com.example.viewmodelscopedemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.viewmodelscopedemo.R
import com.example.viewmodelscopedemo.viewmodel.MainActivityViewModelScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: MainActivityViewModelScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel = ViewModelProvider(this).get(MainActivityViewModelScope::class.java)
        //mViewModel.getUser()

        lifecycleScope.launch{
            delay(8000L)
            progressBar.visibility = View.GONE
        }


        mViewModel.users.observe(this, Observer { userList ->
            val data = StringBuilder()
            userList.forEach {
                data.append("id:${it.id}   name: ${it.name} \n\n");
            }
            tv.text = data.toString()

        })

    }
}

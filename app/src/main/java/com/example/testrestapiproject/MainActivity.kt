package com.example.testrestapiproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Credentials

class MainActivity : AppCompatActivity() {
    lateinit var BranchlistView:ListView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       BranchlistView = findViewById<ListView>(R.id.branch_listview)
    }

    override fun onStart() {
        super.onStart()



        BarchCodeApiCalling.create().getUser()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                    result ->

                BranchlistView.adapter = result.branch_List?.let { BranchAdapter(this , it) }

            }
    }



}
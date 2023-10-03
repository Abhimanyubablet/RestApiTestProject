package com.example.testrestapiproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchAllBranchActivity : AppCompatActivity() {
    lateinit var branchSearchAlllistView:ListView
    lateinit var branchCode:String
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_all_branch)

       branchCode= intent.extras?.getString("bcode").toString()

        branchSearchAlllistView = findViewById(R.id.branch_searchall_listview)

    }

    override fun onStart() {
        super.onStart()

        BarchCodeApiCalling.create().searchBranchByCode(branchCode)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                    result ->

                if (result.branch_List != null){
                   var branchAdapter = BranchSearchAllAdapter(this , result.branch_List
                    )
                    branchSearchAlllistView.adapter = branchAdapter
                    branchAdapter.notifyDataSetChanged()
                }


            }
    }

}
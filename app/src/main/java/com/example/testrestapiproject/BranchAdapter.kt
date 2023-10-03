package com.example.testrestapiproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class BranchAdapter(val context: Context, val dataList:List<PlanCodeList>):BaseAdapter() {
    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(position: Int): Any {
        return dataList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = LayoutInflater.from(context).inflate(R.layout.branch_code, parent, false)
        val data = dataList[position]
        rowView.setOnClickListener {
            val searchPage=Intent(context,SearchAllBranchActivity::class.java)
            searchPage.putExtra("bcode",data.bcode.toString())
            context.startActivity(searchPage)

        }

        val branchCode = rowView.findViewById<TextView>(R.id.branch_code)
        val branchName = rowView.findViewById<TextView>(R.id.branch_name)
        val branchAddress = rowView.findViewById<TextView>(R.id.branch_address)
        val branchPrefix = rowView.findViewById<TextView>(R.id.branch_prefix)
        branchCode.setText(data.bcode)
        return rowView
    }
}
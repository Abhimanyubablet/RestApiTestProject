package com.example.testrestapiproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class BranchSearchAllAdapter(val context: Context, val dataList:List<PlanCodeList>):BaseAdapter() {
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
        val rowView = LayoutInflater.from(context).inflate(R.layout.branch_code_list, parent, false)
        val data = dataList[position]

        val branchCode = rowView.findViewById<TextView>(R.id.branch_code)
        val branchName = rowView.findViewById<TextView>(R.id.branch_name)
        val branchAddress = rowView.findViewById<TextView>(R.id.branch_address)
        val branchPrefix = rowView.findViewById<TextView>(R.id.branch_prefix)
        branchCode.setText(data.bcode)
        branchName.setText(data.bname)
        branchAddress.setText(data.address)
        branchPrefix.setText(data.prefix)

        return rowView
    }
}
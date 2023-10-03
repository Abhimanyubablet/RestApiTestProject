package com.example.testrestapiproject

import com.google.gson.annotations.SerializedName


data class Branch(
    @SerializedName("Error_Code")
    val errorCode: Long,
    @SerializedName("PlanCode_List")
    val planCodeList: List<PlanCodeList>?,
    @SerializedName("Branch_List")
    val branch_List: List<PlanCodeList>?,

)

data class PlanCodeList(
    @SerializedName("BCode")
    val bcode: String,
    @SerializedName("BName")
    val bname: String,
    @SerializedName("Address")
    val address: String,
    @SerializedName("Prefix")
    val prefix: String,
)



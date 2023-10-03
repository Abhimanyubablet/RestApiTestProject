package com.example.testrestapiproject

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface BarchCodeApiCalling {

    @GET("Android_Get_MechineTest_SearchAllBranch")
    fun searchBranchByCode(@Query("BCode") branchCode:String): Observable<Branch>

    @POST("Android_Get_MechineTest_SearchAllBranch")
    fun getUser(): Observable<Branch>

    companion object Factory {
        fun create(): BarchCodeApiCalling {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://victoriaapi.webinfotechedu.com/Service.asmx/")
                .build()
            return retrofit.create(BarchCodeApiCalling::class.java)
        }
    }

}
package com.rajgarhiafsm.features.damageProduct.api

import android.content.Context
import android.net.Uri
import android.text.TextUtils
import android.util.Log
import com.rajgarhiafsm.app.FileUtils
import com.rajgarhiafsm.base.BaseResponse
import com.rajgarhiafsm.features.NewQuotation.model.*
import com.rajgarhiafsm.features.addshop.model.AddShopRequestData
import com.rajgarhiafsm.features.addshop.model.AddShopResponse
import com.rajgarhiafsm.features.damageProduct.model.DamageProductResponseModel
import com.rajgarhiafsm.features.damageProduct.model.delBreakageReq
import com.rajgarhiafsm.features.damageProduct.model.viewAllBreakageReq
import com.rajgarhiafsm.features.login.model.userconfig.UserConfigResponseModel
import com.rajgarhiafsm.features.myjobs.model.WIPImageSubmit
import com.rajgarhiafsm.features.photoReg.model.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class GetDamageProductListRegRepository(val apiService : GetDamageProductListApi) {

    fun viewBreakage(req: viewAllBreakageReq): Observable<DamageProductResponseModel> {
        return apiService.viewBreakage(req)
    }

    fun delBreakage(req: delBreakageReq): Observable<BaseResponse>{
        return apiService.BreakageDel(req.user_id!!,req.breakage_number!!,req.session_token!!)
    }

}
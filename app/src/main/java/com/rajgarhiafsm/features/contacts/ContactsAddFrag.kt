package com.rajgarhiafsm.features.contacts

import android.content.Context
import android.location.Location
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.rajgarhiafsm.R
import com.rajgarhiafsm.app.NetworkConstant
import com.rajgarhiafsm.app.Pref
import com.rajgarhiafsm.app.domain.AddShopDBModelEntity
import com.rajgarhiafsm.app.utils.AppUtils
import com.rajgarhiafsm.app.utils.Toaster
import com.rajgarhiafsm.base.presentation.BaseActivity
import com.rajgarhiafsm.base.presentation.BaseFragment
import com.rajgarhiafsm.features.dashboard.presentation.DashboardActivity
import com.rajgarhiafsm.features.location.LocationWizard
import com.rajgarhiafsm.features.location.SingleShotLocationProvider
import com.rajgarhiafsm.features.member.api.TeamRepoProvider
import com.rajgarhiafsm.features.member.model.TeamListResponseModel
import com.google.android.material.textfield.TextInputEditText
import com.pnikosis.materialishprogress.ProgressWheel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.Random

class ContactsAddFrag : BaseFragment(), View.OnClickListener {

    private lateinit var mContext: Context
    private lateinit var progress_wheel: ProgressWheel
    private lateinit var et_fName: TextInputEditText
    private lateinit var et_lName: TextInputEditText
    private lateinit var et_companyName: TextInputEditText
    private lateinit var rv_companyNameHint: RecyclerView
    private lateinit var et_jobTitle: TextInputEditText
    private lateinit var et_email: TextInputEditText
    private lateinit var et_phone: TextInputEditText
    private lateinit var et_addr: TextInputEditText
    private lateinit var et_pin: TextInputEditText
    private lateinit var et_assignTo: TextInputEditText
    private lateinit var et_typeID: TextInputEditText
    private lateinit var et_remarks: TextInputEditText
    private lateinit var et_saleValue: TextInputEditText

    private lateinit var cvSubmit: CardView

    private lateinit var adapterCompanyNameHint: AdapterContactCompany

    private var locationStr:String = ""
    private var location_pinStr:String = ""


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.frag_contacts_add, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        // set views
        progress_wheel = view.findViewById(R.id.progress_wheel_frag_add_cont)
        et_fName = view.findViewById(R.id.et_frag_cont_add_fname)
        et_lName = view.findViewById(R.id.et_frag_cont_add_lname)
        et_companyName = view.findViewById(R.id.et_frag_cont_add_conpany_name)
        rv_companyNameHint = view.findViewById(R.id.rv_frag_contact_add_company_hint)
        et_jobTitle = view.findViewById(R.id.et_frag_cont_add_job_title)
        et_email = view.findViewById(R.id.et_frag_cont_add_email)
        et_phone = view.findViewById(R.id.et_frag_cont_add_phone)
        et_addr = view.findViewById(R.id.et_frag_cont_add_addr)
        et_pin = view.findViewById(R.id.et_frag_cont_add_pin)
        et_assignTo = view.findViewById(R.id.et_frag_cont_add_assign_to)
        et_typeID = view.findViewById(R.id.et_frag_cont_add_type_id)
        et_remarks = view.findViewById(R.id.et_frag_cont_add_remarks)
        et_saleValue = view.findViewById(R.id.et_frag_cont_add_sale_value)

        cvSubmit = view.findViewById(R.id.cv_frag_cont_add_submit)

        // set onclick listners
        et_assignTo.setOnClickListener(this)
        cvSubmit.setOnClickListener(this)

        rv_companyNameHint.visibility = View.GONE

        progress_wheel.spin()
        singleLocation()

        Handler().postDelayed(Runnable {
            setData()
        }, 1500)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.cv_frag_cont_add_submit ->{
                AppUtils.hideSoftKeyboard(mContext as DashboardActivity)
                submitValidationCheck()
            }
            R.id.et_frag_cont_add_assign_to->{
                getTeamList()
            }
        }
    }

    fun submitValidationCheck(){
        if(et_fName.text.toString().length==0){
            et_fName.requestFocus()
            et_fName.setError("Enter First Name")
        }
        if(et_lName.text.toString().length==0){
            et_lName.requestFocus()
            et_lName.setError("Enter Last Name")
        }
        if(et_phone.text.toString().length==0){
            et_phone.requestFocus()
            et_phone.setError("Enter Phone No.")
        }

        var shopObj = AddShopDBModelEntity()
        val random = Random()
        shopObj.shop_id = Pref.user_id + "_" + System.currentTimeMillis().toString() +  (random.nextInt(999 - 100) + 100).toString()
        shopObj.shopName = et_fName.text.toString()+" "+et_lName.text.toString()
        //company name
        //job title
        shopObj.ownerEmailId = et_email.text.toString()
        shopObj.ownerContactNumber = et_phone.text.toString()
        shopObj.address = et_addr.text.toString()
        shopObj.pinCode = et_pin.text.toString()
        //assign to
        shopObj.type_id = et_typeID.text.toString()
        //status
        //source
        //reference
        shopObj.remarks = et_remarks.text.toString()
        shopObj.amount = et_saleValue.text.toString()
    }

    private fun singleLocation() {
        try{
            SingleShotLocationProvider.requestSingleUpdate(mContext,
                object : SingleShotLocationProvider.LocationCallback {
                    override fun onStatusChanged(status: String) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onProviderEnabled(status: String) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onProviderDisabled(status: String) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onNewLocationAvailable(location: Location) {
                        if(location!=null){
                            locationStr = LocationWizard.getNewLocationName(mContext, location.latitude, location.longitude)
                            location_pinStr = LocationWizard.getPostalCode(mContext, location.latitude, location.longitude)
                        } else{
                            var lloc: Location = Location("")
                            lloc.latitude=Pref.current_latitude.toDouble()
                            lloc.longitude=Pref.current_longitude.toDouble()
                            locationStr = LocationWizard.getNewLocationName(mContext, lloc.latitude, lloc.longitude)
                            location_pinStr = LocationWizard.getPostalCode(mContext, lloc.latitude, lloc.longitude)
                        }

                        et_addr.setText(locationStr)
                        et_pin.setText(location_pinStr)
                        progress_wheel.stopSpinning()
                    }

                })
        }catch (ex:Exception){
            ex.printStackTrace()
            progress_wheel.stopSpinning()
        }
    }

    private fun setData(){
        var compL:ArrayList<String> = ArrayList()
        compL.add("Abc Lt.")
        compL.add("Abcd  Lt.")
        compL.add("Abcde  Lt.")
        compL.add("Abcdef  Lt.")
        compL.add("Abcdefg  Lt.")
        compL.add("Abcdefgh  Lt.")
        compL.add("Xyz  Lt.")
        compL.add("GH  Lt.")
        compL.add("Xyz  Lt.")
        compL.add("Xyz  Lt.")
        compL.add("Xyz  Lt.")
        compL.add("Xyz  Lt.")
        adapterCompanyNameHint = AdapterContactCompany(mContext,compL,object :AdapterContactCompany.onClick{
            override fun onNameClick(obj: String) {
                et_companyName.setText(obj)
                et_companyName.setSelection(obj.length)
                rv_companyNameHint.visibility = View.GONE
            }

            override fun onNoData(nodata: Boolean) {
                if(nodata){
                    rv_companyNameHint.visibility = View.GONE
                }else{
                    rv_companyNameHint.visibility = View.VISIBLE
                }
            }
        })
        rv_companyNameHint.adapter = adapterCompanyNameHint

        et_companyName.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                var str = p0.toString()
                if(str.length>1){
                    adapterCompanyNameHint?.filter.filter(str)
                    rv_companyNameHint.visibility = View.VISIBLE
                }else{
                    rv_companyNameHint.visibility = View.GONE
                }

            }
        })
    }

    private fun getTeamList() {
        if (!AppUtils.isOnline(mContext)) {
            (mContext as DashboardActivity).showSnackMessage(getString(R.string.no_internet))
            return
        }
        progress_wheel.spin()
        val repository = TeamRepoProvider.teamRepoProvider()
        BaseActivity.compositeDisposable.add(
            repository.teamList(Pref.user_id!!, false, false)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    val response = result as TeamListResponseModel
                    if (response.status == NetworkConstant.SUCCESS) {
                        progress_wheel.stopSpinning()
                        if (response.member_list != null && response.member_list!!.size > 0) {
                            var mList = response.member_list!!
                        } else {
                            (mContext as DashboardActivity).showSnackMessage(response.message!!)
                        }
                    } else {
                        progress_wheel.stopSpinning()
                        (mContext as DashboardActivity).showSnackMessage(response.message!!)
                    }
                }, { error ->
                    error.printStackTrace()
                    progress_wheel.stopSpinning()
                    (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
                })
        )
    }


}
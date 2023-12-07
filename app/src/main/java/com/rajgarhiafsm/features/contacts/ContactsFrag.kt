package com.rajgarhiafsm.features.contacts

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.provider.ContactsContract
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.rajgarhiafsm.R
import com.rajgarhiafsm.app.types.FragType
import com.rajgarhiafsm.app.utils.AppUtils
import com.rajgarhiafsm.app.utils.Toaster
import com.rajgarhiafsm.app.widgets.MovableFloatingActionButton
import com.rajgarhiafsm.base.presentation.BaseFragment
import com.rajgarhiafsm.features.dashboard.presentation.DashboardActivity
import com.rajgarhiafsm.widgets.AppCustomTextView
import java.util.ArrayList


class ContactsFrag : BaseFragment(), View.OnClickListener {

    private lateinit var mContext: Context
    private lateinit var mFab: MovableFloatingActionButton
    private lateinit var cvDilog: CardView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.frag_contacts, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        mFab = view.findViewById(R.id.fab_frag_contacts_add_contacts)
        cvDilog = view.findViewById(R.id.cv_frag_contacts_dialog)
        mFab.setOnClickListener(this)
        cvDilog.setOnClickListener(this)
        mFab.setCustomClickListener {
            (mContext as DashboardActivity).loadFragment(FragType.ContactsAddFrag, true, "")
        }
    }


    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.cv_frag_contacts_dialog -> {
                val simpleDialog = Dialog(mContext)
                simpleDialog.setCancelable(true)
                simpleDialog.getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                simpleDialog.setContentView(R.layout.dialog_contact_menu)
                val tvPhoneCont = simpleDialog.findViewById(R.id.tv_dialog_cont_add_phon_cont) as TextView
                simpleDialog.show()

                tvPhoneCont.setOnClickListener {
                    Toaster.msgShort(mContext,"asd")
                }

                var window:Window = simpleDialog.window!!
                val wlp = window.attributes
                wlp.x = 100
                wlp.y = -400
                window.attributes = wlp
            }
        }
    }
}
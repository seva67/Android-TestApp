package com.example.testapp

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import com.example.testapp.constance.Constance
import com.example.testapp.databinding.ActivityHandleBinding

class HandleActivity : ComponentActivity() {

    private lateinit var bindingClass: ActivityHandleBinding
    private var signState = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityHandleBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        signState = intent.getStringExtra(Constance.SIGN_STATE).toString()
        if(signState == Constance.SIGN_IN){

            bindingClass.name1EditText.visibility = View.GONE
            bindingClass.name2EditText.visibility = View.GONE
            bindingClass.name3EditText.visibility = View.GONE
            bindingClass.avatarView.visibility = View.INVISIBLE
            bindingClass.avatarBtn.visibility = View.INVISIBLE

        }
    }

    fun onClickAvatarBtn(view: View) {
        bindingClass.avatarView.visibility = View.VISIBLE
    }
}
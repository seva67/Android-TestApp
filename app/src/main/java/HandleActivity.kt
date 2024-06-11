package com.example.testapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.core.view.isVisible
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
            Log.d("MyLog", "Начальные настройки")
            bindingClass.name1EditText.visibility = View.GONE
            bindingClass.name2EditText.visibility = View.GONE
            bindingClass.name3EditText.visibility = View.GONE
            bindingClass.avatarView.visibility = View.INVISIBLE
            bindingClass.avatarBtn.visibility = View.INVISIBLE
        }
    }

    fun onClickNewUserBtn(view: View) {
        if(signState == Constance.SIGN_REG){
            val intent = Intent()
            intent.putExtra(Constance.LOGIN, bindingClass.loginEditText.text.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.passEditText.text.toString())
            intent.putExtra(Constance.NAME1, bindingClass.name1EditText.text.toString())
            intent.putExtra(Constance.NAME2, bindingClass.name2EditText.text.toString())
            intent.putExtra(Constance.NAME3, bindingClass.name3EditText.text.toString())
            if (bindingClass.avatarView.isVisible) intent.putExtra(Constance.AVATAR, R.drawable.pig)

            setResult(RESULT_OK, intent)
            finish()
        } else {
            intent.putExtra(Constance.LOGIN, bindingClass.loginEditText.text.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.passEditText.text.toString())

            setResult(RESULT_OK, intent)
            finish()
        }
    }

    fun onClickAvatarBtn(view: View) {
        bindingClass.avatarView.visibility = View.VISIBLE
    }
}
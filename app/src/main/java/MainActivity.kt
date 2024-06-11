package com.example.testapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import com.example.testapp.constance.Constance
import com.example.testapp.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private var login: String = ""
    private var password: String = ""
    private var name1: String = ""
    private var name2: String = ""
    private var name3: String = ""
    private var avatarId: Int = 0
    private var out = 0

    private lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Constance.SIGN_IN_REQUEST) {
            val l = data?.getStringExtra(Constance.LOGIN)
            val p = data?.getStringExtra(Constance.PASSWORD)
            val a = data?.getIntExtra(Constance.AVATAR, 0)
            if (login == l && password == p) {
                if (avatarId != 0) {
                    bindingClass.userView.setImageResource(avatarId)
                    bindingClass.userView.visibility = View.VISIBLE
                }
                bindingClass.fioView.text = "$name3 $name1 $name2"
                bindingClass.regBtn.visibility = View.GONE
                bindingClass.inBtn.text = "Выйти"
                out = 1
            } else {
                bindingClass.userView.visibility = View.INVISIBLE
                bindingClass.fioView.text = "Аккаунт не существует."
            }
        } else if (requestCode == Constance.SIGN_REG_REQUEST) {
            login = data?.getStringExtra(Constance.LOGIN)!!.toString()
            password = data?.getStringExtra(Constance.PASSWORD)!!.toString()
            name1 = data?.getStringExtra(Constance.NAME1)!!.toString()
            name2 = data?.getStringExtra(Constance.NAME2)!!.toString()
            name3 = data?.getStringExtra(Constance.NAME3)!!.toString()
            avatarId = data?.getIntExtra(Constance.AVATAR, 0)!!.toInt()
            if (avatarId != 0) {
                bindingClass.userView.setImageResource(avatarId)
                bindingClass.userView.visibility = View.VISIBLE
            }
            bindingClass.fioView.text = "$name3 $name1 $name2"
            bindingClass.regBtn.visibility = View.GONE
            bindingClass.inBtn.text = "Выйти"
            out = 1

        }
    }

    fun onClickInBtn(view: View) {
        if (out == 1) {
            bindingClass.fioView.text = ""
            bindingClass.userView.visibility = View.INVISIBLE
            bindingClass.regBtn.visibility = View.VISIBLE
            bindingClass.inBtn.text = getString(R.string.sign_in)
            out = 0
        } else {
            val intent = Intent(this, HandleActivity::class.java)
            intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN)
            startActivityForResult(intent, Constance.SIGN_IN_REQUEST)
        }
    }

    fun onClickRegBtn(view: View) {
        val intent = Intent(this, HandleActivity::class.java)
        intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_REG)
        startActivityForResult(intent, Constance.SIGN_REG_REQUEST)
    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            bindingClass.textView3.text = data.getStringExtra("request")
        }
    }

    fun onClickButton(view: View) {
        val intent = Intent(this, HandleActivity::class.java)

        intent.putExtra("key", "Привет из MainActivity")
        startActivityForResult(intent, 100)
    }*/
}

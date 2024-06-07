package com.example.testapp

import android.content.Intent
import android.os.Bundle
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

    private lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Constance.SIGN_IN_REQUEST) {

        } else if (requestCode == Constance.SIGN_REG_REQUEST) {

        }
    }

    fun onClickInBtn(view: View) {
        val intent = Intent(this, HandleActivity::class.java)
        startActivity(intent)
        intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN)
        startActivityForResult(intent, Constance.SIGN_IN_REQUEST)
    }

    fun onClickRegBtn(view: View) {
        /*val intent = Intent(this, HandleActivity::class.java)
        intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_REG)
        startActivityForResult(intent, Constance.SIGN_REG_REQUEST)*/
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

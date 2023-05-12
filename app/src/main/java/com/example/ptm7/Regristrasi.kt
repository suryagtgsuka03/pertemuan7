package com.example.ptm7

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.ptm7.DB.DBHelper


class Regristrasi : AppCompatActivity() {
    lateinit var eemail: EditText
    lateinit var epassword: EditText
    lateinit var efullname: EditText
    lateinit var btnregister: Button
    lateinit var btncancel: Button
    lateinit var userDBHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regristrasi)

        eemail = findViewById(R.id.EditEmailRegister)
        epassword = findViewById(R.id.EditPasswordRegister)
        efullname= findViewById(R.id.EditFullnameRegister)
        btnregister = findViewById(R.id.btnsubmitregister)
        btncancel = findViewById(R.id.btncancelregister)
        userDBHelper = DBHelper(this)
    }
    fun registerme(view: View){
        var iemail = eemail.text.toString()
        var ipassword = epassword.text.toString()
        var ifullname = efullname.text.toString()

        var cekuser = userDBHelper.cekUser(iemail)
        var status = "Gagal"
        if (cekuser =="0") {
            userDBHelper.RegisterUser(iemail, ipassword, ifullname)
            status = "Sukses"
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
        val toast: Toast = Toast.makeText(applicationContext,
            status, Toast.LENGTH_SHORT)
        toast.show()
    }
    fun cancelme(view: View){
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
package com.example.cuidatv3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity__register.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.tv_Password
import kotlinx.android.synthetic.main.activity_main.tv_UserName

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth

        Btn_SingUp.setOnClickListener {
            startActivity(Intent(this, Activity_Register::class.java))
            finish()
        }

        Btn_Login.setOnClickListener {
            reload()
        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            reload();
        }
    }
    private fun updateUI(currentUser: FirebaseUser?){
        if(currentUser != null){
            if(currentUser.isEmailVerified){
            startActivity(Intent(this,Activity_Cuerpo::class.java))
                finish()}
            else{
                Toast.makeText(baseContext, "Porfavor verifica tu email.",
                    Toast.LENGTH_SHORT)
                    .show()
            }
        }else{
            Toast.makeText(baseContext, "Autenticacion fallida.",
                Toast.LENGTH_SHORT)
                .show()
        }
    }

    fun  reload(){
        if (tv_UserName.text.toString().isEmpty()){
            tv_UserName.error = "Porfavor intruduce un correo electronico en el campo"
            tv_UserName.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(tv_UserName.text.toString()).matches()){
            tv_UserName.error="Porfavor introduce un email valido"
            return
        }
        if (tv_Password.text.toString().isEmpty()){
            tv_Password.error = "Porfavor introduce una contraseña"
            tv_Password.requestFocus()
            return
        }
        auth.signInWithEmailAndPassword(tv_UserName.text.toString(), tv_Password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    updateUI(null)
                }
            }

    }
}
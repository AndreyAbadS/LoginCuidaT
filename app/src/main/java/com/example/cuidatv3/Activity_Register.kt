package com.example.cuidatv3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity__register.*
import java.util.regex.Pattern

class Activity_Register : AppCompatActivity() {
    //instanciar firebase
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__register)
        //inicializar firebase
        auth = Firebase.auth
        //Funcion que tiene el boton registrar
        Btn_Registrar.setOnClickListener {
            singUpUser()
        }
    }
    //Funcion para registrar y verificar los campos vacios
    fun singUpUser(){
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
        //Proceso de creacion de cuenta en firebase
        auth.createUserWithEmailAndPassword(tv_UserName.text.toString(), tv_Password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = Firebase.auth.currentUser
                    user!!.sendEmailVerification()
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {startActivity(Intent(this,MainActivity::class.java))
                                finish()
                            }
                        }
                } else {
                    Toast.makeText(baseContext, "Fallo en el registro, intenta despues.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}
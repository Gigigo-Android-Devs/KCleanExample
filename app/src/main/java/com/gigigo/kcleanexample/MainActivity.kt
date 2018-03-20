package com.gigigo.kcleanexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gigigo.kcleanexample.presentation.LoginDataPresentation
import com.gigigo.kcleanexample.presentation.LoginEntity
import com.gigigo.kcleanexample.presentation.MainView
import com.gigigo.kcleanexample.presentation.sendForm

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainView {
  override fun showMessage(data: LoginEntity) {
    messageText.text  = messageText.text.toString() + "Login is sucess with " + data.email + ", " + data.password
  }

  override fun showEmailError() {
    messageText.text = messageText.text.toString() + "Error in email\n"
  }

  override fun showPasswordError() {
    messageText.text = messageText.text.toString() + "Error in Password\n"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    loginButton.setOnClickListener({
      messageText.text = ""

      val loginData = LoginDataPresentation(emailText.text.toString(), passwordText.text.toString())

      sendForm(loginData, this)
    })
  }


}

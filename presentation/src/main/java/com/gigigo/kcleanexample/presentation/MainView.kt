package com.gigigo.kcleanexample.presentation

interface MainView {
  fun showMessage(data: LoginEntity)
  fun showEmailError()
  fun showPasswordError()
}
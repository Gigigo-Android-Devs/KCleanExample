package com.gigigo.kcleanexample.presentation

sealed class ValidationErrorLogin {
  object InvalidEmail : ValidationErrorLogin()
  object InvalidPassword : ValidationErrorLogin()
}
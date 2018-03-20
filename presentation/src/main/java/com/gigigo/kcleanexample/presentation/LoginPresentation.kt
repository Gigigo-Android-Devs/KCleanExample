package com.gigigo.kcleanexample.presentation

import arrow.data.Nel
import arrow.data.Validated
import arrow.data.applicative
import arrow.data.ev
import arrow.syntax.applicative.map

fun sendForm(loginData: LoginDataPresentation, view: MainView) {
  val validateForm = validateData(loginData)
  validateForm.fold({
    handleInvalidForm(it, view)
  }, { handleValidForm(it, view) })
}

fun validateData(loginData: LoginDataPresentation): Validated<Nel<ValidationErrorLogin>, LoginEntity> {
  return Validated.applicative<Nel<ValidationErrorLogin>>()
       .map(validateEmail(loginData.email), validatePassword(loginData.password), { (email, password) ->
        LoginEntity(email, password)
      }).ev()
}

fun handleValidForm(data: LoginEntity,
    view: MainView) {
  view.showMessage(data)
}

fun handleInvalidForm(
    errors: Nel<ValidationErrorLogin>,
    view: MainView) {
  errors.map {
    when (it) {
      is ValidationErrorLogin.InvalidEmail -> view.showEmailError()
      is ValidationErrorLogin.InvalidPassword -> view.showPasswordError()
    }
  }
}

package com.gigigo.kcleanexample.presentation

import arrow.HK
import arrow.data.Nel
import arrow.data.ValidatedKindPartial
import arrow.data.nel
import arrow.syntax.validated.invalid
import arrow.syntax.validated.valid
import java.util.regex.Pattern

val VALID_EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)!!
val VALID_PASSWORD_REGEX = Pattern.compile("(?!^[0-9]*\$)(?!^[a-zA-Z]*\$)^([a-zA-Z0-9]{8,16})\$", Pattern.CASE_INSENSITIVE)!!


fun validateEmail(email: String) : HK<ValidatedKindPartial<Nel<ValidationErrorLogin>>, String> {
  return if (matchEmailRegex(email)) {
    email.valid()
  } else {
    ValidationErrorLogin.InvalidEmail.nel().invalid()
  }
}

fun validatePassword(password: String) : HK<ValidatedKindPartial<Nel<ValidationErrorLogin>>, String> {
  return if (matchPasswordRegex(password)) {
    password.valid()
  } else {
    ValidationErrorLogin.InvalidPassword.nel().invalid()
  }
}

private fun matchEmailRegex(email: String): Boolean {
  val matcher = VALID_EMAIL_REGEX.matcher(email)
  return matcher.find()
}

private fun matchPasswordRegex(password: String): Boolean {
  val matcher = VALID_PASSWORD_REGEX.matcher(password)
  return matcher.find()
}
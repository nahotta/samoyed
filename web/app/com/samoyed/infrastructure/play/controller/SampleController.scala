package com.samoyed.infrastructure.play.controller

import javax.inject.Inject

import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc._

class SampleController @Inject() (val messagesApi: MessagesApi) extends Controller with I18nSupport {

  def index() = Action { implicit request =>
    Ok(views.html.index("Hello World"))
  }

  def create() = Action { implicit request =>
    Ok(views.html.create())
  }
}

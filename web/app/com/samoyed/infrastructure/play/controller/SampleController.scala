package com.samoyed.infrastructure.play.controller

import javax.inject.Inject
import play.api.mvc._

class SampleController @Inject() extends Controller {

  def index() = Action { implicit request =>
    Ok(views.html.index("Hello World"))
  }
}

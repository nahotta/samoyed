package com.samoyed.infrastructure.play.controller

import javax.inject.Inject

import com.samoyed.application.CreateTestCaseService
import com.samoyed.createtest.domain.model.TestCase
import com.samoyed.infrastructure.play.form.TestCase.jsonReads
import play.api.libs.json.{JsError, Json}
import play.api.mvc._

class TestCaseController @Inject() extends Controller {

  val createTestCaseService = new CreateTestCaseService

  def index() = Action { implicit request =>
    Ok(views.html.index("Hello World"))
  }


  def create = Action(parse.json) { implicit request =>
    request.body.validate[TestCase].map { testCase =>
      createTestCaseService.create(testCase)
      Ok(
        Json.obj("status" -> "success")
      )
    }.recoverTotal{ e =>
      BadRequest(
        Json.obj(
          "status" -> "failed",
          "errors" -> JsError.toJson(e)
        )
      )
    }
  }
}

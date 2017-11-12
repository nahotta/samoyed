package com.samoyed.infrastructure.play.form

import com.samoyed.createtest.domain.model.TestCase
import play.api.libs.json.Json

object TestCase {
  implicit def jsonWrites = Json.writes[TestCase]
  implicit def jsonReads  = Json.reads[TestCase]
}

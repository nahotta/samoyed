package com.samoyed.application

import com.samoyed.createtest.domain.model.TestCase
import com.samoyed.createtest.domain.service.TestCaseService
import com.samoyed.createtest.infrastructure.MixinMySQLTestCaseRepository
import common.slick.Database

class CreateTestCaseService extends Database {
  val testCaseService = new TestCaseService with MixinMySQLTestCaseRepository

  def create(testCase : TestCase) : Unit = {
    testCaseService.create(testCase)
  }
}

package com.samoyed.application

import com.samoyed.createtest.domain.model.TestCase
import com.samoyed.createtest.domain.service.TestCaseService
import com.samoyed.createtest.infrastructure.{MixinMySQLTestCaseRepository, MySQLTestCaseRepository}
import common.slick.{Database, DatabaseContainer}
import org.scalamock.scalatest.MockFactory
import org.scalatest._

class CreateTestCaseServiceSpec extends FreeSpec with Matchers with Database with MockFactory {
  class CreateTestCaseServiceMock extends CreateTestCaseService {
    override val testCaseService = mock[TestCaseServiceMock]
  }

  class TestCaseServiceMock extends TestCaseService with MixinMySQLTestCaseRepository

  "createメソッドのテスト" - {
    "Unitが返ってくる" in {
      val createTestCaseService = new CreateTestCaseServiceMock
      val testCase = TestCase(
        "たいとる",
        "ほうほう",
        "きたいけっか",
        "じょうけん"
      )
      (createTestCaseService.testCaseService.create(_ : TestCase)(_ : DatabaseContainer)).expects(testCase, *).returns()

      createTestCaseService.create(testCase) should be ()
    }
  }

}

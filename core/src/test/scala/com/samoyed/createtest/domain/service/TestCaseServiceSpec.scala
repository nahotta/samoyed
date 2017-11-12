package com.samoyed.createtest.domain.service

import com.samoyed.createtest.domain.model.TestCase
import com.samoyed.createtest.domain.repository.{TestCaseRepository, UsingTestCaseRepository}
import common.slick.{Database, DatabaseContainer}
import org.scalamock.scalatest.MockFactory
import org.scalatest._

class TestCaseServiceSpec extends FreeSpec with Matchers with MockFactory with Database {
  class TestCaseServiceMock extends TestCaseService with UsingTestCaseRepository {
    override val testCaseRepository = mock[TestCaseRepository]
  }

  "createメソッドのテスト" - {
    "Unitが返ってくる" in {
      val testCaseService = new TestCaseServiceMock
      val testCase = TestCase(
        "タイトル",
        "テスト方法",
        "期待結果",
        "テスト条件"
      )

      (
        testCaseService.testCaseRepository.create(_: TestCase)(_ : DatabaseContainer)
      ).expects(testCase, *).returns()

      testCaseService.create(testCase) should be ()
    }
  }
}

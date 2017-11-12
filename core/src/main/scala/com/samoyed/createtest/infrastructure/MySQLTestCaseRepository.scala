package com.samoyed.createtest.infrastructure

import com.samoyed.createtest.domain.model.TestCase
import com.samoyed.createtest.domain.repository.{TestCaseRepository, UsingTestCaseRepository}
import common.slick.DatabaseContainer
import slick.driver.MySQLDriver.api._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

trait MixinMySQLTestCaseRepository extends UsingTestCaseRepository {
  override val testCaseRepository = MySQLTestCaseRepository
}

object MySQLTestCaseRepository extends TestCaseRepository {
  override def create(testCase: TestCase)(implicit db: DatabaseContainer) : Unit =  {
    val insert = sqlu"""
      insert into samoyed.case set
      case.title     = ${testCase.title},
      case.method    = ${testCase.method},
      case.expected  = ${testCase.expected},
      case.condition = ${testCase.condition}
    """

    Await.result(db.run(insert), Duration.Inf)
  }
}

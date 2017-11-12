package com.samoyed.createtest.infrasturcuture

import com.samoyed.createtest.domain.model.TestCase
import com.samoyed.createtest.infrastructure.{MixinMySQLTestCaseRepository, MySQLTestCaseRepository}
import common.slick.Database
import org.scalatest._
import slick.driver.MySQLDriver.api._
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

class MySQLTestCaseRepositorySpec extends FreeSpec with Matchers with Database with MixinMySQLTestCaseRepository {

  val truncateQuery = Seq(
    sqlu"""truncate table samoyed.case"""
  )

  Await.result(Future.sequence(truncateQuery.map(db.run(_))), Duration.Inf)

  "createメソッドのテスト" - {
    "insertできる" in {
      val testCase = TestCase(
        "たいとる",
        "ほうほう",
        "きたいけっか",
        "じょうけん"
      )
      testCaseRepository.create(testCase) should be ()
    }
    "登録されている" in {
      val selectSql =
        sql"""
            select case_id
             from samoyed.case
             where title = "たいとる"
           """.as[Int]

      Await.result(db.run(selectSql), Duration.Inf) should be (Vector(1))
    }
  }

}

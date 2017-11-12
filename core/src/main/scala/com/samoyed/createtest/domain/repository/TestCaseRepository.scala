package com.samoyed.createtest.domain.repository

import com.samoyed.createtest.domain.model.TestCase
import common.slick.DatabaseContainer

trait UsingTestCaseRepository {
  val testCaseRepository : TestCaseRepository
}

trait TestCaseRepository {
  def create(testCase : TestCase)(implicit db : DatabaseContainer) : Unit
}

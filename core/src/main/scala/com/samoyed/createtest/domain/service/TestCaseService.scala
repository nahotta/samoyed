package com.samoyed.createtest.domain.service

import com.samoyed.createtest.domain.model.TestCase
import com.samoyed.createtest.domain.repository.UsingTestCaseRepository
import common.slick.DatabaseContainer

trait TestCaseService extends UsingTestCaseRepository {
  def create(testCase : TestCase)(implicit db : DatabaseContainer): Unit = {
    testCaseRepository.create(testCase)
  }
}

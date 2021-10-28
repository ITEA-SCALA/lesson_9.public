package com.itea.task1

import com.itea.task1.controller.HealthController
import com.itea.task1.dao.HealthDao
import com.itea.task1.service.HealthService
import com.softwaremill.macwire._

trait LoadingModule {
  lazy val dao = wire[HealthDao]
  lazy val service = wire[HealthService]
  lazy val controller = wire[HealthController]
}

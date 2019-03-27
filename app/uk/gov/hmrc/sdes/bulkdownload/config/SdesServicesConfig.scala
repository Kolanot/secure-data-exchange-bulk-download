/*
 * Copyright 2019 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.sdes.bulkdownload.config

import javax.inject.{Inject, Singleton}
import play.api.Mode.Mode
import play.api.{Configuration, Environment}
import uk.gov.hmrc.play.config.ServicesConfig

@Singleton
class SdesServicesConfig @Inject()(override val runModeConfiguration: Configuration,
                                   environment: Environment) extends ServicesConfig {
  override protected def mode: Mode = environment.mode

  val apiAccessType: String = runModeConfiguration.getString("api.access.type").getOrElse("PRIVATE")

  val apiAccessWhitelistedApplicationIds: Seq[String] =
    runModeConfiguration.getStringSeq("api.access.white-list.applicationIds").getOrElse(Nil)
}

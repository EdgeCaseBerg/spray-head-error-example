package example

import akka.actor.ActorRefFactory
import org.scalatest._
import spray.testkit.ScalatestRouteTest
import spray.http._
import spray.json._
import MediaTypes._
import HttpHeaders._

import com.typesafe.config.ConfigFactory

class RoutesTest extends FlatSpec with MyRoutes with Matchers with ScalatestRouteTest {

	def actorRefFactory = system

	"A Head Route" should "return 200 from the server if defined" in {
		Head("/v0/healthcheck") ~> myRoutes ~> check {

			val conf = ConfigFactory.load()
			val onOrOff = conf.getString("spray.can.server.transparent-head-requests")
			println(onOrOff)

			assertResult(StatusCodes.OK) { status }
		}
	}

	"A Head Route" should "return 200 from the server if defined when the route is sealed" in {
		Head("/v0/healthcheck") ~> sealRoute(myRoutes) ~> check {

			val conf = ConfigFactory.load()
			val onOrOff = conf.getString("spray.can.server.transparent-head-requests")
			println(onOrOff)

			assertResult(StatusCodes.OK) { status }
		}
	}

}
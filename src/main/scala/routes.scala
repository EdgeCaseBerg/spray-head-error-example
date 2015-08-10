package example 

import akka.actor.{Actor,Props,ActorLogging}
import akka.routing._
import spray.routing._
import spray.http._
import spray.httpx.SprayJsonSupport._
import MediaTypes._
import akka.pattern.ask
import scala.util.{Success,Failure, Try}
import scala.util.matching.Regex
import scala.concurrent.duration._
import scala.concurrent._
import akka.util.Timeout


/** Provides Routing Structure for Endpoint's within v0/images */
trait MyRoutes extends HttpService {

	def myRoutes = {
		head {
			pathPrefix("v0" / "healthcheck") {			
				pathEndOrSingleSlash {				
					complete(StatusCodes.OK)
				}
			}
		} ~
		get {
			pathPrefix("v0" / "stuff") {
				pathEndOrSingleSlash {
					respondWithMediaType(`application/json`) {
						complete("{}")
					}
				}
			}
		}
	}
}
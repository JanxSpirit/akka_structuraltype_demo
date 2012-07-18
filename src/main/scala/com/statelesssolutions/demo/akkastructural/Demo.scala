package com.statelesssolutions.demo.akkastructural

import akka.actor._
import java.util.concurrent.Executors

class LoggingActor extends Actor {
  def receive = {
    case m: LogMessage => logIt(m)
    case m => println("I don't know how to log %s " format m.toString)
  }

  def logIt(lm: LogMessage) = println(lm.logMessage)
}

case class HeartbeatMessage(appName: String, uptime: Long)

case class UnknownMessage(mysteriousString: String)

object Demo {
  val system = ActorSystem("demo")
  def main(args: Array[String]) = {
    llogIt(HeartbeatMessage("Zork", 1000))
    val logger = system.actorOf(Props[LoggingActor], name = "logger")
    logger ! HeartbeatMessage("Zork", 1000)
    logger ! UnknownMessage("WTF?")
    logger ! "Random log message"


    system.shutdown
  }

  def llogIt(m: LogMessage) = println(m.logMessage)
}

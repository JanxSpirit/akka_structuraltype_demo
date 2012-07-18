package com.statelesssolutions.demo

package object akkastructural {
  type LogMessage = { def logMessage: String }

  implicit def heartbeatMessage2LogMessage(hbm: HeartbeatMessage): LogMessage = 
    new {
      def logMessage = "App %s --- total uptime %s millis".format(hbm.appName, hbm.uptime)
    }
  
  implicit def string2LogMessage(s: String): LogMessage = 
    new { def logMessage = s }
}

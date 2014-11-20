import java.util.Date;
import java.util.TimeZone;

import org.daiayum.apps.insideout.core.Attendance;

import grails.converters.JSON;

class BootStrap {

    def init = { servletContext ->
		//Register Attendance domain for JSON rendering
		JSON.registerObjectMarshaller(Attendance) {
			if(!it.timeZone) it.timeZone="Etc/UTC"
			def output = [:]
			output['id'] = it.id
			output['recordDate'] = convertToNewTimeZone(it.recordDate, TimeZone.getTimeZone(it.timeZone))
			output['timeIn'] = convertToNewTimeZone(it.timeIn, TimeZone.getTimeZone(it.timeZone))
			output['timeOut'] = it.timeOut ? convertToNewTimeZone(it.timeOut, TimeZone.getTimeZone(it.timeZone)) : it.timeOut
			output['actualTimeSpent'] = it.actualTimeSpent
			output['dateCreated'] = convertToNewTimeZone(it.dateCreated, TimeZone.getTimeZone(it.timeZone))
			output['lastUpdated'] = convertToNewTimeZone(it.lastUpdated, TimeZone.getTimeZone(it.timeZone))
			return output;
		}
    }
	
	def convertToNewTimeZone(Date date, TimeZone newTimeZone){
		long convertedDateInMilliSeconds = date.time + newTimeZone.rawOffset
		return new Date(convertedDateInMilliSeconds)
	}
	
    def destroy = {
    }
}

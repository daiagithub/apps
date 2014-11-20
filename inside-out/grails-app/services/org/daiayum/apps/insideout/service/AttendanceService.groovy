package org.daiayum.apps.insideout.service

import org.apache.catalina.valves.AccessLogValve.ElapsedTimeElement;
import org.daiayum.apps.insideout.core.Attendance;
import org.hibernate.Criteria;

import grails.transaction.Transactional

@Transactional
class AttendanceService {

    def serviceMethod() {

    }
	
	def recordAttendance(){
		Calendar today = new GregorianCalendar();
		today.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		
		if(!Attendance.findByRecordDate(today.getTime().clearTime())){
			def attendance = new Attendance(recordDate: today.getTime().clearTime(), timeIn: today.getTime(), actualTimeSpent: "00:00:00")
			attendance.save()
			return attendance
		}else{
			return null
		}		
	}
	
	def recordOut(def attendance){
		Calendar today = new GregorianCalendar();
		today.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		attendance.timeOut = today.getTime()
		
		use(groovy.time.TimeCategory) {
			def duration = attendance.timeOut - attendance.timeIn
			attendance.actualTimeSpent = String.format("%02d:%02d:%02d.%03d", duration.hours, duration.minutes, duration.seconds, duration.millis)			
		}
		
		attendance.save()
		return attendance		
	}
	
	def getElapsedTime(def attendance){
		def now = new Date()
		def elapsedHours
		def elapsedMinutes
		def elapsedSeconds
		def elapsedMillis
		
		use(groovy.time.TimeCategory) {
		    def duration = now - attendance.timeIn
		    elapsedHours = duration.hours
			elapsedMinutes = duration.minutes
			elapsedSeconds = duration.seconds
			elapsedMillis = duration.millis
		}	
		 
		return String.format("%02d:%02d:%02d.%03d", elapsedHours, elapsedMinutes, elapsedSeconds, elapsedMillis)
	}
}

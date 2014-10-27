package org.daiayum.apps.insideout.core

import org.apache.ivy.util.url.BasicURLHandler.HttpStatus;
import org.codehaus.groovy.grails.web.json.JSONObject;

import grails.converters.JSON;
import grails.transaction.*
import static org.springframework.http.HttpStatus.*
import static org.springframework.http.HttpMethod.*

@Transactional(readOnly = true)
class AttendanceController {

	def attendanceService
		
	static responseFormats = ['json', 'xml']

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Attendance.list(params), model:[attendanceInstanceCount: Attendance.count()]
    }

    def show(Attendance attendanceInstance) {
        respond attendanceInstance
    }

    def create() {
        respond new Attendance(params)
    }

    @Transactional
    def save(Attendance attendanceInstance) {
        if (attendanceInstance == null) {
			println "Not found..."
            notFound()
            return
        }

        if (attendanceInstance.hasErrors()) {
			println "Error..."  
			println attendanceInstance.errors
            respond attendanceInstance.errors, view:'create'
            return
        }

		println "Saving..."
        attendanceInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'attendance.label', default: 'Attendance'), attendanceInstance.id])
                redirect attendanceInstance
            }
            '*' { respond attendanceInstance, [status: CREATED] }
        }
    }
	
	@Transactional
	def record() {
		
		def attendanceInstance = attendanceService.recordAttendance()
		
		if(attendanceInstance)
			respond attendanceInstance, [status: CREATED]
		else
			respond JSON.parse('[{"error":"Already reported."}]'), [status: ALREADY_REPORTED]		
	}
		
	def elapsed() {
		def attendanceInstance = Attendance.findByRecordDate(new Date().clearTime())
				
		if(attendanceInstance){
			def elapsedTime = attendanceService.getElapsedTime(attendanceInstance)
			respond JSON.parse('[{"elapsedTime": "' + elapsedTime + '"}]'), [status: OK]
		}		
		else{
			respond JSON.parse('[{"error":"Not found."}]'), [status: NOT_FOUND]
		}					
	}
	
	@Transactional
	def out() {
		def attendanceInstance = Attendance.findByRecordDate(new Date().clearTime())
				
		if(attendanceInstance){
			attendanceInstance = attendanceService.recordOut(attendanceInstance)
			respond attendanceInstance, [status: ACCEPTED]
		}
		else{
			respond JSON.parse('[{"error":"Not found."}]'), [status: NOT_FOUND]
		}
	}

    def edit(Attendance attendanceInstance) {
        respond attendanceInstance
    }

    @Transactional
    def update(Attendance attendanceInstance) {
        if (attendanceInstance == null) {
            notFound()
            return
        }

        if (attendanceInstance.hasErrors()) {
            respond attendanceInstance.errors, view:'edit'
            return
        }

        attendanceInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Attendance.label', default: 'Attendance'), attendanceInstance.id])
                redirect attendanceInstance
            }
            '*'{ respond attendanceInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Attendance attendanceInstance) {

        if (attendanceInstance == null) {
            notFound()
            return
        }

        attendanceInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Attendance.label', default: 'Attendance'), attendanceInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'attendance.label', default: 'Attendance'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

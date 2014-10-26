package org.daiayum.insideout.core



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AttendenceController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Attendence.list(params), model:[attendenceInstanceCount: Attendence.count()]
    }

    def show(Attendence attendenceInstance) {
        respond attendenceInstance
    }

    def create() {
        respond new Attendence(params)
    }

    @Transactional
    def save(Attendence attendenceInstance) {
        if (attendenceInstance == null) {
            notFound()
            return
        }

        if (attendenceInstance.hasErrors()) {
            respond attendenceInstance.errors, view:'create'
            return
        }

        attendenceInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'attendence.label', default: 'Attendence'), attendenceInstance.id])
                redirect attendenceInstance
            }
            '*' { respond attendenceInstance, [status: CREATED] }
        }
    }

    def edit(Attendence attendenceInstance) {
        respond attendenceInstance
    }

    @Transactional
    def update(Attendence attendenceInstance) {
        if (attendenceInstance == null) {
            notFound()
            return
        }

        if (attendenceInstance.hasErrors()) {
            respond attendenceInstance.errors, view:'edit'
            return
        }

        attendenceInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Attendence.label', default: 'Attendence'), attendenceInstance.id])
                redirect attendenceInstance
            }
            '*'{ respond attendenceInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Attendence attendenceInstance) {

        if (attendenceInstance == null) {
            notFound()
            return
        }

        attendenceInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Attendence.label', default: 'Attendence'), attendenceInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'attendence.label', default: 'Attendence'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

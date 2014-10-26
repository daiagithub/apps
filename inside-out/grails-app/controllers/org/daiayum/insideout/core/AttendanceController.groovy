package org.daiayum.insideout.core

import static org.springframework.http.HttpStatus.*
import grails.rest.RestfulController;

class AttendenceController extends RestfulController{

	static responseFormats = ['json', 'xml']
	
	AttendenceController() {
		super(Attendance)
	}
  
}

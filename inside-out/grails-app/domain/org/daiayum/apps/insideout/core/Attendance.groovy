package org.daiayum.apps.insideout.core

class Attendance {
	
	Date timeIn
	Date timeOut
	String actualTimeSpent
	Date recordDate
	
	Date dateCreated
	Date lastUpdated

    static constraints = {
		timeOut nullable:true 
    }
}

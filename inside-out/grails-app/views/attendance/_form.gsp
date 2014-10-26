<%@ page import="org.daiayum.apps.insideout.core.Attendance" %>



<div class="fieldcontain ${hasErrors(bean: attendanceInstance, field: 'recordDate', 'error')} required">
	<label for="recordDate">
		<g:message code="attendance.recordDate.label" default="Record Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="recordDate" precision="day"  value="${attendanceInstance?.recordDate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: attendanceInstance, field: 'timeIn', 'error')} required">
	<label for="timeIn">
		<g:message code="attendance.timeIn.label" default="Time In" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="timeIn" precision="day"  value="${attendanceInstance?.timeIn}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: attendanceInstance, field: 'timeOut', 'error')} required">
	<label for="timeOut">
		<g:message code="attendance.timeOut.label" default="Time Out" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="timeOut" precision="day"  value="${attendanceInstance?.timeOut}"  />

</div>


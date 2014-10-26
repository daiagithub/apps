<%@ page import="org.daiayum.insideout.core.Attendance" %>



<div class="fieldcontain ${hasErrors(bean: attendenceInstance, field: 'recordDate', 'error')} required">
	<label for="recordDate">
		<g:message code="attendence.recordDate.label" default="Record Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="recordDate" precision="day"  value="${attendenceInstance?.recordDate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: attendenceInstance, field: 'timeIn', 'error')} required">
	<label for="timeIn">
		<g:message code="attendence.timeIn.label" default="Time In" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="timeIn" precision="day"  value="${attendenceInstance?.timeIn}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: attendenceInstance, field: 'timeOut', 'error')} required">
	<label for="timeOut">
		<g:message code="attendence.timeOut.label" default="Time Out" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="timeOut" precision="day"  value="${attendenceInstance?.timeOut}"  />

</div>


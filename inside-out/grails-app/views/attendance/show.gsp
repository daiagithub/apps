
<%@ page import="org.daiayum.apps.insideout.core.Attendance" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'attendance.label', default: 'Attendance')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-attendance" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-attendance" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list attendance">
			
				<g:if test="${attendanceInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="attendance.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${attendanceInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${attendanceInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="attendance.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${attendanceInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${attendanceInstance?.recordDate}">
				<li class="fieldcontain">
					<span id="recordDate-label" class="property-label"><g:message code="attendance.recordDate.label" default="Record Date" /></span>
					
						<span class="property-value" aria-labelledby="recordDate-label"><g:formatDate date="${attendanceInstance?.recordDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${attendanceInstance?.timeIn}">
				<li class="fieldcontain">
					<span id="timeIn-label" class="property-label"><g:message code="attendance.timeIn.label" default="Time In" /></span>
					
						<span class="property-value" aria-labelledby="timeIn-label"><g:formatDate date="${attendanceInstance?.timeIn}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${attendanceInstance?.timeOut}">
				<li class="fieldcontain">
					<span id="timeOut-label" class="property-label"><g:message code="attendance.timeOut.label" default="Time Out" /></span>
					
						<span class="property-value" aria-labelledby="timeOut-label"><g:formatDate date="${attendanceInstance?.timeOut}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:attendanceInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${attendanceInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

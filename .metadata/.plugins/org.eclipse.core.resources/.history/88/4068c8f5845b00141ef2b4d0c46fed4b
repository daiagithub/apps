
<%@ page import="org.daiayum.insideout.core.Attendence" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'attendence.label', default: 'Attendence')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-attendence" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-attendence" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'attendence.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'attendence.lastUpdated.label', default: 'Last Updated')}" />
					
						<g:sortableColumn property="recordDate" title="${message(code: 'attendence.recordDate.label', default: 'Record Date')}" />
					
						<g:sortableColumn property="timeIn" title="${message(code: 'attendence.timeIn.label', default: 'Time In')}" />
					
						<g:sortableColumn property="timeOut" title="${message(code: 'attendence.timeOut.label', default: 'Time Out')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${attendenceInstanceList}" status="i" var="attendenceInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${attendenceInstance.id}">${fieldValue(bean: attendenceInstance, field: "dateCreated")}</g:link></td>
					
						<td><g:formatDate date="${attendenceInstance.lastUpdated}" /></td>
					
						<td><g:formatDate date="${attendenceInstance.recordDate}" /></td>
					
						<td><g:formatDate date="${attendenceInstance.timeIn}" /></td>
					
						<td><g:formatDate date="${attendenceInstance.timeOut}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${attendenceInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>

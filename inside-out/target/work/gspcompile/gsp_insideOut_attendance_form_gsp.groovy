import org.daiayum.apps.insideout.core.Attendance
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_insideOut_attendance_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/attendance/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: attendanceInstance, field: 'recordDate', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("attendance.recordDate.label"),'default':("Record Date")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',10,['name':("recordDate"),'precision':("day"),'value':(attendanceInstance?.recordDate)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: attendanceInstance, field: 'timeIn', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("attendance.timeIn.label"),'default':("Time In")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',19,['name':("timeIn"),'precision':("day"),'value':(attendanceInstance?.timeIn)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: attendanceInstance, field: 'timeOut', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("attendance.timeOut.label"),'default':("Time Out")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',28,['name':("timeOut"),'precision':("day"),'value':(attendanceInstance?.timeOut)],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1414323835472L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}

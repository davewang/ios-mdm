<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="taskDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='taskDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="taskList.task"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="span2">
    <h2><fmt:message key="taskDetail.heading"/></h2>
    <fmt:message key="taskDetail.message"/>
</div>

<div class="span7">
<form:errors path="*" cssClass="alert alert-error fade in" element="div"/>
<form:form commandName="task" method="post" action="taskform" cssClass="well form-horizontal"
           id="taskForm" onsubmit="return validateTask(this)">
<form:hidden path="id"/>
    <%--<spring:bind path="task.command">--%>
    <%--<div class="control-group${(not empty status.errorMessage) ? ' error' : ''}">--%>
    <%--</spring:bind>--%>
        <%--<appfuse:label key="task.command" styleClass="control-label"/>--%>
        <%--<div class="controls">--%>
            <%--<form:input path="command" id="command"  maxlength="10000"/>--%>
            <%--<form:errors path="command" cssClass="help-inline"/>--%>
        <%--</div>--%>
    <%--</div>--%>
    <spring:bind path="task.commandUUID">
    <div class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
    </spring:bind>
        <appfuse:label key="task.commandUUID" styleClass="control-label"/>
        <div class="controls">
            <form:input path="commandUUID" id="commandUUID"  maxlength="255"/>
            <form:errors path="commandUUID" cssClass="help-inline"/>
        </div>
    </div>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <%--<form:select path="device" items="deviceList" itemLabel="label" itemValue="value"/>--%>
    <spring:bind path="task.name">
    <div class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
    </spring:bind>
        <appfuse:label key="task.name" styleClass="control-label"/>
        <div class="controls">
            <form:input path="name" id="name"  maxlength="255"/>
            <form:errors path="name" cssClass="help-inline"/>
        </div>
    </div>
    <%--<spring:bind path="task.result">--%>
    <%--<div class="control-group${(not empty status.errorMessage) ? ' error' : ''}">--%>
    <%--</spring:bind>--%>
        <%--<appfuse:label key="task.result" styleClass="control-label"/>--%>
        <%--<div class="controls">--%>
            <%--<form:input path="result" id="result"  maxlength="10000"/>--%>
            <%--<form:errors path="result" cssClass="help-inline"/>--%>
        <%--</div>--%>
    <%--</div>--%>
    <spring:bind path="task.status">
    <div class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
    </spring:bind>
        <appfuse:label key="task.status" styleClass="control-label"/>
        <div class="controls">
            <form:input path="status" id="status"  maxlength="255"/>
            <form:errors path="status" cssClass="help-inline"/>
        </div>
    </div>

    <div class="form-actions">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty task.id}">
            <button type="submit" class="btn btn-warning" name="delete" onclick="bCancel=true;return confirmMessage(msgDelConfirm)">
                <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
            </button>
        </c:if>

        <button type="submit" class="btn" name="cancel" onclick="bCancel=true">
            <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
        </button>
    </div>
</form:form>
</div>

<v:javascript formName="task" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['taskForm']).focus();
    });
</script>

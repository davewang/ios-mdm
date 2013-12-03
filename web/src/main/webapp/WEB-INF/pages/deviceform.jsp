<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="deviceDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='deviceDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="deviceList.device"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="span2">
    <h2><fmt:message key="deviceDetail.heading"/></h2>
    <fmt:message key="deviceDetail.message"/>
</div>

<div class="span7">
<form:errors path="*" cssClass="alert alert-error fade in" element="div"/>
<form:form commandName="device" method="post" action="deviceform" cssClass="well form-horizontal"
           id="deviceForm" onsubmit="return validateDevice(this)">
<form:hidden path="id"/>
    <spring:bind path="device.bluetoothMAC">
    <div class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
    </spring:bind>
        <appfuse:label key="device.bluetoothMAC" styleClass="control-label"/>
        <div class="controls">
            <form:input path="bluetoothMAC" id="bluetoothMAC"  maxlength="255"/>
            <form:errors path="bluetoothMAC" cssClass="help-inline"/>
        </div>
    </div>
    <spring:bind path="device.buildVersion">
    <div class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
    </spring:bind>
        <appfuse:label key="device.buildVersion" styleClass="control-label"/>
        <div class="controls">
            <form:input path="buildVersion" id="buildVersion"  maxlength="255"/>
            <form:errors path="buildVersion" cssClass="help-inline"/>
        </div>
    </div>

    <spring:bind path="device.deviceName">
    <div class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
    </spring:bind>
        <appfuse:label key="device.deviceName" styleClass="control-label"/>
        <div class="controls">
            <form:input path="deviceName" id="deviceName"  maxlength="255"/>
            <form:errors path="deviceName" cssClass="help-inline"/>
        </div>
    </div>
    <spring:bind path="device.udid">
    <div class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
    </spring:bind>
        <appfuse:label key="device.udid" styleClass="control-label"/>
        <div class="controls">
            <form:input path="udid" id="udid"  maxlength="255"/>
            <form:errors path="udid" cssClass="help-inline"/>
        </div>
    </div>
    <spring:bind path="device.wifiMAC">
    <div class="control-group${(not empty status.errorMessage) ? ' error' : ''}">
    </spring:bind>
        <appfuse:label key="device.wifiMAC" styleClass="control-label"/>
        <div class="controls">
            <form:input path="wifiMAC" id="wifiMAC"  maxlength="255"/>
            <form:errors path="wifiMAC" cssClass="help-inline"/>
        </div>
    </div>

    <div class="form-actions">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty device.id}">
            <button type="submit" class="btn btn-warning" name="delete" onclick="bCancel=true;return confirmMessage(msgDelConfirm)">
                <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
            </button>
        </c:if>

        <button type="submit" class="btn" name="cancel" onclick="bCancel=true">
            <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
        </button>     <br>    <br>
        <spring:url value="/deviceinfo?id=${device.id}" var="infourl"  />
        <a href="${infourl}">info</a>  <br>
        <spring:url value="/devicelock?id=${device.id}" var="lockurl"  />
        <a href="${lockurl}">lock with 123456</a>   <br>
        <spring:url value="/installForiTunesStore?id=${device.id}" var="installurl"  />
        <a href="${installurl}">install</a>   <br>
        <spring:url value="/removeinstall?id=${device.id}" var="removeurl"  />
        <a href="${removeurl}">remove </a>   <br>
        <spring:url value="/listprofile?id=${device.id}" var="listprofileurl"  />
        <a href="${listprofileurl}">listprofile </a>   <br>
        <spring:url value="/installprofile?id=${device.id}" var="installprofileurl"  />
        <a href="${installprofileurl}">installprofile </a>   <br>


        <spring:url value="/removeprofile?id=${device.id}" var="removeprofileurl"  />
        <a href="${removeprofileurl}">removeprofile </a>   <br>


        <spring:url value="/restrictions?id=${device.id}" var="restrictionsurl"  />
        <a href="${restrictionsurl}">Restrictions</a>   <br>

        <spring:url value="/installedapplicationlist?id=${device.id}" var="installedapplicationlist"  />
        <a href="${installedapplicationlist}">installed application list </a>   <br>



        <spring:url value="/managedApplicationList?id=${device.id}" var="managedApplicationListurl"  />
        <a href="${managedApplicationListurl}">managedApplicationList</a>   <br>

        <spring:url value="/managedapplicationlist?id=${device.id}" var="managedapplicationlist"  />
        <a href="${managedapplicationlist}">managed application list </a>   <br>



    </div>
</form:form>

</div>

<v:javascript formName="device" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['deviceForm']).focus();
    });
</script>

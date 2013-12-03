<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="deviceList.title"/></title>
    <meta name="menu" content="DeviceMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-error fade in">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<div class="span10">
    <h2><fmt:message key="deviceList.heading"/></h2>

    <form method="get" action="${ctx}/devices" id="searchForm" class="form-search">
    <div id="search" class="input-append">
        <input type="text" size="20" name="q" id="query" value="${param.q}"
               placeholder="<fmt:message key="search.enterTerms"/>" class="input-medium search-query"/>
        <button id="button.search" class="btn" type="submit">
            <i class="icon-search"></i> <fmt:message key="button.search"/>
        </button>
    </div>
    </form>

    <fmt:message key="deviceList.message"/>

    <div id="actions" class="form-actions">
        <a href='<c:url value="/deviceform"/>' class="btn btn-primary">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a href='<c:url value="/mainMenu"/>' class="btn"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

<display:table name="deviceList" class="table table-condensed table-striped table-hover" requestURI="" id="deviceList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="deviceform" media="html"
        paramId="id" paramProperty="id" titleKey="device.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="device.id"/>
    <display:column property="bluetoothMAC" sortable="true" titleKey="device.bluetoothMAC"/>
    <display:column property="buildVersion" sortable="true" titleKey="device.buildVersion"/>
    <display:column property="deviceName" sortable="true" titleKey="device.deviceName"/>
    <display:column property="udid" sortable="true" titleKey="device.udid"/>
    <display:column property="wifiMAC" sortable="true" titleKey="device.wifiMAC"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="deviceList.device"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="deviceList.devices"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="deviceList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="deviceList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="deviceList.title"/>.pdf</display:setProperty>
</display:table>

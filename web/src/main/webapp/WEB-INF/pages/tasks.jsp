<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="taskList.title"/></title>
    <meta name="menu" content="TaskMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-error fade in">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<div class="span10">
    <h2><fmt:message key="taskList.heading"/></h2>

    <form method="get" action="${ctx}/tasks" id="searchForm" class="form-search">
    <div id="search" class="input-append">
        <input type="text" size="20" name="q" id="query" value="${param.q}"
               placeholder="<fmt:message key="search.enterTerms"/>" class="input-medium search-query"/>
        <button id="button.search" class="btn" type="submit">
            <i class="icon-search"></i> <fmt:message key="button.search"/>
        </button>
    </div>
    </form>

    <fmt:message key="taskList.message"/>

    <div id="actions" class="form-actions">
        <a href='<c:url value="/taskform"/>' class="btn btn-primary">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a href='<c:url value="/mainMenu"/>' class="btn"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

<display:table name="taskList" class="table table-condensed table-striped table-hover" requestURI="" id="taskList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="taskform" media="html"
        paramId="id" paramProperty="id" titleKey="task.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="task.id"/>
    <%--<display:column property="command" sortable="true" titleKey="task.command"/>--%>
    <display:column property="commandUUID" sortable="true" titleKey="task.commandUUID"/>
    <display:column property="name" sortable="true" titleKey="task.name"/>
    <%--<display:column property="result" sortable="true" titleKey="task.result"/>--%>
    <display:column property="status" sortable="true" titleKey="task.status"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="taskList.task"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="taskList.tasks"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="taskList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="taskList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="taskList.title"/>.pdf</display:setProperty>
</display:table>

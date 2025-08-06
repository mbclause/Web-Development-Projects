<%@ tag body-content="scriptless" %>
<%@ attribute name="name" required="true" rtexprvalue="true" %>

<jsp:doBody var="message" />

${message}, ${name}!

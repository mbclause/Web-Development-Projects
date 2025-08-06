<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTLTest</title>
</head>
<body>
<p><a href="<c:url value='/JSTLTest' />">A Type Variable</a></p>
<h3>Branch Tags</h3>
<p><c:if test="${a.weekdays[0] == 'mon'}">Monday</c:if></p>
<p>
  <c:choose>
    <c:when test="${a.weekdays[3] == 'tue'}">Tuesday</c:when>
    <c:when test="${a.weekdays[3] == 'wed'}">Wednesday</c:when>
    <c:when test="${a.weekdays[3] == 'thr'}">Thursday</c:when>
    <c:otherwise>Friday</c:otherwise>
  </c:choose>
</p>
<p>The length of the string "cs3220" is ${fn:length("cs3220")}.</p>
<p>The size of numbers array is ${fn:length(a.numbers)}.</p>
<ul>
  <c:forEach items="${a.numbers}" var="number" varStatus="status">
    <li>${status.index}: <fmt:formatNumber value="${number}" pattern="0.###"/>
      <c:if test="${status.first}">(First)</c:if>
      <c:if test="${status.last}">(Last)</c:if>
    </li>
  </c:forEach>
</ul>
<p><c:out value="abc" /></p>
<p><c:out value="${a.id}" /></p>
<p><c:out value="a<b>c" /></p>
<p>Date: <fmt:formatDate value="${a.date}" type="date" />
<p>Date: <fmt:formatDate value="${a.date}" type="time" />
<p>Date: <fmt:formatDate value="${a.date}" type="both" />
<p>Date: <fmt:formatDate value="${a.date}" pattern="yyyy-M-d h:m:s a" />
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CurrencyPost</title>
</head>
<body>
	<p>${param.amount} ${param.c1} = <fmt:formatNumber value="${result}" pattern="0.###"/> ${param.c2}</p>
	<p><a href="CurrencyConverter">Back</a></p>
</body>
</html>
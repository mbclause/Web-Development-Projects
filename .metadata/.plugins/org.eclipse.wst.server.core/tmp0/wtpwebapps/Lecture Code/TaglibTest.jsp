<%@ taglib prefix="cs3220" uri="http://cs.calstatela.edu/cs3220/stu73" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TaglibTest</title>
</head>
<body>

<p>The sum of 10 and 20 is <cs3220:add op1="10" op2="20" />.</p>
<p>The sum of ${param.a} and ${param.b} is <cs3220:add op1="${param.a}" op2="${param.b}" />.</p>

<p>Request Info</p>
<ul>
  <li>Method: <cs3220:requestInfo type="method" /></li>
  <li>URI: <cs3220:requestInfo type="uri" /></li>
  <li>Client Address: <cs3220:requestInfo type="client" /></li>
  <li>Server Address: <cs3220:requestInfo type="server" /></li>
</ul>

<p><cs3220:cap>Hello World</cs3220:cap></p>

<p><cs3220:greeting name="cguo">Hello</cs3220:greeting></p>

<p>${cs3220:leetTalk("fear my mad programming skills")}</p>

</body>
</html>

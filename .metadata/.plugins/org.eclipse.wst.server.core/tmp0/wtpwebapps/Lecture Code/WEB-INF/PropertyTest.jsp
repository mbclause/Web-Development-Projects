<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Property Test</title>
</head>
<body>
	<h2>Property Test</h2>
	<p>A Type Variable</p>
	<ul>
		<li>a: ${a}</li>
		<li>id: ${a.id}</li>
		<li>name: ${a.name}</li>
		<li>weekdays: ${a.weekdays}</li>
		<li>weekdays[1]: ${a.weekdays[1]}</li>
		<li>weekdays["1"]: ${a.weekdays["1"]}</li>
		<li>numbers[1]: ${a.numbers[1]}</li>
		<li>numbers["1"]: ${a.numbers["1"]}</li>
		<li>date: ${a.date}</li>
		<li>year: ${a.date.year}</li>
		<li>month: ${a.date.month}</li>
	</ul>
	<p>B Type Variable</p>
	<ul>
		<li>b: ${b}</li>
		<li>b.a0: ${b.a0}</li>
		<li>b.a0.id: ${b.a0.id}</li>
		<li>b.a0.name: ${b.a0.name}</li>
		<li>b.listA: ${b.listA}</li>
		<li>b.listA[1].id: ${b.listA[1].id}</li>
		<li>b.listA[1].name: ${b.listA[1].name}</li>
	</ul>
</body>
</html>

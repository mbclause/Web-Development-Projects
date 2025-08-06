<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DisplayQuestion</title>
</head>
<body>
	<p>
		${questions[index].getDescription()}<br>
		1. ${questions[index].getAnswerA()}<br>
		2. ${questions[index].getAnswerB()}<br>
		3. ${questions[index].getAnswerC()}<br>
		Correct Answer: ${questions[index].getCorrectAnswer()}
	</p>
	<a href="DrivingTestBrowser?index=${index+1}">Next</a>
</body>
</html>
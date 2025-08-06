
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CXForm</title>
</head>
<body>
	<form action="CXCalculator" method="post">
		<p>
			Exchange <input type="text" name="amount" placeholder="Amount"> from
				<select name = "curr1">
						<option value="USD" selected>USD</option>
						<option value="EUR">EUR</option>
						<option value="JPY">JPY</option>
						<option value="GBP">GBP</option>
				</select> to
				<select name="curr2">
						<option value="USD" selected>USD</option>
						<option value="EUR">EUR</option>
						<option value="JPY">JPY</option>
						<option value="GBP">GBP</option>
				</select>
		</p>
		<br>
		<input type="submit" name="add" value="Calculate">
	</form>
</body>
</html>
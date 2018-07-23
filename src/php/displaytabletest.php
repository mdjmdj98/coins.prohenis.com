<html>
<head>
<title>Display Data into DB</title>
<style type="text/css">
table{
  border: 2px solid red;
  background-color: #FCC;
}
th{
  border-bottom: 5px solid #000
}
td{
  border-bottom: 2px solid #666
}
</style>
</head>
<body>
<h1>Display Data from Table</h1>

<?php

include('connect-mysql.php');

$sqlget = "SELECT * FROM currency";
$sqldata = mysqli_query($mysqli, $sqlget) or die('error');

echo "<table>";
echo "<tr><th>NAME</th><th>POINTS</th><th>HOURS</th></tr>";

while($row = mysqli_fetch_array($sqldata, mysqli_assoc)) {
  echo "<tr><td>";
  echo $row['NAME'];
  echo "</td><td>"
  echo $row['POINTS'];
  echo "</td><td>"
  echo $row['HOURS'];
  echo "</td></tr>";
}
 echo "</table>";

?>

</body>
</html>

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

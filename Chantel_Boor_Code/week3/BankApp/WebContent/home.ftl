<html>
<head>
<title>User Home</title>
</head>

<body>

<h2>Welcome ${fn} ${ln}!</h2>
<br>

<h3>Accounts</h3>

<#if display! == "yes">
<#list accounts as account>
<tr>
 <td>Id: 	</td> <td>${account.id}</td> <td>	Balance: $</td> <td>${account.balance}</td> <br>
</tr>
</#list>
<#else>
No Accounts to display
<b>
</#if>

</table>

</body>
</html>
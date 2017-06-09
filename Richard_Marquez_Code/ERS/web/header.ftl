<!DOCTYPE html>
<html>
<head>
    <title>${pageTitle} &middot; RevatureERS</title>

    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Poppins">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Montserrat:400,700">
    <link rel="stylesheet" type="text/css" href="/css/main.css">

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/tablesorter/jquery.tablesorter.min.js"></script>
    <script src="js/main.js"></script>
</head>
<body>

<header>
    <h1><a href="/"><span class="glyphicon glyphicon-transfer" aria-hidden="true"></span> &nbsp;Revature<strong>ERS</strong></a></h1>

    <#if pageTitle != "Login">
    <nav>
        <ul>
            <#if pageTitle == "Employee Home">
            <a id="newRequest" href="#">
                <li data-toggle="modal" data-target="#newRequestModal"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> &nbsp;New Request</li>
            </a>
            </#if>

            <#if user.isManager()>

                <#if pageTitle == "Manager Home">
                    <a id="newUser" href="#">
                        <li data-toggle="modal" data-target="#newUserModal"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> &nbsp;Add User</li>
                    </a>
                </#if>

                <a id="allRequests" href="/RequestArchive">
                    <li><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> &nbsp;Request Archive</li>
                </a>
            </#if>

            <a id="accountInfo" href="/EmployeeAccount">
                <li><span class="glyphicon glyphicon-user" aria-hidden="true"></span> &nbsp;Account</li>
            </a>

            <a id="logout" class="btn btn-primary" href="/Logout"><li>Log Out</li></a>
        </ul>
    </nav>
    </#if>
</header>


<!-- display current info and form to update below -->
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        
        <!-- JQuery CDN -->
        <script src="https://code.jquery.com/jquery-3.2.1.js" integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" crossorigin="anonymous"></script>
        
        <!-- Bootstrap -->
<!--        <link href="css/bootstrap.min.css" rel="stylesheet">-->
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>  
        
        <title>ERS Portal</title>
        <link rel="stylesheet" href="profile.css">
        <script src="profile.js"></script>
    </head>
    
    <body>    
        <!-- Top Nav Bar-->
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                  <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-piggy-bank" aria-hidden="true"></span>  ERS</a>   
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <#if manager! == "false">
                            <li><a href="home.ftl">Requests<span class="sr-only">(current)</span></a></li>
                        </#if>
                        <#if manager! == "true">
                            <li><a href="manager.ftl">Requests<span class="sr-only">(current)</span></a></li>
                            <li><a href="employees.ftl">Employees</a></li>
                        </#if>
                    </ul>
                    

                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>  ${employee.firstName}<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                              <li name="update-prof"><a href="profile.ftl"><button id="hidden-button" type="submit" action="profile" method="post">View/Update Profile</button></a></li>
                                <li role="separator" class="divider"></li>
                                <li name="logout"><a href="logout.ftl"><button id="hidden-button" type="submit" action="logout" method="post">Logout</button></a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        

        <!--  view current information  -->
        <h2 class="sub-header">Current Information</h2>
        <div id="current-info">
            <h4>First Name: ${employee.firstName} </h4>
            <h4>Last Name: ${employee.lastName} </h4>
            <h4>Email: ${employee.email} </h4>
        </div>
        

        <!-- form to update information  -->
        <h2 class="sub-header">Update Information</h2>
        <form class="form-horizontal" action="profile" method="post">
            <div class="form-group">
                <label for="first-name" class="control-label col-sm-2">First Name: </label>
                <div class="col-xs-5">
                    <input type="text" class="form-control" name="first-name" id="first-name" placeholder="Enter new first name">
                </div>
            </div>
            <div class="form-group">
                <label for="last-name" class="control-label col-sm-2">Last Name:</label>
                <div class="col-xs-5">
                    <input type="text" class="form-control" name="last-name" id="last-name" placeholder="Enter new last name">
                </div>
<!--
            <label for="password" class="control-label">Password: </label>
            <input type="text" class="form-control" id="password">            
-->
            <br><br><br>
            <button type="submit" class="btn btn-default" value="update">Save Changes</button>
        </form>
        <#if profile! == "pass">
            <h3 style="color:#14b251">      Your personal info has been sucessfully updated.</h3>
        </#if>
        <#if profile! == "fail">
            <h3 style="color:#c91d1d">      Your request was not processed correctly. Please try again later.</h3>
        </#if>
        
        
<!--        script -->
        <script type="text/javascript">
        $(".dropdown-toggle").dropdown();
        </script>
    </body>
</html>
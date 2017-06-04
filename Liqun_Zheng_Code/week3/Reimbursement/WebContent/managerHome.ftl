<html>
<body>
<link
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
    crossorigin="anonymous">

<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
    integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
    crossorigin="anonymous"></script>


<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="well well-sm">
                <div class="row">
                    <div class="col-sm-6 col-md-4">
                        <img src="https://www.iconfinder.com/data/icons/unique-round-blue/93/user-512.png" alt="" class="img-rounded img-responsive" />
                    </div>
                    <div class="col-sm-6 col-md-8">
                        <h4>
                           Welcome back Manager: ${firstname} ${lastname}</h4>
                        <small><cite title="Reston, VA USA">Reston, VA USA <i class="glyphicon glyphicon-map-marker">
                        </i></cite></small>
                        <p>
                            <i class="glyphicon glyphicon-envelope"></i>email@example.com
                            <br />
                            <i class="glyphicon glyphicon-globe"></i><a href="https://github.com/Revature1705May15Java/1705May15Java/tree/Liqun_Zheng/Liqun_Zheng_Code">My Home Page</a>
                            <br />
                            <i class="glyphicon glyphicon-gift"></i>June 02, 1995</p>
                        <!-- Split button -->
                        	<table class="datatable">
								<tr>
									<th>Request Id &nbsp;</th>
									<th>Request Amount</th>
								</tr>

								<#list requests as request>
								<tr>
									<td>&#9731 ${request.request_id}</td> <td>&dollar; ${request.amount}</td>
								</tr>
								</#list>
							</table>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
</div>


</body>

</html>
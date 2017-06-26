<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <title>Refund Me</title>

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">

    <!-- Template styles -->
    <link href="css/style.css" rel="stylesheet">
	
	<link href="css/user.css" rel="stylesheet">
	
	<!-- JQuery -->
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    
	
</head>

<body>


    <!--Navbar-->
    <nav class="navbar navbar-toggleable-md navbar-dark scrolling-navbar fixed-top">
        <div class="container">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#collapseEx2" aria-controls="collapseEx2" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="#">
                <strong>Refund Me</strong>
            </a>
            <div class="collapse navbar-collapse" id="collapseEx2">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link">Home <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
                
                <button type="button" class="btn btn-primary btn-rounded pull-right" data-toggle="modal"
			data-target="#myModal" style="margin-top: -2px;margin-left: 5px;">Log In</button>
            </div>
        </div>
    </nav>
    <!--/.Navbar-->
    
		<!-- BEGIN # MODAL LOGIN -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	<div class="modal-dialog">
			<div class="modal-content">
             
                <!-- Begin # DIV Form -->
                <div id="div-forms">
                
                    <!-- Begin # Login Form -->
                    <form id="login-form" name="user" action="login" method="post">
		                <div class="modal-body">
				    		<div id="div-login-msg">
                                <div id="icon-login-msg" class="glyphicon glyphicon-chevron-right"></div>
                                <span id="text-login-msg">Type your username and password.</span>
                            </div>
				    		<input id="login_username" class="form-control" type="text" placeholder="Username" name="userName" required>
				    		<input id="login_password" class="form-control" type="password" placeholder="Password" name="pwd" required>
        		    	</div>
				        <div class="modal-footer">
                            <div>
                                <button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>
                            </div>
				    	    <div>
                                <#if err == 1>
                 				<input id="error" class="form-control" type="text" value="1" name="errorCheck" style="display: none;" />
                 				<#else>
                 				<input id="error" class="form-control" type="text" value="0" name="errorCheck" style="display: none;" />
                 				</#if>
                            </div>
				        </div>
                    </form>
                    <!-- End # Login Form -->
                    
                    <!-- Begin | Lost Password Form -->
                    <form id="lost-form" style="display:none;">
    	    		    <div class="modal-body">
		    				<div id="div-lost-msg">
                                <div id="icon-lost-msg" class="glyphicon glyphicon-chevron-right"></div>
                                <span id="text-lost-msg">Type your e-mail.</span>
                            </div>
		    				<input id="lost_email" class="form-control" type="text" placeholder="E-Mail (type ERROR for error effect)" required>
		    				
            			</div>
		    		    <div class="modal-footer">
                            <div>
                                <button type="submit" class="btn btn-primary btn-lg btn-block">Send</button>
                            </div>
                            <div>
                                <button id="lost_login_btn" type="button" class="btn btn-link">Log In</button>
                            </div>
		    		    </div>
                    </form>
                    <!-- End | Lost Password Form -->
                    
                </div>
                <!-- End # DIV Form -->
                
			</div>
		</div>
	</div>
    <!-- END # MODAL LOGIN -->
		<script type="text/javascript">
		var check = $('#error').val();
		if(check == 1){
			$(window).on('load',function(){
	  	        $('#myModal').modal('show');
	  	      	$('#text-login-msg').css("color", "red");
	  	      	$('#text-login-msg').html('Login Error. Wrong Username/Password!');
	   	    });
		}
        
	</script>
	
    <!--Mask-->
    <div class="view hm-black-strong">
        <div class="full-bg-img flex-center">
            <ul>
                <li>
                    <h1 class="h1-responsive wow fadeInDown" data-wow-delay="0.2s">Refunds As Easy As 123</h1></li>
                <li>
                    <p class="wow fadeInDown">Three easy steps that will, give you your money back. Log in to get started today!</p>
                </li>
            </ul>
        </div>
    </div>
    <!--/.Mask-->

    <!-- Main container-->
    <div class="container">

        <div class="divider-new">
            <h2 class="h2-responsive wow fadeInDown">3 Steps To A Satisfied Customer</h2>
        </div>

        <!--Section: Best features-->
        <section id="best-features">

            <div class="row">

                <!--First columnn-->
                <div class="col-md-3">
                    <!--Card-->
                    <div class="card wow fadeInUp">

                        <!--Card image-->
                        <div class="view overlay hm-white-slight">
                            <img src="https://19126-presscdn-pagely.netdna-ssl.com/e-signature/wp-content/uploads/sites/13/2016/06/7-FAQ%E2%80%99s-about-how-to-sign-documents-online.jpg" class="img-fluid" alt="">
                            <a>
                                <div class="mask"></div>
                            </a>
                        </div>
                        <!--/.Card image-->

                        <!--Card content-->
                        <div class="card-block text-center">
                            <!--Title-->
                            <h4 class="card-title">1. Fill out a request!</h4>
                            <hr>
                            <!--Text-->
                            <p class="card-text">Press the "Make Request", button only the amount is need. It is encouraged to also add a valid reason to speed up the request.</p>
                        </div>
                        <!--/.Card content-->

                    </div>
                    <!--/.Card-->
                </div>
                <!--First columnn-->

                <!--Second columnn-->
                <div class="col-md-3">
                    <!--Card-->
                    <div class="card wow fadeInUp" data-wow-delay="0.2s">

                        <!--Card image-->
                        <div class="view overlay hm-white-slight">
                            <img src="https://media.licdn.com/mpr/mpr/AAEAAQAAAAAAAA0EAAAAJDdiMDdlNDY4LTZjODYtNDkxNy04NTI2LTFhYWYwN2RkODA2MQ.jpg" class="img-fluid" alt="">
                            <a>
                                <div class="mask"></div>
                            </a>
                        </div>
                        <!--/.Card image-->

                        <!--Card content-->
                        <div class="card-block text-center">
                            <!--Title-->
                            <h4 class="card-title">2. Waiting</h4>
                            <hr>
                            <!--Text-->
                            <p class="card-text">After the request is made, your part is done. All you have to do is sit back and relax and let the money come to you.</p>
                        </div>
                        <!--/.Card content-->

                    </div>
                    <!--/.Card-->
                </div>
                <!--Second columnn-->

                <!--Third columnn-->
                <div class="col-md-3">
                    <!--Card-->
                    <div class="card wow fadeInUp" data-wow-delay="0.4s">

                        <!--Card image-->
                        <div class="view overlay hm-white-slight">
                            <img src="https://assets.entrepreneur.com/content/3x2/1300/entitled-shipping-refund-what-know.jpg" class="img-fluid" alt="">
                            <a>
                                <div class="mask"></div>
                            </a>
                        </div>
                        <!--/.Card image-->

                        <!--Card content-->
                        <div class="card-block text-center">
                            <!--Title-->
                            <h4 class="card-title">3. More Money</h4>
                            <hr>
                            <!--Text-->
                            <p class="card-text">Our simple reimbursement process will leave you with your money back in no time. Our transaction will leave both parties satisfied.</p>
                        </div>
                        <!--/.Card content-->

                    </div>
                    <!--/.Card-->
                </div>
                <!--Third columnn-->

                <!--Fourth columnn-->
                <div class="col-md-3">
                    <!--Card-->
                    <div class="card wow fadeInUp" data-wow-delay="0.6s">

                        <!--Card image-->
                        <div class="view overlay hm-white-slight">
                            <img src="http://www.pardot.com/content/uploads/2016/03/happy-customer.jpg" class="img-fluid" alt="">
                            <a>
                                <div class="mask"></div>
                            </a>
                        </div>
                        <!--/.Card image-->

                        <!--Card content-->
                        <div class="card-block text-center">
                            <!--Title-->
                            <h4 class="card-title">Leave Satisfied</h4>
                            <hr>
                            <!--Text-->
                            <p class="card-text">We don't believe in "more money, more problems" here. At Refund Me, after the transaction you will leave with a smile on your face.</p>
                        </div>
                        <!--/.Card content-->

                    </div>
                    <!--/.Card-->
                </div>
                <!--Fourth columnn-->
            </div>

        </section>
        <!--/Section: Best features-->

        
    </div>
    <!--/ Main container-->



    <!--Footer-->
    <footer class="page-footer center-on-small-only mdb-color darken-4">

        <!--Copyright-->
        <div class="footer-copyright">
            <div class="container-fluid">
                &copy; 2017 Arthur, LLC. &middot; <a href="#">Privacy</a>

            </div>
        </div>
        <!--/.Copyright-->

    </footer>
    <!--/.Footer-->


    <!-- SCRIPTS -->

    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="js/tether.min.js"></script>

    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>

    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="js/mdb.min.js"></script>
 

    <!-- Animations init-->
    <script>
        new WOW().init();

        /* #####################################################################
        #
        #   Project       : Modal Login with jQuery Effects
        #   Author        : Rodrigo Amarante (rodrigockamarante)
        #   Version       : 1.0
        #   Created       : 07/29/2015
        #   Last Change   : 08/04/2015
        #
        ##################################################################### */
        
        $(function() {
            
            var $formLogin = $('#login-form');
            var $formLost = $('#lost-form');
            var $formRegister = $('#register-form');
            var $divForms = $('#div-forms');
            var $modalAnimateTime = 300;
            var $msgAnimateTime = 150;
            var $msgShowTime = 2000;
            
            $('#login_register_btn').click( function () { modalAnimate($formLogin, $formRegister) });
            $('#register_login_btn').click( function () { modalAnimate($formRegister, $formLogin); });
            $('#login_lost_btn').click( function () { modalAnimate($formLogin, $formLost); });
            $('#lost_login_btn').click( function () { modalAnimate($formLost, $formLogin); });
            $('#lost_register_btn').click( function () { modalAnimate($formLost, $formRegister); });
            $('#register_lost_btn').click( function () { modalAnimate($formRegister, $formLost); });
            
            
            function modalAnimate ($oldForm, $newForm) {
                var $oldH = $oldForm.height();
                var $newH = $newForm.height();
                $divForms.css("height",$oldH);
                $oldForm.fadeToggle($modalAnimateTime, function(){
                    $divForms.animate({height: $newH}, $modalAnimateTime, function(){
                        $newForm.fadeToggle($modalAnimateTime);
                    });
                });
            }
            
            function msgFade ($msgId, $msgText) {
                $msgId.fadeOut($msgAnimateTime, function() {
                    $(this).text($msgText).fadeIn($msgAnimateTime);
                });
            }
            
            function msgChange($divTag, $iconTag, $textTag, $divClass, $iconClass, $msgText) {
                var $msgOld = $divTag.text();
                msgFade($textTag, $msgText);
                $divTag.addClass($divClass);
                $iconTag.removeClass("glyphicon-chevron-right");
                $iconTag.addClass($iconClass + " " + $divClass);
                setTimeout(function() {
                    msgFade($textTag, $msgOld);
                    $divTag.removeClass($divClass);
                    $iconTag.addClass("glyphicon-chevron-right");
                    $iconTag.removeClass($iconClass + " " + $divClass);
          		}, $msgShowTime);
            }
        });
        
    </script>


</body>

</html>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Account Setup - Expense Reimbursement System</title>

	<link rel="shortcut icon" href="./img/favicons/ers.ico">
	<link rel="icon" sizes="16x16 32x32 64x64" href="./img/favicons/ers.ico">
	<link rel="icon" type="image/png" sizes="196x196" href="./img/favicons/ers-192.png">
	<link rel="icon" type="image/png" sizes="160x160" href="./img/favicons/ers-160.png">
	<link rel="icon" type="image/png" sizes="96x96" href="./img/favicons/ers-96.png">
	<link rel="icon" type="image/png" sizes="64x64" href="./img/favicons/ers-64.png">
	<link rel="icon" type="image/png" sizes="32x32" href="./img/favicons/ers-32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="./img/favicons/ers-16.png">
	<link rel="apple-touch-icon" href="./img/favicons/ers-57.png">
	<link rel="apple-touch-icon" sizes="114x114" href="./img/favicons/ers-114.png">
	<link rel="apple-touch-icon" sizes="72x72" href="./img/favicons/ers-72.png">
	<link rel="apple-touch-icon" sizes="144x144" href="./img/favicons/ers-144.png">
	<link rel="apple-touch-icon" sizes="60x60" href="./img/favicons/ers-60.png">
	<link rel="apple-touch-icon" sizes="120x120" href="./img/favicons/ers-120.png">
	<link rel="apple-touch-icon" sizes="76x76" href="./img/favicons/ers-76.png">
	<link rel="apple-touch-icon" sizes="152x152" href="./img/favicons/ers-152.png">
	<link rel="apple-touch-icon" sizes="180x180" href="./img/favicons/ers-180.png">
	<meta name="msapplication-TileColor" content="#FFFFFF">
	<meta name="msapplication-TileImage" content="./img/favicons/ers-144.png">
	<meta name="msapplication-config" content="./img/favicons/browserconfig.xml">

	<!--jQuery-->
  <script src="https://code.jquery.com/jquery-3.2.1.js"
    integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
    crossorigin="anonymous"></script>

  <!-- Tether -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
    integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
    crossorigin="anonymous"></script>

  <!--Bootstrap 4-->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
    integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
    crossorigin="anonymous">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
    integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
    crossorigin="anonymous"></script>
  
  <!--Material Design Icons-->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="./css/icon-styles.css">

  <link rel="stylesheet" href="./css/ers.css">
</head>
<body class="setup">
  <div class="container">
    <#if setupAttempted??>
      <#if setupAttempted>
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
          <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <i class="material-icons">close</i>
          </button>
          <i class="material-icons vert-align-middle">error</i> 
          Failed to set new password. Please try again.
        </div>
      </#if>
    </#if>

    <form name="setupForm" class="form-page" method="POST" action="setup">
      <h2 class="form-page-heading">Please set a password for your account.</h2>
      <label for="setupPassword" class="sr-only">Password</label>
      <input type="password" name="pw" id="setupPassword" class="form-control" placeholder="Password"
        maxlength="100" minlength="8" required autofocus>
      <label for="setupConfirm" class="sr-only">Confirm Password</label>
      <input type="password" name="cp" id="setupConfirm" class="form-control" placeholder="Confirm Password"
        maxlength="100" minlength="8" required title="The password fields must match.">
      <br>
      <button type="submit" class="btn btn-lg btn-primary btn-block">
        <span class="align-middle">Save&nbsp;Password&nbsp;&nbsp;</span><i class="material-icons align-middle">lock</i>
      </button>
    </form>
  </div>

  <script type="text/javascript">
    $(document).ready(function() {
      $('#setupPassword').on('change', function() {
        $('#setupConfirm').attr('pattern', '^' + $('#setupPassword').val() + '$');
      });
    });
  </script>
</body>
</html>
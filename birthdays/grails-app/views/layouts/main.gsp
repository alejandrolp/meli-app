<!DOCTYPE html>

<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Gifts"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="http://www.fancyicons.com/free-icons/147/gifts/png/256/box3_256.png" type="image/x-icon">
		<link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
		<link href='http://fonts.googleapis.com/css?family=Indie+Flower' rel='stylesheet' type='text/css'>
  		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>

		<script type="text/javascript">
			var urlGlobal =  '${createLink(controller: 'regalos')}';
		</script>

		<g:layoutHead/>
	</head>
	<body>
		<sec:ifLoggedIn>
			<header>
				<div>Logged in as: ${sec.username()}</div>
				<div>
					<g:link controller="login" action="logout" id="logout" class="logout">LOGOUT</g:link>
				</div>
			</header>
		</sec:ifLoggedIn>
		<div id="grailsLogo" role="banner">
				<div class="title-div">
					<h2>BIRTHDAYS</h2>
				</div>
		</div>
		<g:layoutBody/>
		<div class="footer" role="contentinfo">
			<div class="powered-by">
			Powered by 	<a href="https://github.com/alejandrolp" target="_blank">♥Amendola</a> 
						<a href="https://github.com/jbordes" target="_blank">Bordes</a> 
						<a href="https://github.com/waltertw" target="_blank">Olivero</a>
			</div>
		</div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
	</body>
</html>

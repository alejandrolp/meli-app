<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
	</head>
	<body>
		<div id="main">
				<g:each status="i" var="employee" in="${employeeList}">
					<div class="main-row ${ (i % 2) == 0 ? 'grey' : 'white'}" id="row${employee.id}"> 
						<div class="employee">
<!-- 							<div class="employee-name">
								${employee.name}
							</div>
							<div class="employee-lastname">
								${employee.lastName}
							</div> -->
							${employee}
						</div>
						<div id="input-div">
							<button id="${employee.name}" onclick="addGift(this, ${employee.id})" class="" data-modal-id="popup">Asignar regalo</button>
						</div>
						<div class="gift-div" id="gift${employee.name}" data-gift-id="algooo">
							<g:if test="${employee.gifts != null && !employee.gifts.isEmpty()}">
								<img class='item-image' src="${employee.gifts.thumbnail}"/>
							</g:if>
							<g:if test="${employee.gifts != null && !employee.gifts.isEmpty()}">
								<p class="title">${employee.gifts.title}</p>
							</g:if>
						</div>
						</div>
					</div>
				</g:each>
		</div>
		<div id="popup" class="modal-box">  
		 	<header>
		    	<a href="javascript:closePopup()" class="js-modal-close close">×</a>
		    	<h3 id="dialog-text"></h3>
		  	</header>
		  	<div class="modal-body">
				<input class="input" type="text" id="search-text"></input>
	 			<div id="result-conteiner"></div>
		  	</div>
		</div>
	</body>
</html>
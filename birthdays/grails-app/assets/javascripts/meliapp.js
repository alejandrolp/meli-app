$(document).ready(function(){
	$("#search-text").keydown(search);

	$(document).keyup(function(e) {
  		if (e.keyCode == 27) { 

  			$(".modal-box, .modal-overlay").fadeOut(500, function() {
					$(".modal-overlay").remove();
				});

  		}   // escape key maps to keycode `27`
	});

	// Codigo para el dialogo modal

	$(function(){

		var appendthis =  ("<div class='modal-overlay js-modal-close'></div>");

		  $('button[data-modal-id]').click(function(e) {
		    e.preventDefault();
		    $("body").append(appendthis);
		    $(".modal-overlay").fadeTo(500, 0.7);
		    $(".js-modalbox").fadeIn(500);
		    var modalBox = $(this).attr('data-modal-id');
		    $('#'+modalBox).fadeIn($(this).data());

		    //change tittle
		    $("#dialog-text").text("Buscar regalo para " + this.id);
		    $()

		  });  
		  
		  
		$(".js-modal-close, .modal-overlay").click(
			function() {
				$(".modal-box, .modal-overlay").fadeOut(500, function() {
					$(".modal-overlay").remove();
				});
			}
		);
		 
		$(window).resize(function() {
		  $(".modal-box").css({
		    top: ($(window).height() - $(".modal-box").outerHeight()) / 2,
		    left: ($(window).width() - $(".modal-box").outerWidth()) / 2
		  });
		});
		 
		$(window).resize();
		 
		});
	});

vacio = false;

current_id = "";

function search(){

	_this = this;
	setTimeout(function() {
		if (!_this.value == "" & vacio){
			vacio = !vacio;
			animateResult();
		} else{ 
				if (_this.value == "" & !vacio){
					vacio = !vacio;
					animateResult();
				}
		}

		$("#result-conteiner").empty();
		$("#result-conteiner").append("<img class='ajax-loader' src='/birthdays/assets/ajax-loader.gif'>");
		
		var url_meli = "https://api.mercadolibre.com/sites/MLA/search?q=" + _this.value;
		var promise = $.get(url_meli);
		promise.done(processResult);

		}, 0);
};

function animateResult(){
	$("#result-conteiner").animate({
			    // opacity: 0.25,
			    width: [ "toggle", "swing" ],
				height: [ "toggle", "swing" ],
				opacity: "toggle"
			  }, 500, function() {
			    // cuando termina la animacion
			  });
}

function processResult(data){

	$("#result-conteiner").empty();

	if (!data.results.length){
		$("#result-conteiner").append("<p class='no-result'> No hay resultados </p>");
	};

	data.results.forEach(function(item, index){

		var div_item;
		if(index % 2){
			div_item = "<div class='row white-search' id='"+item.id+"'>"+"<img class='item-image' id='img" + item.id + "' src='"+item.thumbnail+"'/>"+ "<a id='link" + item.id + "' class='title' target='_blank' href="+ item.permalink + ">"+item.title+"</a>" + "</div>"
		} else {
			div_item = "<div class='row grey-search' id='"+item.id+"'>"+"<img class='item-image' id='img" + item.id + "' src='"+item.thumbnail+"'/>"+ "<a id='link" + item.id + "' class='title' target='_blank' href="+ item.permalink + ">"+item.title+"</a>" +  "</div>"	
		}
		$("#result-conteiner").append(div_item);
	});

	$(".row").bind("click", function(){

				addGiftToEmployee(this);

				$(".modal-box, .modal-overlay").fadeOut(500, function() {
					$(".modal-overlay").remove();
				});
		});

};

function addGiftToEmployee(gift_div){


	var postUrl = "http://localhost:8080/birthdays/regalos";

	var gift = $(gift_div);

	var idEmployee = current_id;

	var idItem = $(gift_div).attr("id");

	var url = $("#link" + idItem).attr("href");

	var thumbnail = $("#img" + idItem).attr("src");

	var year = new Date().getFullYear();
	 
	var params = {employee: idEmployee, idItem: idItem, year: year, url: url, thumbnail: thumbnail};

	var promise = $.post(postUrl, params);

	var idOldGift = $("#gift"+current_id).data("gift-id");

	console.log(idOldGift);

	if (idOldGift == "[]") {
		deleteGift(idOldGift);
	}

	postGift(idEmployee, idItem, year, url, thumbnail);

	$("#gift"+current_id).data("gift-id", idItem);

	$("#gift"+current_id).html($(gift_div).html());

};


function addGift(_this, id){
	current_id = $(_this).attr("id");
	$( "#dialog" ).dialog({
      resizable: false,
      height:140,
      modal: true,
      buttons: {
        "Delete all items": function() {
          $( this ).dialog( "close" );
        },
        Cancel: function() {
          $( this ).dialog( "close" );
        }
      }
    });
};

function closePopup(){

	//cuando cierra popup

}


function deleteGift(idGift){

	var deleteUrl = "http://localhost:8080/birthdays/regalos/" + idGift;

    	$.ajax({
			url: deleteUrl,
			type: 'DELETE',
			success: function(data){console.log("Gift " + idGift + " deleted");},
			error: function(error){console.log(error);}
		});
}

function postGift(idEmployee, idItem, year, url, thumbnail){

	var postUrl = "http://localhost:8080/birthdays/regalos?";

	postUrl += "employee=" + idEmployee;
	postUrl += "&idItem=" + idItem;
	postUrl += "&year=" + year;
	postUrl += "&url=" + url;
	postUrl += "&thumbnail=" + thumbnail;

		
	var promise = $.post(postUrl);

	promise.done(function processResult(data) {
		console.log(data);
	});

	promise.fail(function processError(error) {
		console.log(error);
	});	
}
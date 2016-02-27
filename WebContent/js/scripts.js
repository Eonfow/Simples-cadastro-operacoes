$(document).ready(
	function(){
		$('.ui.dropdown').dropdown();
		
		$('.ui.checkbox').checkbox();
		
		$('.ui.checkbox').popup({
		    position : 'right center',
		    target   : '.ui.checkbox',
		    title    : 'Termos e Condicões',
		    content  : 'Trens podem ser chamados como "Aviões Lentos".'
		});
		
		$('.ui.form').form(validationRules);
	}
);

$(document).on('click', '.sidebar.icon',function(){
	
	$('.ui.labeled.icon.sidebar').sidebar('toggle');
	
});


$(document).on('click', '.blue.item', function(){
	$('.ui.form.container').addClass('loading');
});

function registrarOperacao(){
	
	$('.ui.form.container').addClass('loading');
	
	var data = {
				'codigo' 			: $('#codigo').prop('value') ,
				'tipoNegocio' 		: $('#tipoNegocio').dropdown('get value') ,
				'nomeMerc' 			: $('#nomeMerc').prop('value') ,
				'precoTotal' 		: $('#precoTotal').prop('value') ,
				'quant' 			: $('#quant').prop('value') ,
				'tipoMercadoria' 	: $('#tipoMercadoria').dropdown('get value')
			   }
	
	$.ajax({
	    url: 'TransacaoServlet',
	    type: 'POST',
	    data: JSON.stringify(data),
	    dataType: 'json',
	    sucess: function(respJson){
	    	$('.ui.form.container').removeClass('loading');
	    	alert("Sucesso ao registrar operacao!");
	    },
	    error: function(respJson){
	    	$('.ui.form.container').removeClass('loading');
	    	alert("Falha ao registrar operacao");
	    }
	});
}
	
var validationRules = {
	    fields: {
	      quant: {
	    	identifier: 'quant',
		    rules: [
		       {
		  		 type   : 'empty',
		  		 prompt : 'Entre com uma quantidade'
		  	   },
		  	   {
		  		 type	 : 'integer',
		         prompt  : 'Quantidade deve ser um numero inteiro.'
		       },
		       {
			  	 type	 : 'not[0]',
			     prompt  : 'Quantidade deve ser um numero inteiro.'
			   }
		    ]
	      },
	      name: {
	        identifier: 'codigo',
	        rules: [
			  {
			 	type   : 'empty',
		       	prompt : 'Entre com um codigo da mercadoria'
			  },
	          {
	        	type	: 'integer',
	            prompt  : 'Código deve ser um numero inteiro.'
	          }
	        ]
	      },
	      tipoMercadoria: {
	        identifier: 'tipoMercadoria',
	        rules: [
	          {
	            type   : 'empty',
	            prompt : 'Selecione um tipo de mercadoria'
	          }
	        ]
	      },
	      tipoNegocio: {
	        identifier: 'tipoNegocio',
	        rules: [
	          {
	            type   : 'empty',
	            prompt : 'Selecione um tipo de negócio'
	          }
	        ]
	      },
	      nomeMerc: {
	        identifier: 'nomeMerc',
	        rules: [
	          {
	            type   : 'empty',
	            prompt : 'Entre com um nome para a mercadoria'
	          }
	        ]
	      },
	      precoTotal: {
	        identifier: 'precoTotal',
	        rules: [
	          {
	            type   : 'empty',
	            prompt : 'Entre com o preco total da operção'
	          },
	          {
	            type   : 'number',
	            prompt : 'Preco deve ser um numero decimal'
	          }
	        ]
	      },
	      terms: {
	        identifier: 'terms',
	        rules: [
	          {
	            type   : 'checked',
	            prompt : 'You must agree to the terms and conditions'
	          }
	        ]
	      }
	    }
	  };
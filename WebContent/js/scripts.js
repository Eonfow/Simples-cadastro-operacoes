$(document).ready(
	function(){
		
		formValidation();
		
		$('.ui.dropdown').dropdown();
		
		$('.ui.checkbox').checkbox();
		
		$('.ui.checkbox').popup({
		    position : 'right center',
		    target   : '.ui.checkbox',
		    title    : 'Terms and Conditions',
		    content  : 'Trains can be called "Slow Planes".'
		});
	}
);

$(document).on('click', '.sidebar.icon',function(){
	
	$('.ui.labeled.icon.sidebar').sidebar('toggle');
	
});


$(document).on('click', '.blue.item', function(){
	$('.ui.form.container').addClass('loading');
});

function formValidation(){
	$('.ui.form')
	  .form({
	    fields: {
	      name: {
	        identifier: 'codigo',
	        rules: [
	          {
	        	type	: 'exactLength[5]',
	            prompt  : 'Code must be a 5 digits number.'
	          }
	        ]
	      },
	      skills: {
	        identifier: 'skills',
	        rules: [
	          {
	            type   : 'minCount[2]',
	            prompt : 'Please select at least two skills'
	          }
	        ]
	      },
	      gender: {
	        identifier: 'gender',
	        rules: [
	          {
	            type   : 'empty',
	            prompt : 'Please select a gender'
	          }
	        ]
	      },
	      username: {
	        identifier: 'username',
	        rules: [
	          {
	            type   : 'empty',
	            prompt : 'Please enter a username'
	          }
	        ]
	      },
	      password: {
	        identifier: 'password',
	        rules: [
	          {
	            type   : 'empty',
	            prompt : 'Please enter a password'
	          },
	          {
	            type   : 'minLength[6]',
	            prompt : 'Your password must be at least {ruleValue} characters'
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
	  });
}
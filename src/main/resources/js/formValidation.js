/* 
 * Below is a form validation module that is reusable for any forms across the entire site
 * the only methods and variables that can be accesses are defined within the object that 
 * the modules return
 * 
 * 
 */

let formValidation = (function(){
	
	let // adds the required attribute to any element with the data-required class
		addRequired = function(element){
			if(element.classList.contains('data-required')){
				element.setAttribute("required", "");
			}
		},
		checkPasswords = function(){
			let 
				password = document.querySelector('#password'),
				repassword = document.querySelector('#repassword');
		
				if(password.value !== repassword.value){
					console.log('please put the same password for both password fields')
					
					return false;
				}
				
				else {
					return true;
				}
		},
		checkRequired = function(){
			let requiredData = document.querySelectorAll('[required]');	
			for(var i = 0; i < requiredData.length; i++){
				let isValid = true;
				if(!requiredData[i].checkValidity()){
					isValid = false;
				}
				return isValid;
			}
		},
		checkEmail = function(){
			let emailData = document.getElementById('email'),
				isValid = true;
				if(!emailData.checkValidity()){
					isValid = false;
				}
				return isValid;
		},
		checkUsername = function(){
			let 
				username = document.getElementById('username'),
				isValid = true;
				
				if(!username.checkValidity()){
					isValid = false;
				}
			return isValid;
		},
		prepareForm = function(form){
			let formEl = form.elements;
			for(var i = 0; i < formEl.length; i++){
				addRequired(formEl[i]);
			}
		},
		
		validate = function(form){
			// each of these function checks certain aspects of the inputs, if one of them
			// is false, the form will not send data.
			if(!checkRequired() || !checkEmail() || !checkUsername() || !checkPasswords()){
				alert('make sure you complete all fields properly!');
			}
			else {
				form.submit();
				console.log('the form has been submitted!');
			}
			
		},
		
		init = function(form){
			prepareForm(form);
		}
	
	
	
	return {
		validate:validate,
		init:init

	}
	
	
})();

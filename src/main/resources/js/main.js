
// the purpose of this method is to retrieve JSON data from the links the controllers 
// or spring mvc generates
let getJsonData = (url)=>{
        let result = [];
        $.getJSON(url, (data)=>{
            data.forEach((x)=>{
                result.push(x);
            })
        })

        return result;
};      

// the vuex store stores data at a centralised location for all vue components to retrive data 
// without the need of emitiing or porpping down data.
//Vuex Store
let store = new Vuex.Store({
	state:{
		hotels:   getJsonData('/HotelReviews/hotels'),
		reviews:  getJsonData('/HotelReviews/reviews'),
		requests: getJsonData('/HotelReviews/admin/requests'),
		users:	getJsonData('/HotelReviews/admin/users'),
		countries: getJsonData('/HotelReviews/js/countries.json')
	},// end of state
	
	getters: {
		getAllHotels:(state)=>{
			return state.hotels
		},
		getAllReviews:(state)=>{
			return state.reviews
		},
		getAllRequests:(state)=>{
			return state.requests
		},
		getAllUsers:(state)=>{
			return state.users
		},
		getAllCountries:(state)=>{
			return state.countries
		}
	}
	
})

// components
Vue.component ('hotel', {
	data:function(){
		return {
			id:'',
			hotels: store.getters.getAllHotels,
			reviews: store.getters.getAllReviews,
		}
	},// end of data
	methods: {
		disableLinks: function(){
			$("a.noredirect").click(function(e){
				e.preventDefault();
				console.log('clicked!');
			});
		}
	},
	created: function(){
		this.id = this.$root.getObjectId(window.location.href);
		console.log(this.id);
	}
  });
  
Vue.component('dashboard',{
	  data: function(){
		  return {
			  dashBoardLinks:[
				  {
					  name:'View Hotels',
					  path:'/HotelReviews/admin/viewhotels',
					  description:' Here you can view all the hotels registered in the system, \n\
					remove hotels from the system and view all reviews made for a particular hotel'
				  },
				  {
					  name:'View Requests',
					  path:'/HotelReviews/admin/viewrequests',
					  description:'Here you can view all hotels wanting to be registered on the the system,\n\
						you can also approve requests to add hotels to the system.'
				  },
				  {
					  name:'View Users',
					  path:'/HotelReviews/admin/viewusers',
					  description:'Here you can see all users in the system which includes reviews and admins'
				  }
			  ],
		  }
	  }// end of data
  });
  
Vue.component('signup', {
// end of data
	  methods:{
		  validation:function(event){
			  event.preventDefault();
			  console.log('clicked!');
			  let form = document.getElementById('form-validate');
			  formValidation.validate(form);
		  },
	  },
	  mounted: function(){
		 let form = document.getElementById('form-validate');
		 formValidation.init(form);
	  }
  });
  
Vue.component('requests',{
	data:function(){
		return {
			countries:store.getters.getAllCountries
		}
	},
	methods:{
		validation: function(){
			let form = document.getElementById('form-validate');
			formValidation.validate(form);
		}
	},
	mounted:function(){
		let form = document.getElementById('form-validate'),
			countrySelect = document.getElementById('country_select'),
			country = document.getElementById('country');
	
			countrySelect.addEventListener("change", (e)=>{
				country.value = countrySelect.value;
			});
		formValidation.init(form);
	}
	
});

Vue.component('allhotels', {
	data:function(){
		return {
			hotels:store.getters.getAllHotels
		}
	}
});

Vue.component('allrequests', {
	data:function(){
		return {
			requests: store.getters.getAllRequests
		}
	}
});

Vue.component('allusers', {
	data:function(){
		return {
			users:store.getters.getAllUsers
		}
	}
})

// the main vue instance in charge of the entire application
let app = new Vue({
    el:'#app',
    data:{
        allHotels:store.getters.getAllHotels,        
		allRequests:store.getters.getAllRequests,
		countries:store.getters.getAllCountries
	}, // end of data
	
	methods: {
		getObjectId: function(url){
						let arr = url.split("/");
						
						return arr[arr.length -1];
					},
		getObjectData: function(arr, id){
			
			return arr.find((x)=>{
				x.id === id;
			})
		}
	}// end of methods

});

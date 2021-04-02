<%@include file="../header.jsp" %>

<allrequests inline-template>
	<main>
		<div class="row" v-for="request in requests">
			<hr>
			<div class="col-4 col-sm-4 col-md-4 col-lg-4 col-xl-4">		
				<b>Hotel name:</b>
				<p>{{request.hotel_name}}</p>
				<b>Location:</b>
				<p>{{request.country}}</p>
				<p>{{request.hotel_address}}</p>
				<p>{{request.city}}</p>
				
				<b>Contact:</b>
				<p>{{ request.user_email }}</p>
			</div>
			<div class="col-4 col-sm-4 col-md-4 col-lg-4 col-xl-4">
				<p>{{ request.message }}</p>
			</div>
			<div class="col-2 col-sm-2 col-md-2 col-lg-2 col-xl-2">
				<a v-bind:href="'/HotelReviews/admin/acceptrequest?pid=' + request.id" disabled 
				class="btn btn-secondary">Accept request</a>
			</div>
			<div class="col-2 col-sm-2 col-md-2 col-lg-2 col-xl-2">
				<a v-bind:href="'/HotelReviews//admin/removerequest?pid=' + request.id" disabled 
				class="btn btn-secondary">Delete request</a>
			</div>
			</div>
		</div>
	</main>
</allrequests>

<%@include file="../footer.jsp" %>
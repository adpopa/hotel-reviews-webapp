<%@include file="../header.jsp" %>
<allhotels inline-template>
	<main>
		<div class="row" v-for="hotel in hotels">
			<div class="col-3 col-sm-3 col-md-3 col-lg-3 col-xl-3">
				<p>Hotel name:{{hotel.name}}</p>
			</div>
			<div class="col-2 col-sm-2 col-md-2 col-lg-2 col-xl-2">
				<b>Location: </b>
				<p>Country:{{hotel.country}}</p>
				<p>City:{{hotel.city}}</p>
			</div>
			<div class="col-3 col-sm-3 col-md-3 col-lg-3 col-xl-3">
				<p>Address:{{hotel.address}}</p>
			</div>
			<div class="col-3 col-sm-3 col-md-3 col-lg-3 col-xl-3">
				<p>Email:{{hotel.email}}</p>
			</div>
			<div class="col-1 col-sm-1 col-md-1 col-lg-1 col-xl-1">
				<a v-bind:href="'/HotelReviews/admin/removehotel?pid=' + hotel.id" 
				   disabled class="btn btn-secondary">Delete hotel</a>
			</div>
		</div>
	</main>
</allhotels>
<%@include file="../footer.jsp" %>
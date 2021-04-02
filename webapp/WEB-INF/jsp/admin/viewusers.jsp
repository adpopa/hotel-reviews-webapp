<%@include file="../header.jsp" %>

<allusers inline-template>
	<main>
		<div class="row" v-for="user in users">
			<div class="col-4 col-sm-4 col-md-4 col-lg-4 col-xl-4">
				<p> Username: {{user.username}}</p>
				<p> First name: {{user.fname}}</p>
				<p> Last name: {{user.username}}</p>
				<p> Email: {{user.email}}</p>
				<p> role: {{user.userType}}</p>
				<hr>
			</div>
			<div class="col-4 col-sm-4 col-md-4 col-lg-4 col-xl-4">
				<a v-bind:href="'/HotelReviews/admin/promoteuser?pid=' + user.id" 
				   disabled class="btn btn-secondary">Promote</a>
			</div>
			<div class="col-4 col-sm-4 col-md-4 col-lg-4 col-xl-4">
				<a v-bind:href="'/HotelReviews/admin/removeuser?pid=' + user.id" 
				   disabled class="btn btn-secondary">Remove</a>
			</div>
		</div>
	</main>
</allusers>
<%@include file="../footer.jsp" %>
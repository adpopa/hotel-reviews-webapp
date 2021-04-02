<%@include file="./header.jsp"%>

<requests inline-template>
	<form:form class="form-group"
		method="POST" action="/HotelReviews/request" modelAttribute="request" id="form-validate">
		<div class="form-group">
			<form:label path="hotel_name"> Hotel Name </form:label>
			<form:input path="hotel_name" class="form-control data-required" />
		</div>
		<div class="form-group">
			<form:label path="user_email">Hotel email</form:label>
			<form:input path="user_email" class="form-control data-required" 
			pattern="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$" />
		</div>
		<div class="form-group">
			<form:label path="city">City</form:label>
			<form:input path="city" class="form-control data-required" />
		</div>
		<div class="form-group">
			<form:label path="country">Country:</form:label>
			<select id="country_select" required>
				<option>Choose country</option>
				<option v-for="country in countries">{{country.name}}</option>
			</select>
			<form:input path="country" class="form-control" />
		</div>
		<div class="form-group">
			<form:label path="hotel_address">Hotel address</form:label>
			<form:input path="hotel_address" class="form-control data-required" />
		</div>
		<div class="form-group">
			<form:label path="message"> Message </form:label>
			<form:textarea path="message" class="form-control data-required" rows="5" />
		</div>
		<div class="row">
			<div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
				<input type="submit" v-on:click="">
			</div>
		</div>
	</form:form> 
</request>

<%@include file="./footer.jsp"%>
<%@include file = "./header.jsp" %>
<signup inline-template>
	<form:form class="form-group" method="POST" action="/HotelReviews/register" modelAttribute = "user" id="form-validate">
		<div class="form-group">
			<form:label path="username"> Username </form:label><form:errors path="username"/>
			<form:input path="username" class="form-control data-required"/>
			<small class="form-text text-muted">Make sure your username has at least 5 characters with no spaces</small>
		</div>
		<div class="form-group">
			<form:label path="email">Email address</form:label>
			<form:input path="email" class="form-control data-required" pattern="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"/>
		</div>
		<div class="form-group">
			<form:label path="fName">First name</form:label>
			<form:input path="fName" class="form-control data-required" />
		</div>
		<div class="form-group">
			<form:label path="lName">Last name</form:label>
			<form:input path="lName" class="form-control data-required" />
		</div>
		<div class="form-group">
			<form:label path="password">Password</form:label>
			<form:input path="password" class="form-control data-required data-password" type="password"/>
		</div>
		<div class="form-group">
			<label>Confirm password</label></br>
			<input type="password" name="repassword" class="data-password" required id="repassword">
		</div>
		<div class="row">
			<div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
				<input type="submit" v-on:click="validation($event)">
			</div>
		</div>
	</form:form>
</signup>
<%@include file = "./footer.jsp" %>
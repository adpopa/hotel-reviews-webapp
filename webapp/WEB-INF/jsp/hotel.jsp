<%-- 
    Document   : hotel
    Created on : 25-Nov-2018, 00:56:44
    Author     : christopher
--%>

<%@include file = "./header.jsp" %>
<hotel inline-template>
    <div id="hotel">
        <header v-for="hotel in hotels" v-if="hotel.id === id" class="row">
            <div class="col-6 col-sm-6 col-md-6 col-lg-6 col-xl-6">
                <h1>{{hotel.name}}</h1>
            </div>
            <div class="col-6 col-sm-6 col-md-6 col-lg-6 col-xl-6">
                <ul>
                    <li> Address: {{hotel.address}}</li>
                    <li> City: {{hotel.city}}</li>
                    <li> Country: {{hotel.country}}</li>
                    <li> email: {{ hotel.email }}</li>
                </ul>
            </div>
        </header>
        <hr>
        <main>
            <div class="row">
                <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                    <h2>Reviews</h2>
                </div>
            </div>
            <section v-for="review in reviews" v-if="review.hotel.id === id">
				<div class="row">
					<div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <b>From: {{review.user.username}}</b>
                    </div>
				</div>
                <div class="row">
                    <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <hr>
                    </div>
                </div>
                <div class="row">
                    <div class="col-5 col-sm-5 col-md-5 col-lg-5 col-xl-5">
                        <h5> Rating: {{review.rating}}/5</h5>
                    </div>
                    <div class="col-7 col-sm-7 col-md-7 col-lg-7 col-xl-7">
                        <b>{{ review.dateOfReview }}</b>
                        <p>{{review.comment}}</p>
                    </div>
                </div>
                <div class="row">
					<sec:authorize access="hasRole('ADMIN')">
		        <li class="nav-item">
					<a v-bind:href="'/HotelReviews/review?pid=' + review.id"
					   class="btn btn-secondary">Delete review</a>
					<c:url value="/review/{id}" var="url" context="/HotelReviews">
                        <c:param name="pid" value="review.id" />
                    </c:url>
				</li>
		    </sec:authorize>
			<sec:authorize access="hasRole('USER')">
		        <li class="nav-item">
		            USER
		        </li>
		    </sec:authorize>
                </div>
            </section>
		    <sec:authorize access="isAuthenticated()">
		        <form:form class="form-group" method="POST" action="/HotelReviews/hotel/${id}" modelAttribute="review">
		            <div class="form-group">
		            	<form:label path="comment"> Comment </form:label>
		            	<form:textarea path="comment" class="form-control" htmlEscape="true" rows="5"/>
		            </div>
		            <form:select items="${ratingSelector}" path="rating" class="form-check form-check-inline"/>
					<div class="row">
		                <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
		                    <input type="submit">
		                </div>
		            </div>
		        </form:form>
		    </sec:authorize>

    	</main>
    </div>
</hotel>
<%@include file = "./footer.jsp" %>

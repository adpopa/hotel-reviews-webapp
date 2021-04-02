<%@include file = "header.jsp" %>
    <header class="jumbotron">
        <div class="row">
            <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                <h1 class="display-1">Bon voyage!</h1>
				<p> here you can view all the possible hotel destinationa. If you
					are a user you can leave a review for each hotel</p>
				<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
            		<p> Dear <strong>${username}</strong>, Welcome to ${authority} Page. </p>
            	</sec:authorize>
            </div>
        </div>
    </header> <!--end of jumbotron -->
    <main>
        <div class="row">
            <div class="col-3 col-sm-3 col-md-3 col-lg-3 col-xl-3">
                <h4>Hotel name</h4>
            </div>
            <div class="col-3 col-sm-3 col-md-3 col-lg-3 col-xl-3">
                <h4>Hotel Country</h4>
            </div>
            <div class="col-3 col-sm-3 col-md-3 col-lg-3 col-xl-3">
                <h4>Hotel City</h4>
            </div>
            <div class="col-3 col-sm-3 col-md-3 col-lg-3 col-xl-3">
                <h4>Hotel address</h4>
            </div>
        </div>
        <hr>
        <div v-for="hotel in allHotels" class="row">
            <div class="col-3 col-sm-3 col-md-3 col-lg-3 col-xl-3">
                <a v-bind:href='"./hotel/" + hotel.id'>{{ hotel.name }}</a>
            </div>
            <div class="col-3 col-sm-3 col-md-3 col-lg-3 col-xl-3">
                {{ hotel.country }}
            </div>
            <div class="col-3 col-sm-3 col-md-3 col-lg-3 col-xl-3">
                {{ hotel.city }}
            </div>
            <div class="col-3 col-sm-3 col-md-3 col-lg-3 col-xl-3">
                {{ hotel.address }}
            </div>
        </div>
    </main>
   
<%@include file = "footer.jsp" %>
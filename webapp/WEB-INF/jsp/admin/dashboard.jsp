<%@include file = "../header.jsp" %>
<header>
	<div class="row">
		<div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
			<h1 class="display-1">Dashboard</h1>
			<hr>
			<p>Welcome to the dashboard of admin</p>
			<hr>
		</div>
	</div>
</header>
<main>
	<dashboard inline-template>
		<main id="Dashboard">
			<section v-for="link in dashBoardLinks">
				<div class="row">
					<div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
						<h2>
							<a class="nav-link" v-bind:href="link.path">{{link.name}}</a>
						</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
						<p>{{link.description}}</p>
					</div>
				</div>
			</section>
		</main>
	</dashboard>
</main>
<%@include file = "../footer.jsp" %>
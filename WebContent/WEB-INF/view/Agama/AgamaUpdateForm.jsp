<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="../Head.jsp"></jsp:include>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">

			<jsp:include page="../HeaderSidebar.jsp"></jsp:include>


			<!-- MAIN HERE -->
			<article class="content forms-page">
				<!-- Form -->
				<section class="section">
					<div class="row sameheight-container">
						<div class="col-md-3"></div>
						<div class="col-md-6">
						
							<!-- MAIN HERE -->
							<div class="card card-block sameheight-item">
								<div class="title-block">
									<h3 class="title">Data Agama</h3>
								</div>

								<form:form modelAttribute="agamaModel" method="POST"
									action="update">
									<form:hidden path="agama_id" />

									<div class="form-group">
										<label for="exampleInputPassword1">Nama</label>
										<form:input path="agamaNama" class="form-control" />
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Keterangan</label>
										<form:input path="agamaKeterangan" class="form-control" />
									</div>

									<div class="form-group">
										<button type="submit" class="btn btn-primary">Update</button>
									</div>
								</form:form>
							</div>
							
							<!-- END MAIN HERE -->
						</div>
					</div>
				</section>
				<!-- End Form -->

			</article>
			<!-- END MAIN HERE -->
		</div>
	</div>
</body>
</html>
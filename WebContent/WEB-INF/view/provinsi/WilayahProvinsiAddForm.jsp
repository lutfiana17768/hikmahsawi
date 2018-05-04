<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../Head.jsp"></jsp:include>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">

			<jsp:include page="../HeaderSidebar.jsp"></jsp:include>


			<!-- MAIN HERE -->

				<article class="content forms-page">
					<section class="section">
						<div class="row sameheight-container">
							<div class="col-md-3"></div>
							<div class="col-md-6">
								<div class="card card-block sameheight-item">
									<div class="title-block">
										<h3 class="title"> Data Provinsi </h3>
									</div>
									<form:form modelAttribute="provinsiModel" method="POST" action="store">
									
										<div class="form-group">
											<label for="exampleInputEmail1">Kode Provinsi</label>
												<form:input path="propinsiKode" placeholder="Masukan Kode Provinsi" class="form-control"/>
											</div>
										<div class="form-group">
											<label for="exampleInputPassword1">Nama Provinsi</label>
												<form:input path="propinsiNama" placeholder="Masukan Nama Provinsi" class="form-control"/>
											 </div>
										<div class="form-group">
											<button type="submit" class="btn btn-primary">Simpan</button>
										</div>
									</form:form>
								</div>
							</div>
						</div>
					</section>
				</article>
			<!-- END MAIN HERE -->
		</div>
	</div>
</body>
</html>
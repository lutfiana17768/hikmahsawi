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
										<h3 class="title"> Data Kecamatan </h3>
									</div>
									<form:form modelAttribute="kecamatanModel" action="store" method="POST">		
										<div class="form-group">
											<label for="exampleInputEmail1">Kode Kecamatan</label>
												<form:input path="kecamatanKode" placeholder="Masukan Kode Kota" class="form-control" />
											</div>
										<div class="form-group">
											<label for="exampleInputPassword1">Nama Kecamatan</label>
												<form:input path="kecamatanNama" placeholder="Masukan Nama Kota" class="form-control" />
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">Nama Kota</label>
											<div class="select2-wrapper">
												<form:select path="kotaKode" class="form-control input-lg select2-single">
													<form:option value="" />
													<c:forEach var="tempKota" items="${kota}">
			                                         	<form:option value="${tempKota.kotaKode }" label="${tempKota.kotaNama }" />
			                                         </c:forEach>
												</form:select>
											</div>
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

<script>
	$( ".select2-single, .select2-multiple" ).select2( {
		theme: "bootstrap",
		placeholder: "Pilih Kota",
		maximumSelectionSize: 6,
		containerCssClass: ':all:'
	} );

	$( ":checkbox" ).on( "click", function() {
		$( this ).parent().nextAll( "select" ).prop( "disabled", !this.checked );
	});
</script>
   
</body>
</html>
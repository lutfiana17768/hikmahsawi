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
										<h3 class="title"> Data Kota </h3>
									</div>
									<form:form modelAttribute="kotaModel" method="POST" action="store">		
										<div class="form-group">
											<label for="exampleInputEmail1">Kode Kota</label>
												<form:input path="kotaKode"  placeholder="Masukan Kode Kota" class="form-control" />
											</div>
										<div class="form-group">
											<label for="exampleInputPassword1">Nama Kota</label>
												<form:input path="kotaNama" placeholder="Masukan Nama Kota" class="form-control" />
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">Nama Provinsi</label>
											<div class="select2-wrapper">
												<form:select  path="propinsiKode" class="form-control input-lg select2-single">
													<form:option value=""></form:option>
													
													<c:forEach var="tempProvinsi" items="${provinsi}">
			                                         	<form:option value="${tempProvinsi.propinsiKode }" label="${tempProvinsi.propinsiNama }" />
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
		placeholder: "Pilih Provinsi",
		maximumSelectionSize: 6,
		containerCssClass: ':all:'
	} );

	$( ":checkbox" ).on( "click", function() {
		$( this ).parent().nextAll( "select" ).prop( "disabled", !this.checked );
	});
</script>
   
</body>
</html>
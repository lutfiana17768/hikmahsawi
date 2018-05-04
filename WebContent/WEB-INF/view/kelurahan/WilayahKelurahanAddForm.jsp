<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../Head.jsp"></jsp:include>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">

			<jsp:include page="../HeaderSidebar.jsp"></jsp:include>

				<article class="content forms-page">
					<section class="section">
						<div class="row sameheight-container">
							<div class="col-md-3"></div>
							<div class="col-md-6">
								<div class="card card-block sameheight-item">
									<div class="title-block">
										<h3 class="title"> Data Kelurahan </h3>
									</div>
									<form:form modelAttribute="kelurahanModel" action="store" method="POST">		
										<div class="form-group">
											<label for="exampleInputEmail1">Kode kelurahan</label>
												<form:input path="kelurahanKode" placeholder="Masukan Kode Kelurahan" class="form-control" />
											</div>
										<div class="form-group">
											<label for="exampleInputPassword1">Nama kelurahan</label>
											<form:input path="kelurahanNama" placeholder="Masukan Nama Kelurahan" class="form-control" />
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">Nama Kecamatan</label>
											
											<div class="select2-wrapper">
												<form:select path="kecamatanKode" class="form-control input-lg select2-single" >
													<form:option value="" />
													<c:forEach var="tempkecamatan" items="${kecamatan}">
			                                         	<form:option value="${tempkecamatan.kecamatanKode }"  label="${tempkecamatan.kecamatanNama }" />
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
		placeholder: "Pilih Kecamatan",
		maximumSelectionSize: 6,
		containerCssClass: ':all:'
	} );

	$( ":checkbox" ).on( "click", function() {
		$( this ).parent().nextAll( "select" ).prop( "disabled", !this.checked );
	});
</script>
   
</body>
</html>
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
									<form:form modelAttribute="jabatanModel" method="POST" action="update">
										<form:hidden path="jabatan_id" />
										<form:hidden path="jabatanCreatedBy" />
										<form:hidden path="jabatanCreatedDate" />
										<form:hidden path="jabatanAktif" />
										
										<div class="form-group">
											<label for="exampleInputPassword1">Nama Jabatan</label>
												<form:input path="jabatanNama" class="form-control"  />
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">Jenis Jabatan</label>
												<form:select path="jabatanJenis" class="form-control form-control-sm" >
													<form:option value="NULL" label="--- Pilih Satu ---" />
													<form:option value="Fungsional" label="Fungsional" />
													<form:option value="Struktural" label="Struktural" />
												</form:select>
										</div>
                                         <div class="form-group">
											<label for="exampleInputPassword1">Keterangan Jenis Pegawai</label>
												<form:textarea path="jabatanKeterangan" placeholder="Masukan Keterangan" class="form-control" /> 
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
		placeholder: "Sub Jenis Pegawai",
		maximumSelectionSize: 6,
		containerCssClass: ':all:'
	} );

	$( ":checkbox" ).on( "click", function() {
		$( this ).parent().nextAll( "select" ).prop( "disabled", !this.checked );
	});
</script>
   
</body>
</html>
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
										<h3 class="title"> Data Gaji </h3>
									</div>
									<form:form modelAttribute="gajiModel" method="POST" action="store">		
										<div class="form-group">
											<label for="exampleInputEmail1">Gaji No</label>
												<form:input path="gajiNo"  placeholder="Masukan Nomer Gaji" class="form-control" />
											</div>
											
										<div class="form-group">
									        <label>Tanggal bayar</label>
									        <div class="input-group date">
                                       			<form:input path="gajiTglBayar" class="form-control" />
                                   					<span class="input-group-btn">
                                   						<button class="btn default date-set" type="button">
                                       						<i class="fa fa-calendar"></i>
                                   						</button>
                                   					</span>
                                   			</div>
									    </div>
										<div class="form-group">
											<label for="exampleInputPassword1">Gaji Bulan</label>
											<div class="select2-wrapper">
												<form:select path="gajiBulan" class="form-control input-lg select2-single">
													<form:option value="" label="--Pilih Satu---" />
													<form:option value="01" label="Januari" />
													<form:option value="02" label="Februari" />
													<form:option value="03" label="Maret" />
													<form:option value="04" label="April" />
													<form:option value="05" label="Mei" />
													<form:option value="06" label="Juni" />
													<form:option value="07" label="Juli" />
													<form:option value="08" label="Agustus" />
													<form:option value="09" label="September" />
													<form:option value="10" label="Oktober" />
													<form:option value="11" label="November" />
													<form:option value="12" label="Desember" />
												</form:select>
											</div>
                                         </div>
                                         <div class="form-group">
											<label for="exampleInputPassword1">Gaji Tahun</label>
												<form:input path="gajiTahun" placeholder="Masukan Tahun" class="form-control" />
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">Nama Pegawai</label>
											<div class="select2-wrapper">
												<form:select  path="gajiPegawaiId" class="form-control input-lg select2-single">
													<form:option value="000" label="--- Pilih Satu ---" />
													<c:forEach var="tempPegawai" items="${pegawai}">
			                                         	<form:option value="${tempPegawai.pegawai_id }" label="${tempPegawai.pegawaiNama }" />
			                                         </c:forEach>
												</form:select>
											</div>
                                         </div>
                                         <div class="form-group">
											<label for="exampleInputPassword1">Gaji Pokok</label>
												<form:input path="gajiPokok" placeholder="Masukan Gaji Pokok" class="form-control" />
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">Potongan</label>
												<form:input path="gajiPotongan" placeholder="Masukan Potongan" class="form-control" />
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">Bonus</label>
												<form:input path="gajiBonus" placeholder="Masukan Bonus" class="form-control" />
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">Pajak</label>
											<div class="select2-wrapper">
												<form:select path="gajiPajak" class="form-control input-lg select2-single">
													<form:option value="0" label="--Pilih Satu---" />
													<form:option value="5" label="5%" />
													<form:option value="10" label="10%" />
													<form:option value="15" label="15%" />
													<form:option value="20" label="20%" />
													<form:option value="25" label="25%" />
												</form:select>
											</div>
                                         </div>
										<div class="form-group">
											<label for="exampleInputPassword1">Keterangan</label>
												<form:textarea path="gajiKeterangan" placeholder="Masukan Keterangan" class="form-control" />
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
		placeholder: "Pilih Bulan",
		maximumSelectionSize: 6,
		containerCssClass: ':all:'
	} );

	$( ":checkbox" ).on( "click", function() {
		$( this ).parent().nextAll( "select" ).prop( "disabled", !this.checked );
	});
</script>
</body>
</html>
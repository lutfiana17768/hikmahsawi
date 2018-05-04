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
										<h3 class="title"> Data Pegawai </h3>
									</div>
									<form:form modelAttribute="pegawaiModel" method="POST" action="store" enctype="multipart/form-data">		
									
										<div class="form-group">
											<label  for="form_control_1">No Pegawai</label>
							                	<form:input path="pegawaiNo" placeholder="Masukan No Pegawai" class="form-control" />
										</div>
			
										<div class="form-group">
											<label  for="form_control_1">Nama Pegawai</label>
							                	<form:input path="pegawaiNama" class="form-control" placeholder="Masukan Nama Pegawai" />
										</div>
			
										<div class="form-group">
											<label  for="form_control_1">Jenis Kelamin</label>
							                	<form:select path="pegawaiKelamin" class="form-control form-control-sm" >
							                        <form:option value='N' label="---Pilih Satu---" />
							                        <form:option value='L' label="Laki-Laki" />
							                        <form:option value='P' label="Perempuan" />
							                    </form:select>
										</div>
										
										<div class="form-group">
									        <label>Tanggal Lahir</label>
									        <div class="input-group date">
                                       			<form:input path="pegawaiTglLahir" class="form-control" />
                                   					<span class="input-group-btn">
                                   						<button class="btn default date-set" type="button">
                                       						<i class="fa fa-calendar"></i>
                                   						</button>
                                   					</span>
                                   			</div>
									    </div>
										
										<div class="form-group">
											<label for="exampleInputPassword1">Kota Lahir</label>
											<div class="select2-wrapper">
												<form:select path="tempatLahirKodeNotJoin" class="form-control input-lg select2-single" >
													<option value="None">--- Pilih Kota ---</option>
													<c:forEach var="tempKota" items="${kota}">
								                      <form:option value="${tempKota.kotaKode }" label="${tempKota.kotaNama }" />
								                    </c:forEach>
												</form:select>
											</div>
										</div>
										
										<div class="form-group">
											<label  for="form_control_1">Alamat</label>
											<form:input path="pegawaiAlamat" class="form-control" placeholder="Masukan Alamat Pegawai" />
										</div>
										
										<div class="form-group">
											<label for="exampleInputPassword1">Nama Kota</label>
											<div class="select2-wrapper">
												<form:select path="kotaKodeNotJoin" class="form-control input-lg select2-single" >
													<option></option>
													<c:forEach var="tempKota" items="${kota}">
				                                    	<form:option value="${tempKota.kotaKode }" label="${tempKota.kotaNama }" />
				                                    </c:forEach>
												</form:select>
											</div>
										</div>
										
										<div class="form-group">
											<label  for="form_control_1">Nama Jabatan</label>
							                	<form:select path="pegawaiJabatanNama" class="form-control input-lg select2-single" >
													<form:option value="NONE" label="--Pilih Satu---" />
													<c:forEach var="tempJabatan" items="${jabatan}">
				                                    	<form:option value="${tempJabatan.jabatanNama }" label="${tempJabatan.jabatanNama }" />
				                                    </c:forEach>
												</form:select>
										</div>
										
										<div class="form-group">
											<label  for="form_control_1">Pendidikan</label>
							                	<form:select path="pegawaiPendidikanIdNotJoin" class="form-control form-control-sm" >
							                        <option value="0"> ---Pilih Satu--- </option>
							                        <c:forEach var="tempPendidikan" items="${pendidikan}">
				                                    	<form:option value="${tempPendidikan.pendidikan_id }" label="${tempPendidikan.pendidikanNama }"/>
				                                    </c:forEach>
							                    </form:select>
										</div>
										
										<div class="form-group">
											<label  for="form_control_1">Fungsional</label>
							                	<form:select path="pegawaiFungsional" class="form-control form-control-sm">
							                        <form:option value="Null" label="---Pilih Satu---" />
							                        <form:option value="PJ" label="Penanggung Jawab" />
							                        <form:option value="Bukan PJ" label="Bukan" />
							                    </form:select>
										</div>
										
										<div class="form-group">
											<label  for="form_control_1">Medis</label>
							                	<form:select path="pegawaiMedis" class="form-control form-control-sm" >
							                        <form:option value="0" label="---Pilih Satu---" />
							                        <form:option value="1" label="Ya" />
							                        <form:option value="-1" label="Bukan" />
							                    </form:select>
										</div>
										
										<div class="form-group">
									        <label>Tanggal Masuk</label>
									        <div class="input-group date">
                                       			<form:input path="pegawaiTglMasuk" class="form-control" />
                                   					<span class="input-group-btn">
                                   						<button class="btn default date-set" type="button">
                                       						<i class="fa fa-calendar"></i>
                                   						</button>
                                   					</span>
                                   			</div>
									    </div>
										
										<div class="form-group">
									        <label>Tanggal Keluar</label>
									        <div class="input-group date">
                                       			<form:input path="pegawaiTglKeluar" class="form-control" />
                                   					<span class="input-group-btn">
                                   						<button class="btn default date-set" type="button">
                                       						<i class="fa fa-calendar"></i>
                                   						</button>
                                   					</span>
                                   			</div>
									    </div>
										
										<div class="form-group">
											<label  for="form_control_1">Email</label>
							                <form:input path="pegawaiEmail" class="form-control" placeholder="Masukan Email" />
										</div>
										
										<div class="form-group">
											<label  for="form_control_1">Nomer HP</label>
							                <form:input path="pegawaiNoHp" class="form-control" placeholder="Masukan Nomer Handphone" />
										</div>
										
										<div class="form-group">
											<label  for="form_control_1">Nomer SIP</label>
							                <form:input path="pegawaiNomerSIP" class="form-control" placeholder="Masukan Nomer SIP" />
										</div>
										
										<div class="form-group">
											<label  for="form_control_1">Nomer NPWP</label>
							                <form:input path="pegawaiNPWP" class="form-control" placeholder="Masukan Nomer Handphone" />
										</div>
										
										<div class="form-group">
											<label  for="form_control_1">Bank</label>
							                	<form:select path="pegawaiBankNama" class="form-control form-control-sm">
							                        <form:option value="Null" label="---Pilih Satu---" />
							                        <form:option value="BNI" label="BNI" />
							                        <form:option value="BRI" label="BRI" />
							                        <form:option value="BCA" label="BCA" />
							                        <form:option value="Mandiri" label="Mandiri" />
							                        <form:option value="Lainnya" label="Lainnya" />
							                    </form:select>
										</div>
										
										<div class="form-group">
											<label  for="form_control_1">Akun Bank</label>
							                	<form:input path="pegawaiBankAkun" class="form-control" placeholder="Masukan Nama Akun" />
										</div>
										
										<div class="form-group">
											<label  for="form_control_1">Nomer Rekening</label>
							                	<form:input path="pegawaiBankRekening" class="form-control" placeholder="Masukan Nomer Rekening" />
										</div>
										
										<div class="form-group">
											<label  for="form_control_1">Foto</label>
							                	<input type="file" name="file" />
										</div>
										
										<div class="form-group">
											<button type="submit" class="btn btn-primary"> Submit </button>
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
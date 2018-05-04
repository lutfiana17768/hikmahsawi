<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="../Head.jsp"></jsp:include>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">

			<jsp:include page="../HeaderSidebar.jsp"></jsp:include>

				<article class="content forms-page">
					<section class="section">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-block">
                                        <div class="card-title-block">
                                            <h3 class="title"> List Kota </h3>
                                        </div>
                                        <section class="example">
                                            <div class="table-responsive">
                                            <a class="btn btn-primary" href="form-add"> Tambah </a>
                                                <table class="table table-striped table-bordered table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th>Pegawai No</th>
                                                            <th>Nama</th>
                                                            <th>Jabatan</th>
                                                            <th>Jenis Kelamin</th>
                                                            <th>Kota Sekarang </th>
                                                            <th>Fungsional</th>
                                                            <th>Medis</th>
                                                            <th>Email</th>
                                                            <th>No Hp</th>
                                                            <th>Tanggal Masuk</th>
                                                            <th colspan="2">Action</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="tempPegawai" items="${pegawai}">
	                                                       	<c:url var="updateLink" value="form-update">
	                                                       		<c:param name="pegawaiId" value="${tempPegawai.pegawai_id}" />
	                                                       	</c:url>
	                                                       	<c:url var="deleteLink" value="delete">
	                                                       		<c:param name="pegawaiId" value="${tempPegawai.pegawai_id}" />
	                                                       	</c:url>
	                                                       	<tr>
	                                                       		<td> ${tempPegawai.pegawaiNo } </td>
	                                                       		<td> ${tempPegawai.pegawaiNama } </td>
	                                                       		<td> ${tempPegawai.pegawaiJabatanNama } </td>
	                                                       		<td> ${tempPegawai.pegawaiKelamin } </td>
	                                                       		<td> ${tempPegawai.kotaKode.kotaNama } </td>
	                                                       		<td> ${tempPegawai.pegawaiFungsional } </td>
	                                                       		<td> ${tempPegawai.pegawaiMedis } </td>
	                                                       		<td> ${tempPegawai.pegawaiEmail } </td>
	                                                       		<td> ${tempPegawai.pegawaiNoHp } </td>
	                                                       		<td> <fmt:formatDate value="${tempPegawai.pegawaiTglMasuk }" pattern="dd-MM-yyyy" /></td>
	                                                       		<td> <a href="${updateLink }" class="btn btn-info">Update</a>
	                                                       		 <a href="${deleteLink }" class="btn btn-warning">Delete</a></td>
	                                                       	</tr>
                                                        
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </section>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="fixed-table-pagination" style="display: block; margin-top:25px">
                             <form action="" method="get">
                                    <div class="pull-right pagination" style="margin-right: 20px;">
                                         ${link }
                                    </div>
                              </form>
                        </div>
                                <div class="clearfix"></div>
                    </section>
				</article>
			<!-- END MAIN HERE -->
		</div>
	</div>
</body>
</html>
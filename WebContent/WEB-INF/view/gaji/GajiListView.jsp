<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
                                                            <th>Gaji No</th>
                                                            <th>Tanggal Bayar</th>
                                                            <th>Nama</th>
                                                            <th>Bulan</th>
                                                            <th>Tahun</th>
                                                            <th>Pokok</th>
                                                            <th>Potongan</th>
                                                            <th>Bonus</th>
                                                            <th>Total</th>
                                                            <th>Keterangan</th>
                                                            <th colspan="3">Action</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="tempGaji" items="${gaji}">
		                                                       	<c:url var="updateLink" value="form-update">
		                                                       		<c:param name="gajiId" value="${tempGaji.gaji_id }" />
		                                                       	</c:url>
		                                                       	<c:url var="deleteLink" value="delete">
		                                                       		<c:param name="gajiId" value="${tempGaji.gaji_id}" />
		                                                       	</c:url>
		                                                       	<c:url var="getReport" value="report">
		                                                       		<c:param name="gajiId" value="${tempGaji.gaji_id}" />
		                                                       	</c:url>
		                                                       	<tr>
		                                                       		<td> ${tempGaji.gajiNo } </td>
		                                                       		<td> ${tempGaji.gajiTglBayar } </td>
		                                                       		<td> ${tempGaji.gajiPegawaiId.pegawaiNama } </td>
		                                                       		<td> ${tempGaji.gajiBulan } </td>
		                                                       		<td> ${tempGaji.gajiTahun } </td>
		                                                       		<td> ${tempGaji.gajiPokok } </td>
		                                                       		<td> ${tempGaji.gajiPotongan } </td>
		                                                       		<td> ${tempGaji.gajiBonus } </td>
		                                                       		<td> ${tempGaji.gajiPendapatan } </td>
		                                                       		<td> ${tempGaji.gajiKeterangan } </td>
		                                                       		<td> <a href="${updateLink }" class="btn btn-info">Update</a>
		                                                       		 <a href="${deleteLink }" class="btn btn-warning">Delete</a>
		                                                       		 <a href="${getReport }" class="btn btn-warning" target="_blank">Report</a>
		                                                       		 </td>
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
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
							<div class="card card-block sameheight-item">
								<div class="title-block">
									<h3 class="title">Data Agama</h3>
								</div>

								<form:form modelAttribute="agamaModel" method="POST"
									action="../store">

									<div class="form-group">
										<label>Nama</label>
										<form:input path="agamaNama" placeholder="Masukan Nama"
											class="form-control" />
									</div>

									<div class="form-group">
										<label>Keterangan</label>
										<form:input path="agamaKeterangan"
											placeholder="Masukan Keterangan" class="form-control" />
									</div>

									<div class="form-group">
										<button type="submit" class="btn btn-primary">Simpan</button>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</section>
				<!-- End Form -->

				<!-- List -->

				<section class="section">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-block">
									<div class="card-title-block">
										<h3 class="title">List Agama</h3>
									</div>
									<section class="example">
										<div class="table-responsive">
											<table class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th>Nama</th>
														<th>Keterangan</th>
														<th colspan="2">Action</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="temp" items="${agama}">
														<c:url var="updateLink" value="../form-update">
															<c:param name="Id" value="${temp.agama_id}" />
														</c:url>
														<c:url var="deleteLink" value="../delete">
															<c:param name="Id" value="${temp.agama_id}" />
														</c:url>
														<tr>
															<td>${temp.agamaNama }</td>
															<td>${temp.agamaKeterangan }</td>
															<td><a href="${updateLink }" class="btn btn-info">Update</a>
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

					<div class="fixed-table-pagination"
						style="display: block; margin-top: 25px">
						<form action="" method="get">
							<div class="pull-right pagination" style="margin-right: 20px;">
								${link}</div>
						</form>

					</div>
					<div class="clearfix"></div>

				</section>
				<!-- List -->

			</article>
			<!-- END MAIN HERE -->
		</div>
	</div>
</body>
</html>
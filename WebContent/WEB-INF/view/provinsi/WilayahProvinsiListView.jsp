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
                                            <h3 class="title"> List Provinsi </h3>
                                        </div>
                                        <section class="example">
                                            <div class="table-responsive">
                                            <a class="btn btn-primary" href="../form-add"> Tambah </a>
                                                <table class="table table-striped table-bordered table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th>Kode Provinsi</th>
                                                            <th>Nama provinsi</th>
                                                            <th>Keterangan</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="tempProvinsi" items="${provinsi}">
	                                                        	<tr>
	                                                        		<td> ${tempProvinsi.propinsiKode } </td>
	                                                        		<td> ${tempProvinsi.propinsiNama } </td>
	                                                        		<td>  </td>
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
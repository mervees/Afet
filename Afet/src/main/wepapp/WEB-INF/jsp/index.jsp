<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="Fri, 18 Jul 2014 1:00:00 GMT" />

<title>Afet Giris</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a class="navbar-brand" href="/">Afet Giris</a>
			<div class="navbar-collapse collapse ">
				<ul class="navbar-nav navbar">
					<li><a class="nav-link" href="savedisaster">Afet Kayit</a></li>
					<li><a class="nav-link" href="listdisasters">Afetleri
							Listele</a></li>

				</ul>
			</div>

		</div>

	</div>

	<c:choose>

		<c:when test="${mode=='MODE_DISASTERS'}">
			<div class="container text-center">

				<h1>Afetler</h1>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Serial No.</th>
								<th>Afet Tipi</th>
								<th>Baslangic Tarihi</th>
								<th>Bitis Tarihi</th>
								<th>Il</th>
								<th>Ilce</th>
								<th>Koy</th>
								<th>Mahalle</th>
								<th>Belde</th>
								<th>Neden</th>
								<th>Etkiledigi Alan</th>
								<th>Kaynak</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${disasters}" var="disaster">

								<tr>
									<td>${disaster.id}</td>
									<td>${disaster.name}</td>
									<td>${disaster.startDate}</td>
									<td>${disaster.endDate}</td>
									<td>${disaster.city}</td>
									<td>${disaster.district}</td>
									<td>${disaster.village}</td>
									<td>${disaster.neighborhood}</td>
									<td>${disaster.area}</td>
									<td>${disaster.cause}</td>
									<td>${disaster.areaAffected}</td>
									<td>${disaster.source}</td>
									<td><a href="deletedisaster?id=${disaster.id}"><span
											class="glyphicon glyphicon-trash"></span></a></td>
									<td><a href="updatedisaster?id=${disaster.id}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
		</c:when>

		<c:when test="${mode=='MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Düzenle</h3>
				<form class="form-horizontal" method="post" action="saveDisaster">
					<input type="hidden" name="id" value="${disaster.id}" />
					<div class="form-group">
						<label class="control-label col-md-3">Afet Tipi</label>
						<div class="col-md-5">
							<form:select path="disasterList" value="${disaster.name}">
								<form:options items="${alldisasters}" />
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Il</label>
						<div class="col-md-5">
							<form:select path="myCities" value="${disaster.city}">
								<form:options items="${cities}" name="nameOfCity"/>
							</form:select>
						</div>
					</div>


					<div class="form-group">
						<label class="control-label col-md-3">Ilce</label>
						<div class="col-md-5">
							<form:select path="myDistricts" value="${disaster.district}">
								<form:options items="${districts}" name="nameOfDistrict"/>
							</form:select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Koy</label>
						<div class="col-md-5">
							<form:select path="myVillages" value="${disaster.village}">
							<form:options items="${villages}" name="nameOfVillage" />
							 </form:select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Mahalle</label>
						<div class="col-md-5">
							<form:select path="myNeighborhoods" value="${disaster.neighborhood}">
							<form:options items="${neighborhoods}" name="nameOfNeighborhood" />
							 </form:select>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Area</label>
						<div class="col-md-5">
							<input type="text" name="area" value="${disaster.area}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Baslangic Tarihi</label>
						<div class="col-md-5">
							<input type="text" name="area" value="${disaster.startDate}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Bitis Tarihi</label>
						<div class="col-md-5">
							<input type="text" name="area" value="${disaster.endDate}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Cause</label>
						<div class="col-md-5">
							<input type="text" name="area" value="${disaster.cause}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Source</label>
						<div class="col-md-5">
							<input type="text" name="area" value="${disaster.source}" />
						</div>
					</div>
					<div class="form-group">

						<input type="submit" class="btn btn-primary" value="Save" />

					</div>
				</form>

			</div>

		</c:when>
		<c:when test="${mode=='MODE_SAVE'}">
		
		<div class="container text-center">
				<h3>Kayit</h3>
				<form class="form-horizontal" method="post" action="saveDisaster">
				
					<div class="form-group">
						<label class="control-label col-md-3">Afet Tipi</label>
						<div class="col-md-5">
							<form:select path="disasterList" name="typeOfDisaster" value="${disaster.name}">
								<form:options items="${alldisasters}" />
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Il</label>
						<div class="col-md-5">
							<form:select path="myCities" name="nameOfCity" value="${disaster.city}">
								<form:options items="${cities}" />
							</form:select>
						</div>
					</div>


					<div class="form-group">
						<label class="control-label col-md-3">Ilce</label>
						<div class="col-md-5">
							<form:select path="myDistricts" name="nameOfDistrict" value="${disaster.district}">
								<form:options items="${districts}"  />
							</form:select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Koy</label>
						<div class="col-md-5">
							<form:select path="myVillages" name="nameOfVillage" value="${disaster.village}">
							<form:options items="${villages}"  />
							 </form:select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Mahalle</label>
						<div class="col-md-5">
							<form:select path="myNeighborhoods" name="nameOfNeighborhood" value="${disaster.neighborhood}">
							<form:options items="${neighborhoods}" />
							 </form:select>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Area</label>
						<div class="col-md-5">
							<input type="text" name="area" value="${disaster.area}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Baslangic Tarihi</label>
						<div class="col-md-5">
							<input type="text" name="area" value="${disaster.startDate}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Bitis Tarihi</label>
						<div class="col-md-5">
							<input type="text" name="area" value="${disaster.endDate}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Cause</label>
						<div class="col-md-5">
							<input type="text" name="area" value="${disaster.cause}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Source</label>
						<div class="col-md-5">
							<input type="text" name="area" value="${disaster.source}" />
						</div>
					</div>
					<div class="form-group">

						<input type="submit" class="btn btn-primary" value="Save" />

					</div>
				</form>

			</div>
		
		
		</c:when>
		<c:when test="${mode=='MODE_DELETE'}"></c:when>
	</c:choose>


	<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
		integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
		integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
		integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
		crossorigin="anonymous"></script>
</body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<div class="container mt-3">
	<form:form method="POST" modelAttribute="product">
		<h3>Thông tin sản phẩm</h3>
		<input type="hidden" name="id" value="${product.id}" />
		<div class="row">
			<div class="col-4">Tên sản phẩm:</div>
			<div class="col-8">
				<form:input path="name" class="form-control" placeholder="Tên sản phẩm" />

				<form:errors path="name" cssClass="text-danger" />

			</div>
		</div>
		<div class="row mt-2">
			<div class="col-4">Nhóm sản phẩm:</div>
			<div class="col-8">
				<form:select path="category" class="form-control" placeholder="Nhóm sản phẩm">
					<form:option value="">----</form:option>
				</form:select>
				<form:errors path="category" cssClass="text-danger" />

			</div>
		</div>
		<div class="row mt-2">
			<div class="col-4">Giá sản phẩm:</div>
			<div class="col-8">
				<form:input path="price" class="form-control" type="number" min="0"
					placeholder="Giá sản phẩm" />
				<form:errors path="price" cssClass="text-danger" />

			</div>
		</div>
		<a href="/" class="btn btn-secondary">Quay lại</a>
		<button class="btn btn-primary">Lưu lại</button>
	</form:form>
</div>
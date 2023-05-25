<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"/>

<div class="container mt-3">
    <h3>Xóa sản phẩm?</h3>
    <div class="mt-2">
        <label>Bạn có chắc muốn xóa sản phẩm này?</label>
    </div>
    <div class="mt-2">
        <form:form>
            <a href="/" class="btn btn-secondary">Không</a>
            <button class="btn btn-danger">Có</button>
        </form:form>
    </div>
</div>
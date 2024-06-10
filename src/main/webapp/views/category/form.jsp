<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/5/2024
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>

<body>
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-12 col-lg-6">
            <div class="shadow-sm rounded p-3 bg-white">
                <h4 class="mb-3">Thông tin phân loại</h4>
                <form action="${category.id != 0 ? "/admin/categories/update" : "/admin/categories/create"}"
                      method="post">
                    <c:if test="${category.id != 0}">
                        <input type="hidden" name="id" value="${category.id}">
                    </c:if>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="name" placeholder="tên" name="name"
                               value="${category.name}">
                        <label for="name" class="form-label">Tên</label>
                        <c:if test="${!category.getErrors().isEmpty()}">
                            <p class="text-danger mt-1"><small>${category.getErrors().get("name")}</small></p>
                        </c:if>
                    </div>

                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="description" placeholder="Mô tả" name="description"
                               value="${category.description}">
                        <label for="description" class="form-label">Mô tả</label>
                    </div>
                    <div class="input-group mb-3">
                        <label class="input-group-text" for="imageInput">Upload</label>
                        <input type="file" class="form-control" id="imageInput">
                    </div>
                    <div id="previewContainer">
                        <input type="text" class="form-control d-none" id="avatar" placeholder="Ảnh" name="avatar"
                               value="${category.avatar}">
                        <img id="imagePreview" src="${category.avatar}">
                    </div>
                    <div class="d-grid gap-2 mt-5">
                        <button type="submit" class="btn btn-primary btn-lg">Lưu</button>
                        <a href="/admin/categories/list" class="btn btn-outline-secondary">Hủy</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="/views/shared/footer.jsp" %>

</body>
</html>

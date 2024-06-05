<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/4/2024
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body class="bg-body-tertiary">

<%@include file="/views/shared/menu.jsp" %>

<div class="container mt-5 ">
    <div class="bg-white">
        <div class="d-flex justify-content-between border-bottom px-3 py-2 align-items-center">
            <h6 class="text-decoration-none text-secondary mb-0 ">Phân loại sản phẩm</h6>
            <div>
                <a class="btn btn-sm btn-primary px-4" href="/admin/categories/create">Thêm Phân loại</a>
            </div>
        </div>
        <div class="px-3 pb-2">
            <table class="table text-center">
                <thead class="table-light">
                <tr>
                    <th>Số thứ tự</th>
                    <th>Tên</th>
                    <th>Ảnh</th>
                    <th>Mô tả</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="category" items="${categories}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${category.name}</td>
                        <td>${category.avatar}</td>
                        <td>${category.description}</td>
                        <td>
                            <a href="/admin/categories/delete?id=${catagory.id}" class="btn btn-sm btn-outline-danger" >Xoá</a>
                            <a href="" class="btn btn-sm btn-outline-primary ms-1">Sửa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="...">
                <ul class="pagination pagination-sm justify-content-center">
                    <li class="page-item active" aria-current="page">
                        <span class="page-link">1</span>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>

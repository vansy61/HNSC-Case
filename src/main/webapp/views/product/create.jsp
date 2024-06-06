<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/5/2024
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/views/shared/menu.jsp" %>
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-12 col-lg-6">
            <div class="shadow-sm rounded p-3 bg-white">
                <h4 class="mb-3">Thêm sản phẩm mới</h4>
                <form method="post" action="/admin/products/create">
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="sku" placeholder="Nhập Sku mới" name="sku">
                        <label for="sku" class="form-label">Nhập mã sku mới</label>
                    </div>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="name" placeholder="Nhập tên sản phẩm mới" name="name">
                        <label for="name" class="form-label">Nhập tên sản phẩm mới</label>
                    </div>

                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="price" placeholder="Nhập giá mới" name="price">
                        <label for="price" class="form-label">Nhập giá mới</label>
                    </div>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="description" placeholder="Nhập mô tả mới" name="description">
                        <label for="description" class="form-label">Nhập mô tả mới</label>
                    </div>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="avatar" placeholder="Thêm ảnh mới" name="avatar">
                        <label for="avatar" class="form-label">Thêm ảnh mới</label>

                    </div>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="cost_price" placeholder="Nhập giá gốc mới" name="cost_price">
                        <label for="cost_price" class="form-label">Nhập giá gốc</label>
                    </div>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="quantity" placeholder="Nhập số lượng mới" name="quantity">
                        <label for="quantity" class="form-label">Nhập số lượng mới</label>
                    </div>
                    <select class="form-select form-select-lg mb-3" aria-label="Large select example">
                        <option selected>Open this select menu</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                    <div class="d-grid gap-2 mt-5">
                            <button type="submit" class="btn btn-primary btn-lg">Lưu</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

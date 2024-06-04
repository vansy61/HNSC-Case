<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/4/2024
  Time: 11:22 PM
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
                <h4 class="mb-3">Nhập thông tin phân loại</h4>
                <form>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="name" placeholder="tên" name="name">
                        <label for="name" class="form-label">Tên</label>
                    </div>

                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="avatar" placeholder="Ảnh" name="avatar">
                        <label for="avatar" class="form-label">Ảnh</label>

                    </div>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="description" placeholder="Mô tả" name="description">
                        <label for="description" class="form-label">Mô tả</label>
                    </div>
                    <div class="d-grid gap-2 mt-5">
                        <button type="submit" class="btn btn-primary btn-lg" >Lưu</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

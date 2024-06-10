<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/giao-dien/cua-hang/shared/header.jsp" %>
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-12 col-lg-6">
            <div class="shadow-sm rounded p-3 bg-white">
                <h4 class="mb-3">Nhập địa chỉ giao hàng</h4>
                <form action="/store/cart/checkout" method="post">
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="name" placeholder="Họ và tên" name="name"
                               value="${cart.address.name}">
                        <label for="name" class="form-label">Họ và tên</label>
                        <c:if test="${!cart.getErrors().isEmpty()}">
                            <p class="text-danger mt-1"><small>${cart.getErrors().get("address_name")}</small></p>
                        </c:if>
                    </div>

                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="phone" placeholder="Số điện thoại " name="phone"
                               value="${cart.address.phoneNumber}">
                        <label for="phone" class="form-label">Số điện thoại</label>
                        <c:if test="${!cart.getErrors().isEmpty()}">
                            <p class="text-danger mt-1"><small>${cart.getErrors().get("address_phone")}</small></p>
                        </c:if>
                    </div>
                    <div class="mb-3 form-floating">
                        <input type="email" class="form-control" id="email" placeholder="Email" name="email"
                               value="${cart.address.email}">
                        <label for="email" class="form-label">Email</label>
                        <c:if test="${!cart.getErrors().isEmpty()}">
                            <p class="text-danger mt-1"><small>${cart.getErrors().get("address_email")}</small></p>
                        </c:if>
                    </div>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="address" placeholder="Địa chỉ" name="address"
                               value="${cart.address.address}">
                        <label for="address" class="form-label">Địa chỉ</label>
                        <c:if test="${!cart.getErrors().isEmpty()}">
                            <p class="text-danger mt-1"><small>${cart.getErrors().get("address_address")}</small></p>
                        </c:if>
                    </div>
                    <div class="d-grid gap-2 mt-5">
                        <button type="submit" class="btn btn-primary btn-lg">Đặt Hàng</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="/giao-dien/cua-hang/shared/footer.jsp" %>
</body>
</html>


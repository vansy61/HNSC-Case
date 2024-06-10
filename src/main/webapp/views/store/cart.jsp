<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/4/2024
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/giao-dien/cua-hang/shared/header.jsp" %>

<div class="container py-4">
    <div class="row ">
        <c:if test="${cart == null || cart.items.isEmpty()}">
            <div class="text-center py-3 col-12 rounded bg-white">
                <h5 class="mb-3">Chưa có sản phẩm nào trong giỏ hàng!</h5>
                <a href="/store/products/list" class="btn btn-outline-primary">Quay lại trang sản phẩm</a>
            </div>
        </c:if>
        <c:if test="${cart != null && !cart.items.isEmpty()}">
            <div class="col-8">
                <div class="p-3 rounded bg-white">
                    <c:forEach items="${cart.items}" var="item">
                        <div class="d-flex border-bottom mb-3">
                            <div class="w-25">
                                <img src="${item.product.avatar}"
                                     class="img-fluid">
                            </div>
                            <div class="flex-grow-1">
                                <div class="d-flex justify-content-between">
                                    <p>${item.product.name}</p>
                                    <a href="/store/cart/remove?product_id=${item.product.id}"
                                       class="btn btn-outline-danger ms-2 ">
                                        <i class="fa-regular fa-trash-can"></i>
                                    </a>
                                </div>
                                <p>Giá: ${item.product.price}</p>
                                <form action="/store/cart/update">

                                    <div class="d-flex mb-2">
                                        <input type="hidden" name="product_id" value="${item.product.id}">
                                        <button class="btn btn-secondary rounded-end-0 border-end-0 btn-minus">-
                                        </button>
                                        <input id="numbers" type="text"
                                               class="form-control rounded-0 border-secondary text-center"
                                               style="width: 50px;" value="${item.quantity}" name="quantity">
                                        <button class="btn btn-secondary rounded-start-0 border-start-0 btn-plus">
                                            +
                                        </button>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>


            <div class="col-4">
                <div class="p-3 rounded bg-white">
                    <h2>Chi tiết đơn hàng</h2>
                    <div class="d-flex mb-2">
                        <div class="flex-grow-1">
                            <div class="d-flex justify-content-between">
                                <p>Tổng giá trị</p>
                                <p>${cart.getTotalPrice()}</p>
                            </div>
                            <div class="d-flex justify-content-between">
                                <p>Giảm giá</p>
                                <p>0đ</p>
                            </div>
                            <div class="d-flex justify-content-between">
                                <p>Phí ship</p>
                                <p>0đ</p>
                            </div>
                            <div class="d-flex justify-content-between border-top py-3">
                                <p class="mb-0">Tổng cộng</p>
                                <p class="mb-0">${cart.getTotalPrice()}</p>
                            </div>
                            <div class="d-grid gap-2">
                                <a href="/store/cart/checkout" class="btn btn-primary">Tiến hành đặt hàng</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </div>
</div>
<%@include file="/giao-dien/cua-hang/shared/footer.jsp" %>

</body>
</html>

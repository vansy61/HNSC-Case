<%--
  Created by IntelliJ IDEA.
  User: vansy
  Date: 3/6/24
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/giao-dien/cua-hang/shared/header.jsp" %>
<div class="container my-3">

    <div class="row">
        <div class="col-8">
            <img src="https://hcm.fstorage.vn/images/2024/06/240515_sub-banner_867x400-egg-copy-20240603015608.jpg"
                 alt="" class="h-100 img-fluid object-fit-cover">
        </div>
        <div class="col-4 d-flex flex-column p-0">
            <div class="mb-2">
                <img src="https://hcm.fstorage.vn/images/2023/02/867x400_web.jpg" alt="" class="img-fluid">
            </div>
            <div>
                <img src="https://hcm.fstorage.vn/images/2023/05/614x397_online-01-1--20230505011530.jpg" alt=""
                     class="img-fluid">
            </div>
        </div>
    </div>
    <div class="mt-3">
        <div class="d-flex justify-content-between  line-bg-gradient m-0 py-3 px-2">
            <div>
                <h4 class="mb-0">Duy nhất hôm nay</h4>
            </div>
            <div class="d-flex">
                <h5 class="mb-0">Kết thúc trong</h5>
                <div class="shadow-sm bg-danger text-white p-1 mx-1">
                    <h5 id="hours" class="mb-0 lh-base px-1"></h5>
                </div>
                <div class="shadow-sm bg-danger text-white p-1 me-1">
                    <h5 id="minutes" class="mb-0 lh-base px-1"></h5>
                </div>
                <div class="shadow-sm bg-danger text-white p-1">
                    <h5 id="seconds" class="mb-0 lh-base px-1"></h5>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/giao-dien/cua-hang/shared/footer.jsp" %>

<script src="${pageContext.request.contextPath}/js/coundown.js"></script>
</body>
</html>
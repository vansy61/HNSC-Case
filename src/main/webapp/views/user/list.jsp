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
    <div>
        <div class="d-flex justify-content-between p-3 shadow-sm bg-white mb-3 align-items-center">
            <h6 class="text-decoration-none text-secondary mb-0 ">Tất cả nhân sự</h6>
            <div>
                <a class="btn btn-sm btn-primary px-4" type="submit" href="/admin/users/create">Thêm nhân sự</a>
            </div>
        </div>
        <div class="p-3 bg-white mb-2 shadow-sm">
            <div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Tên</th>
                        <th>Email</th>
                        <th>Password</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="userList" items="${userList}" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td>${userList.name}</td>
                            <td>${userList.email}</td>
                            <td>${userList.password}</td>
                            <td>
                                <a href="/admin/users/delete?id=${userList.id}" class="btn btn-sm btn-outline-danger">
                                    <i class="fa-solid fa-trash"></i>
                                    Xoá
                                </a>
                                <a href="/admin/users/update?id=${userList.id}"
                                   class="btn btn-sm btn-outline-primary ms-1">
                                    <i class="fa-solid fa-pen-to-square"></i>
                                    Sửa
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>
<%@include file="/views/shared/footer.jsp" %>

</body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/page/img/fav.png">
    </head>
    <body>

        <div class="page-container">	

            <div class="left-content">

                <div class="mother-grid-inner">

                    <jsp:include page="header.jsp"></jsp:include>

                        <div class="inner-block">
                            <div class="inbox">
                                <h2>Quản lý tài khoản</h2>
                                <h4>${status}</h4>
                                <div class="col-md-12 mailbox-content  tab-content tab-content-in">
                                    <div class="tab-pane active text-style" id="tab1">
                                        <div class="mailbox-border">
                                            <div class="mail-toolbar clearfix">
                                                <div class="float-left">
                                                <div class="btn btn_1 btn-default mrg5R">
                                                    <a href="${pageContext.request.contextPath}/manages/account/add"><i class="fa fa-plus">ADD</i></a>
                                                </div>
                                                <div class="clearfix"> </div>
                                            </div>                                            
                                        </div>
                                        <table class="table tab-border">
                                            <tbody>
                                                <tr>
                                                    <td class="hidden-xs" style="width: 200px;">
                                                        <b>Tên đăng nhập</b>
                                                    </td>                                                    
                                                    <td class="hidden-xs" style="width: 200px;">
                                                        <b>Họ và tên</b>
                                                    </td>                                                    
                                                    <td class="hidden-xs" style="text-align: center">
                                                        <b>Mail</b>
                                                    </td>                                                    
                                                    <td class="hidden-xs" style="text-align: center">
                                                        <b>SĐT</b>
                                                    </td>                                                    
                                                    <td class="hidden-xs" style="text-align: center">
                                                        <b>Địa chỉ</b>
                                                    </td>                                                                                                       
                                                </tr>
                                                <c:forEach var="item" items="${listAccount}">
                                                    <tr class="unread checked">
                                                        <td class="hidden-xs" style="width: 200px;">
                                                            ${item.accountName}
                                                        </td>
                                                        <td class="hidden-xs" style="width: 200px;">
                                                            ${item.fullName}
                                                        </td>
                                                        <td class="hidden-xs" style="width: 200px;">
                                                            ${item.accountMail}
                                                        </td>
                                                        <td class="hidden-xs" style="text-align: center">
                                                            ${item.moblie}
                                                        </td>
                                                        <td class="hidden-xs" style="text-align: center">
                                                            ${item.address}
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>   
                                </div>
                            </div>
                            <div class="clearfix"> </div>     
                        </div>
                    </div>
                    <jsp:include page="footer.jsp"></jsp:include>
                    </div>
                </div>
            <jsp:include page="navigation.jsp"></jsp:include>
        </div>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Detail</title>
    </head>
    <body>
        <div class="page-container">	

            <div class="left-content">

                <div class="mother-grid-inner">

                    <jsp:include page="header.jsp"></jsp:include>

                        <div class="inner-block">
                            <div class="inbox">
                                <h2>Thông tin khách hàng</h2>
                                <div class="col-md-12 mailbox-content  tab-content tab-content-in">
                                    <table class="table tab-border">
                                        <tr>
                                            <td class="hidden-xs"><b>Tên khách hàng:</b></td>
                                            <td class="hidden-xs"><b>${order.account.fullName}</b></td>
                                        </tr>
                                        <tr>
                                            <td class="hidden-xs"><b>Số điện thoại:</b></td>
                                            <td class="hidden-xs"><b>${order.mobile}</b></td>
                                        </tr>
                                    <tr>
                                        <td><b>Địa chị nhận hàng:</b></td>
                                        <td><b>${order.address}</b></td>
                                    </tr>
                                    <tr>
                                        <td><b>Ngày đặt hàng:</b></td>
                                        <td><b>${order.orderDate}</b></td>
                                    </tr>
                                    
                                </table>                                  
                            </div>
                            <h2>Hóa đơn chi tiết</h2>
                            <div class="col-md-12 mailbox-content  tab-content tab-content-in">
                                <div class="tab-pane active text-style" id="tab1">
                                    <div class="mailbox-border"> 
                                        <table class="table tab-border">
                                            <tbody>
                                                <tr>
                                                    <td class="hidden-xs" style="width: 200px;">
                                                        <b>Tên sản phẩm</b>
                                                    </td>                                                    
                                                    <td class="hidden-xs" style="width: 200px;">
                                                        <b>Số lượng</b>
                                                    </td>                                                    
                                                    <td class="hidden-xs" style="width: 200px;">
                                                        <b>Giá</b>
                                                    </td>                                                    

                                                </tr>
                                                <c:forEach var="item" items="${listOrderDetail}">
                                                    <tr class="unread checked">
                                                        <td class="hidden-xs" style="width: 450px;">
                                                            ${item.product.productName}
                                                        </td>
                                                        <td class="hidden-xs" style="width: 200px;">
                                                            ${item.orderItemQuantity}
                                                        </td>
                                                        <td class="hidden-xs" style="width: 200px;">
                                                            <fmt:formatNumber value="${item.orderItemPrice}" currencySymbol="VND"/>
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

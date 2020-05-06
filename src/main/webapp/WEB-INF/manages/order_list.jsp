<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mytab" uri="/WEB-INF/taglibs/newtag_library.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
        <style>
            .andi {
                opacity: 0;
                visibility: hidden
            }
            
        </style>
    </head>
    <body>

        <div class="page-container">	

            <div class="left-content">

                <div class="mother-grid-inner">

                    <jsp:include page="header.jsp"></jsp:include>

                        <div class="inner-block">
                            <div class="inbox">
                                <h2>Danh sách đơn hàng</h2>
                                <div class="col-md-12 mailbox-content  tab-content tab-content-in">
                                    <div class="tab-pane active text-style" id="tab1">
                                        <div class="mailbox-border"> 
                                            <table class="table tab-border">
                                                <tbody>
                                                    <tr>
                                                        <td class="hidden-xs" style="width: 200px;">
                                                            <b>Order Name</b>
                                                        </td>                                                    
                                                        <td class="hidden-xs" style="text-align: center; width: 200px;">
                                                            <b>Mail</b>
                                                        </td>                                                    
                                                        <td class="hidden-xs" style="text-align: center; width: 150px;">
                                                            <b>SĐT</b>
                                                        </td>                                                    
                                                        <td class="hidden-xs" style="text-align: center; width: 200px;">
                                                            <b>Địa chỉ</b>
                                                        </td>     
                                                        <td class="hidden-xs" style="text-align: center; width: 150px;">
                                                            <b>Trạng thái</b>
                                                        </td>     
                                                        <td class="hidden-xs" style="width: 200px;">
                                                            <b>Ngày đặt hàng</b>
                                                        </td>
                                                        <td style="text-align: center; width: 150px;">
                                                            <b>Option</b>
                                                        </td>
                                                    </tr>
                                                <c:forEach var="item" items="${listOrder}">
                                                    <tr class="unread checked">
                                                        <td class="hidden-xs" style="width: 200px;">
                                                            ${item.orderName}
                                                        </td>
                                                        <td class="hidden-xs" style="width: 200px;">
                                                            ${item.mail}
                                                        </td>
                                                        <td class="hidden-xs" style="text-align: center; width: 150px;">
                                                            ${item.mobile}
                                                        </td>
                                                        <td class="hidden-xs" style="text-align: center; width: 200px;">
                                                            ${item.address}
                                                        </td>
                                                        <td class="hi
                                                            dden-xs" style="text-align: center; width: 150px;">
                                                            ${item.orderStatus}
                                                        </td>
                                                        <td class="hidden-xs" style="width: 200px;">
                                                            ${item.orderDate}
                                                        </td>
                                                <!--<input hidden="hidden" name="${item.orderStatus}${item.orderId}" value="${item.orderStatus}${item.orderId}">-->
                                                        <td style="text-align: center; width: 150px;">
                                                            <a class="btn btn-default" href="${pageContext.request.contextPath}/manages/order/orderDetail/${item.orderId}.htm"><i class="fa fa-edit"></i></a>
                                                            <a id="${item.orderStatus}${item.orderId}" thuoctinh="${item.orderStatus}${item.orderId}" class="btn btn-default" href="${pageContext.request.contextPath}/manages/order/confirmOrder/${item.orderId}.htm"><i>Duyệt</i></a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                        <mytab:PaginationTagHander count = "${count}" steps="${maxResult}" offset="${offset}" uri="${pageContext.request.contextPath}/manages/order/list.htm" next="&raquo;" previous="&laquo;"/>
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
                <script>
                    <c:forEach var="item" items="${listOrder}">
                        var elm = $('#${item.orderStatus}${item.orderId}');
                        var giatri = elm.attr("thuoctinh");
                        if (giatri.slice(0, 4) == "true") {
                            elm.addClass("andi");
                        }
                    </c:forEach>
                </script>
        </div>
    </body>
</html>

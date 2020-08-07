<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Chi tiết đơn hàng</title>

    <style>
        th{
            text-align: center;
        }
        td{
            text-align: center;
        }
    </style>
</head>

<body>

    <div id="wrapper">

        <jsp:include page="menu.jsp"></jsp:include>

        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Danh mục</h1>
                    </div>
                </div>
                
                <!-- Thông tin người mua hàng -->
                <div class="row">
                    <div class="col-lg-12">
                        <table class="table table-striped table-bordered table-hover">
                            <tr>
                                <th>Người mua hàng</th>
                                <td>${order.orderName}</td>
                            </tr>
                            <tr>
                                <th>SĐT</th>
                                <td>${order.phone}</td>
                            </tr>
                            <tr>
                                <th>Mail</th>
                                <td>${order.mail}</td>
                            </tr>   
                            <tr>
                                <th>Địa chỉ</th>
                                <td>${order.address}</td>
                            </tr>
                        </table>
                    </div>
                </div>
                
                <!-- Thông tin sản phẩm người mua -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Danh sách sản phẩm đã mua
                            </div>
                            
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                        <thead>
                                            <tr>
                                                <th>Tên sản phẩm</th>
                                                <th>Số lượng</th>
                                                <th>Giá</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${listOrderItem}" var="item">
                                        		<tr>
                                        			<td>${item.product.producerName}</td>
                                        			<td>${item.quantity}</td>
                                        			<td>${item.price}</td>
                                        		</tr>
                                        	</c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>              
            </div>
        </div>
    </div>


    <script src="${pageContext.request.contextPath}/resources/manages/js/jquery.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/manages/js/bootstrap.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/manages/js/metisMenu.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/manages/js/dataTables/jquery.dataTables.min.js"></script>
	
	<script src="${pageContext.request.contextPath}/resources/manages/js/dataTables/dataTables.bootstrap.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/manages/js/startmin.js"></script>
	
    <script>
        $(document).ready(function() {
            $('#dataTables-example').DataTable({
                responsive: true
            });
        });
    </script>

</body>

</html>
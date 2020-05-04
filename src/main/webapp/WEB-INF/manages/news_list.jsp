<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Manages</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/page/img/fav.png">
    </head>
    <body>
        <div class="page-container">	

            <div class="left-content">

                <div class="mother-grid-inner">

                    <jsp:include page="header.jsp"></jsp:include>

                        <div class="inner-block">
                            <div class="inbox">
                                <h2>Quản lý tin tức</h2>
                                <div class="col-md-12 mailbox-content  tab-content tab-content-in">
                                    <div class="tab-pane active text-style" id="tab1">
                                        <div class="mailbox-border">
                                            <div class="mail-toolbar clearfix">
                                                <div class="float-left">
                                                    <div class="btn btn_1 btn-default mrg5R">
                                                        <a href="${pageContext.request.contextPath}/manages/news/add"><i class="fa fa-plus">ADD</i></a>
                                                    </div>
                                                    <div class="clearfix"> </div>
                                                </div>                                            
                                        </div>
                                        <table class="table tab-border">
                                            <tbody>
                                                <tr>
                                                    <td class="hidden-xs" style="width: 200px;">
                                                        <b>Tiêu đề</b>
                                                    </td>                                                    
                                                    <td class="hidden-xs" style="width: 200px;">
                                                        <b>Date</b>
                                                    </td>                                                    
                                                    <td style="text-align: center; width: 150px;">
                                                        <b>Option</b>
                                                    </td>
                                                </tr>
                                                <c:forEach var="item" items="${listNews}">
                                                    <tr class="unread checked">
                                                        <td class="hidden-xs" style="width: 200px;">
                                                            ${item.title}
                                                        </td>
                                                        <td class="hidden-xs" style="width: 200px;">
                                                            ${item.createDate}
                                                        </td>
                                                        <td style="text-align: center; width: 150px;">
                                                            <a class="btn btn-default" href="${pageContext.request.contextPath}/manages/news/edit/${item.newsId}"><i class="fa fa-edit"></i></a>
                                                            <a class="btn btn-default" href="${pageContext.request.contextPath}/manages/news/delete/${item.newsId}" onclick=" return confirm('Bạn có muốn xóa?')"><i class="fa fa-remove"></i></a>
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
    </body>
</html>

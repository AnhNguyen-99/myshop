<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>News add</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/page/img/fav.png">
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/ckfinder/ckfinder.js"></script>
    </head>
    <body>
        <div class="page-container">	

            <div class="left-content">

                <div class="mother-grid-inner">

                    <jsp:include page="header.jsp"></jsp:include>

                        <div class="inner-block">
                            <div class="inbox">
                                <h2>Tin tức</h2>
                                <div class="col-md-12 compose-right">
                                    <div class="inbox-details-default">
                                        
                                    <div class="inbox-details-body">
                                        <form:form method="POST" modelAttribute="news" class="com-mail"
                                                   action="${pageContext.request.contextPath}/manages/news/save" enctype="multipart/form-data"><br/>
                                            <form:input type="hidden" path="newsId"/>
                                            <label>Tiêu đề</label>
                                            <form:input path="title"  />
                                            <label>Nội dung</label>
                                            <form:textarea id="content1" path="content"/>
                                            <!--Phần lưu ảnh -->
                                            <label>Ảnh tiêu đề </label>
                                            <form:input type="file" path="img"/>
                                            <input type="submit" value="Save"> 
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix"> </div>     
                        </div>
                    </div>
                    <!-- <script type="text/javascript">
                        var editor = CKEDITOR.replace('content1');
                        CKFinder.setupCKEditor(editor, 'resources/ckfinder/');
                    </script> -->
                    <jsp:include page="footer.jsp"></jsp:include>
                    </div>
                </div>
            <jsp:include page="navigation.jsp"></jsp:include>
        </div>
    </body>
</html>

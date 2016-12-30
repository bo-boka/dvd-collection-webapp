<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>DVD Collection</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/search">Search</a></li>
                    
                </ul>    
            </div>
            <div class="row">
                <!--  display table-->
                <div class="col-md-6">
                    <h3>DVD List</h3>
                    <%@include file="dvdTableFragment.jsp" %>
                </div>
                <div class="col-md-6">
                    <center>
                    <h3>Search DVDs</h3>
                    </center>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="search-title" class="col-md-4 control-label">Title:</label>
                            <div class="col-md-8">
                                <input id="search-title" name="dvdTitle" type="text" class="form-control" placeholder="Title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-release-date" class="col-md-4 control-label">Release Date:</label>
                            <div class="col-md-8">
                                <input id="search-release-date" name="dvdReleaseDate" type="text" class="form-control" placeholder="Release Date"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-mpaa-rating" class="col-md-4 control-label">MPAA Rating:</label>
                            <div class="col-md-8">
                                <input id="search-mpaa-rating" name="dvdMpaaRating" type="text" class="form-control" placeholder="MPAA Rating"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-director" class="col-md-4 control-label">Director:</label>
                            <div class="col-md-8">
                                <input id="search-director" name="dvdDirector" type="text" class="form-control" placeholder="Director"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-studio" class="col-md-4 control-label">Studio:</label>
                            <div class="col-md-8">
                                <input id="search-studio" name="dvdStudio" type="text" class="form-control" placeholder="Studio"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-user-note" class="col-md-4 control-label">User Note:</label>
                            <div class="col-md-8">
                                <input id="search-user-note" name="dvdUserNote" type="text" class="form-control" placeholder="User Note"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="search-button" class="btn btn-default">Search DVD</button>
                            </div>
                        </div>
                    </form>
                    <div id="validationErrors" class="alert alert-danger" style="display:none"></div>
                </div>    
            </div>
        </div>
                <%@include file="detailModalFragment.jsp" %>
                <%@include file="editModalFragment.jsp" %>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/dvdCollection.js"></script>

    </body>
</html>


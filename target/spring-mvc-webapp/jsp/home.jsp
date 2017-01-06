<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/dvdlib-style.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <center><br>
                <h1>DVD Collection Web App</h1>
            </center><br>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/search">Search</a></li>

                </ul>    
            </div>
            <div class="row">
                <!--  display table-->
                <div class="col-md-6">
                    <h2>DVD List</h2>
                    <%@include file="dvdTableFragment.jsp" %>
                </div>
                <div class="col-md-6">
                    <center>
                        <h2>Add DVD to Collection</h2>
                    </center>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-title" class="col-md-4 control-label">Title:</label>
                            <div class="col-md-8">
                                <input id="add-title" name="dvdTitle" type="text" class="form-control" placeholder="Title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-release-date" class="col-md-4 control-label">Release Date:</label>
                            <div class="col-md-8">
                                <input id="add-release-date" name="dvdReleaseDate" type="text" class="form-control" placeholder="Release Date"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-mpaa-rating" class="col-md-4 control-label">MPAA Rating:</label>
                            <div class="col-md-8">
                                <input id="add-mpaa-rating" name="dvdMpaaRating" type="text" class="form-control" placeholder="MPAA Rating"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-director" class="col-md-4 control-label">Director:</label>
                            <div class="col-md-8">
                                <input id="add-director" name="dvdDirector" type="text" class="form-control" placeholder="Director"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-studio" class="col-md-4 control-label">Studio:</label>
                            <div class="col-md-8">
                                <input id="add-studio" name="dvdStudio" type="text" class="form-control" placeholder="Studio"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-user-note" class="col-md-4 control-label">User Note:</label>
                            <div class="col-md-8">
                                <input id="add-user-note" name="dvdUserNote" type="text" class="form-control" placeholder="User Note"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="add-button" class="btn btn-default">Add DVD</button>
                            </div>
                        </div>
                    </form>
                    <!--<div id="validationErrors" class="alert alert-danger" style="display:none"></div>-->
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


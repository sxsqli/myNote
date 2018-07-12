<%--
  Created by IntelliJ IDEA.
  User: sxsqli
  Date: 2018/7/10
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>MyNote</title>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/showdown/1.8.6/showdown.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://cdn.bootcss.com/normalize/8.0.0/normalize.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="markdownCss/github.css" rel="stylesheet">
    <style>
        .header {
            padding: 12px 0 12px;
            color: rgba(255, 255, 255, 0.75);
            background: #24292e;
        }

        .header .logo, .header .search, .header .navigation {
            margin-right: 15px;
            float: left;
        }

        .header .user {
            float: right;
        }

        form {
            margin: 0;
        }

        .search input {
            width: 300px;
            height: 32px;
        }

        .user button {
            padding-top: 5px;
            padding-bottom: 5px;
        }

        .header .navigation ol {
            padding: 5px 0;
            background: rgba(0,0,0,0);
            color: #ffffff;
        }
        .header .navigation ol a {
            color: #ffffff;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="container">
        <div class="row">
            <div class="logo"><img src="img/logo.gif"></div>
            <div class="search">
                <form action="index.jsp">
                    <input type="search" class="form-control" name="like">
                </form>
            </div>
            <div class="navigation">
                <ol class="breadcrumb">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="${empty user?'login.jsp':'upload.jsp'}">upload</a></li>
                    <li><a href="#">2013</a></li>
                </ol>
            </div>
            <div class="user">
                <div class="dropdown">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        ${empty user?"visitor":user.username}&nbsp;&nbsp;
                            <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">登陆</a></li>
                        <li><a href="#">注册</a></li>
                        <li><a href="#">信息</a></li>
                        <li class="divider"/>
                        <li><a href="#">注销</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

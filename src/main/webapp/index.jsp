<%--
  Created by IntelliJ IDEA.
  User: sxsqli
  Date: 2018/7/10
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<script>
    $(function () {
        $.getJSON("/NoteFileServlet?op=${empty param.like?'findAll':'findLike&like='}${param.like}", function (data) {
            $(data).each(function () {
                $(".filelist").append("<h2>" +
                    "<a href='show.jsp?path=" + this.path + "'>" + this.filename + "</a>" +
                    "<span class='date'>" + (1900 + Number(this.submittime.year)) + "/" + this.submittime.month + "/" + this.submittime.day + "</span>" +
                    "<span class='username'>" + this.user.username + "</span>" +
                    "</h2>");
            });
        });
    });
</script>
<style>
    .content a {
        color: #000000;
    }

    .content .username {
        float: right;
        font-size: 16px;
        margin-top: 13px;
        margin-right: 12px;
        color: rgba(0, 0, 0, 0.5);
    }

    .content .date {
        float: right;
        font-size: 10px;
        margin-top: 17px;
        color: rgba(0, 0, 0, 0.5);
    }

    .filelist {
        width: 80%;
        margin: auto;
    }

    .filelist .title {
        text-align: center;
    }
</style>
<div class="content">
    <div class="container">
        <div class="row">
            <div class="filelist">
                <h1 class="title">All articles</h1>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>

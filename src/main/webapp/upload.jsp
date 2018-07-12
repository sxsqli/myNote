<%--
  Created by IntelliJ IDEA.
  User: sxsqli
  Date: 2018/7/11
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<script>

</script>
<style>
    .upload {
        margin: 340px auto 0;
        width: 331px;
    }
    .content [type=file] {
        display: inline-block;
    }
</style>
<div class="content">
    <div class="container">
        <div class="row">
            <div class="upload">
                <form action="NoteFileServlet?op=upload" method="post" enctype="multipart/form-data">
                    <input type="file" name="file">
                    <button type="submit" class="btn btn-default">提交</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>

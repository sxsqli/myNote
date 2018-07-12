<%--
  Created by IntelliJ IDEA.
  User: sxsqli
  Date: 2018/7/11
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<script>

</script>
<style>
    .login {
        margin: 340px auto 0;
        width: 50%;
    }
    button {
        margin-left: 240px;
    }
</style>
<div class="content">
    <div class="container">
        <div class="row">
            <div class="login">
                <form class="form-horizontal" role="form" method="post" action="UserServlet?op=check">
                    <div class="form-group">
                        <label for="username" class="col-sm-2 control-label">username</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="username" name="username">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-2 control-label">password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password" name="password">
                        </div>
                    </div>
                    <div class="form-group">
                            <button type="submit" class="btn btn-default">login</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>

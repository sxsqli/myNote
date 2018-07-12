<%--
  Created by IntelliJ IDEA.
  User: sxsqli
  Date: 2018/7/8
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<script>
    $(function () {
        $.get("/${param.path}", function (data) {
            var converter = new showdown.Converter({
                "omitExtraWLInCodeBlocks": true,
                "noHeaderId": false,
                "prefixHeaderId": "",
                "ghCompatibleHeaderId": true,
                "headerLevelStart": 1,
                "parseImgDimensions": true,
                "simplifiedAutoLink": true,
                "excludeTrailingPunctuationFromURLs": false,
                "literalMidWordUnderscores": true,
                "strikethrough": true,
                "tables": true,
                "tablesHeaderId": false,
                "ghCodeBlocks": true,
                "tasklists": true,
                "smoothLivePreview": true,
                "smartIndentationFix": false,
                "disableForced4SpacesIndentedSublists": false,
                "simpleLineBreaks": false,
                "requireSpaceBeforeHeadingText": false,
                "ghMentions": false, "extensions": [], "sanitize": false
            });
            var html = converter.makeHtml(data);
            $(".markdown").html(html);
            $(html).filter("h1,h2,h3,h4,h5,h6").each(function () {
                var a = "<a class='list-group-item my" + this.tagName + "' href='#" + this.id + "'>" + this.innerText + "</a>";
                $(".catalog").append(a);
            });
        });
    });
</script>
<style>
    pre code {
        border: 0;
    }

    .content .catalog {
        max-height: 946px;
        padding: 5px;
        overflow: auto;
    }

    @media screen and (min-width: 770px) {
        .content .catalog {
            position: sticky;
            top: 0;
        }
    }

    @media screen and (max-height: 910px) {
        .content .catalog {
            max-height: 800px;
        }
    }

    @media screen and (max-height: 810px) {
        .content .catalog {
            max-height: 700px;
        }
    }

    @media screen and (max-height: 710px) {
        .content .catalog {
            max-height: 600px;
        }
    }

    @media screen and (max-height: 610px) {
        .content .catalog {
            max-height: 500px;
        }
    }

    @media screen and (max-height: 510px) {
        .content .catalog {
            max-height: 400px;
        }
    }

    .content .catalog a {
        color: #000000;
        float: left;
        clear: left;
        border: 0;
        white-space:nowrap;
    }

    .content .markdown {
        background: #ffffff;
        box-shadow: 0 0 2px 0 #000000;
    }

    .myH2 {
        margin-left: 30px;
    }

    .myH3 {
        margin-left: 45px;
    }

    .myH4 {
        margin-left: 60px;
    }

    .myH5 {
        margin-left: 75px;
    }

    .myH6 {
        margin-left: 90px;
    }
</style>
<div class="content">
    <div class="container">
        <div class="row">
            <div class="col-sm-3 list-group catalog"></div>
            <div class="col-sm-9 markdown"></div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
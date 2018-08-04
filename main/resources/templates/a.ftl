<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<script>
    $(document).ready(function() {
        var a = ${error!}
        if(a.value)
            alert(a);
    }
</script>
<body>
${error!}
<h1>数据库展示</h1>
<form action="/findAll"  method="get">
    <input type="submit" id="submit0" value="首页"/>
</form>

<h4>查找一个id</h4>
<form action="/findid"  method="get">
    <input type="number" id="findid" name="id"/>
    <input type="submit" id="submit1" value="提交"/>
</form>

<h4>查找name关联的id</h4>
<form action="/findname"  method="get">
    <input type="number" id="findname" name="name"/>
    <input type="submit" id="submit2" value="提交"/>
</form>

<h4>增加一个id</h4>
<form action="/saveone"  method="get">
    <input type="number" id="addid" name="id" placeholder="添加id"/><br/>
    <input type="number" id="addname" name="name" value="1" placeholder="添加name"/>
    <input type="submit" id="submit4" value="提交"/>
</form>
<br/><br/>
<#if findn ??>
<h4>查找到name是 ${findn} 的记录有：</h4>
</#if>
<table border="1" th:width="200">
    <tr th:width="50" th:height="15">
        <td>id</td>
        <td>name</td>
        <td>删</td>
        <td>改</td>
    </tr>
<#if listres ??>
    <#list listres as items>
    <tr>
        <td width="30">${items.id}</td>
        <td width="30">${items.name}</td>
        <td>
            <form action="/tabledel" method="get">
            <input value="${items.id}" name="delid" style="display: none">
            <input value="删除" type="submit"></form>
        </td>
        <td>
            <form action="/updpage" method="get">
            <input value="${items.id}" name="updid" style="display: none" >
            <input value="修改" type="submit" src="/updpage"></form>
        </td>
    </tr>
    </#list>
</#if>

</table>

<#--<a href="/updpage">走你</a>-->
</body>
</html>
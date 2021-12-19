<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h2 >1、传普通值（String）</h2>
${rname}

<h2>2、传集合（list）</h2>
<table border="1px" width="60%">
    <tr>
        <td>角色id</td>
        <td>角色名字</td>
    </tr>
    <#list roleList as role >
        <tr>
            <td>${role.rid}</td>
            <td>${role.rname}</td>
        </tr>
    </#list>
</table>
<h2>3、包含内容</h2>
<#include 'common/header.ftl' >
<#include 'common/global.ftl' >


<h2>4、如何获取项目名</h2>
${springMacroRequestContext.contextPath}




<h2>5、如何定义局部变量(assign)/全局变量(global)</h2>
<#assign ww1>
    ${springMacroRequestContext.contextPath}
</#assign>

<#global ww2>
    ${springMacroRequestContext.contextPath}
</#global>

${ww1}和${ww2}





</body>
</html>

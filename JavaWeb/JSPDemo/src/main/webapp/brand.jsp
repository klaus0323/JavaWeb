<%@ page import="pojo.Brand" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Klaus Yan
  Date: 3/10/2023
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Brand> brands = new ArrayList<Brand>();
    brands.add(new Brand(1, "三只耗子", "三只耗子", 100, "三只耗子，吃完嗷嗷拉肚子", 1));
    brands.add(new Brand(2, "优衣库", "优衣库", 200, "优衣库，服适人生", 0));
    brands.add(new Brand(3, "小米", "小米科技有限公司", 1000, "为发烧而生", 1));
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<input type="button" value="新增"><br>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>
    <tr align="center">
        <td>1</td>
        <td>三只松鼠</td>
        <td>三只松鼠</td>
        <td>100</td>
        <td>三只松鼠，好吃不上火</td>
        <td>启用</td>
        <td><a href="#">修改</a> <a href="#">删除</a></td>
    </tr>

    <tr align="center">
        <td>2</td>
        <td>优衣库</td>
        <td>优衣库</td>
        <td>10</td>
        <td>优衣库，服适人生</td>
        <td>禁用</td>

        <td><a href="#">修改</a> <a href="#">删除</a></td>
    </tr>

    <tr align="center">
        <td>3</td>
        <td>小米</td>
        <td>小米科技有限公司</td>
        <td>1000</td>
        <td>为发烧而生</td>
        <td>启用</td>

        <td><a href="#">修改</a> <a href="#">删除</a></td>
    </tr>

    <%
        for (int i = 0; i < brands.size(); i++) {
            Brand brand = brands.get(i);
    %>
    <tr align="center">
        <td><%=brand.getId()%>
        </td>
        <td><%=brand.getBrandName()%>
        </td>
        <td><%=brand.getCompanyName()%>
        </td>
        <td><%=brand.getOrdered()%>
        </td>
        <td><%=brand.getDescription()%>
        </td>

        <% if (brand.getStatus() == 1) {
        %>
        <td>启用</td>
        } else {
        <td>禁用</td>
        <%
        }%>


        <td><a href="#">修改</a> <a href="#">删除</a></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
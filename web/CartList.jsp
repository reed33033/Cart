<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/9
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <style type="text/css">
    *{ margin: 5px; padding: 5px;text-decoration:none;}
    html,body{ height: 100%; width: 100%;text-decoration:none;}
    html,body{ text-align: left;font-size: 16px; color: #666; font-family: "Microsoft YaHei", Helvetica, Arial, sans-serif;}
    dl,ol,ul{ list-style-type: none;}
    input{ color: #666;}
    table {margin: auto;}
    table,table tr th, table tr td { border:1px solid #dcdcdc; }

    /* 表 */
    .xt-table{ margin: 20px; border: 1px solid #dcdcdc;}
    .xt-table td,.xt-table th{ background: #fff; padding: 16px 8px;}
    .xt-table th{ background: #eee; border-bottom:1px solid #dcdcdc; }
    .xt-table tr.xt-bg td{ background: #f9fafa;}
    .xt-table tr td{text-align: center;}
    .xt-table tr td a{ padding: 3px 5px; text-decoration: none; border-radius: 5px; display: inline-block; margin: 0 2px;}
    .xt-table tr:hover td{ background: #73cfce; color: #fff;}
    .xt-table tr:hover td a:hover{color: #baa01b; background: #f5e17a;}

    /* a/input样式 */
    .yellow-xt{ background: #ffb849; color: #fff;}
    .red-xt{ background: #da542e; color: #fff;}
    .blue-xt{ background: #2596d4; color: #fff;}
    .green-xt{ background: #21b6b4; color: #fff;}
    .green-int{ background: #21b6b4; color: #fff; padding: 6px 20px; border: none; border-radius: 8px; font-size: 14px;}
    .yellow-int{ background: #ffb849; color: #fff; padding: 6px 20px; border: none; border-radius: 8px; font-size: 14px;}
  </style>
  <script src="js/jquery.js"></script>
  <script src="js/bootstrap.min.js"></script>

  <body>
  <h1 style="text-align:center;">购物车列表</h1>
  <table style="border: 1px solid #000" class="listView" data-options="checkableOptions">
    <thead>
    <tr style="border: 1px solid #000">
      <th>编号</th>
      <th>名称</th>
      <th>数量</th>
      <th>价格</th>
      <th>总价格</th>
    </tr>

    </thead>
    <c:forEach var="c" items="${clist}">
      <tbody>
      <tr style="border: 1px solid #000">
        <td id="id" name="id" value="${c.id}">${c.id}</td>
        <td id="name" name="name" value="${c.name}">${c.name}</td>
        <td id="count" name="count" value="${c.count}">${c.count}</td>
        <td id="price" name="price" value="${c.price}">${c.price}</td>
        <td id="totalPrice" name="totalPrice" value="${c.totalPrice}">${c.totalPrice}</td>
      </tr>
      </tbody>
    </c:forEach>
  </table>
  </div>

  </body>
</html>

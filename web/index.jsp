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

  <script type="text/javascript">
    // $(document).on('click','.red-xt',function(){
    //   //开始发送数据
    //   var obj = {
    //     id: $(".id").text(),
    //     name: $(".name").text(),
    //     brand: $(".brand").text(),
    //     describe: $(".describe").text(),
    //     price: $(".price").text(),
    //     sales: $(".sales").text(),
    //     score: $(".score").text()
    //   }
    //   alert($(".id").text() + " " + $("#name").text());
    //   var s = JSON.stringify(obj)
    //   $.ajax({
    //     //几个参数需要注意一下
    //     type: "POST",//方法类型
    //     dataType: "text",//预期服务器返回的数据类型
    //     url: "http://localhost:8081/Cart/add",//url
    //     data: {info: s},
    //     success: function (data) {
    //       //根据返回值进行状态显示
    //       alert("加入成功");
    //     },
    //     error: function (data) {
    //       alert("异常！");
    //     }
    //   })
    // })
    $(document).ready(function(){
              $(".red-xt",this).click(function() {
                        //开始发送数据
                        var obj = {
                          id: $(this).parents("tr").find(".id1").text(),
                          name: $(this).parents("tr").find(".name").text(),
                          brand: $(this).parents("tr").find(".brand").text(),
                          describe: $(this).parents("tr").find(".describe").text(),
                          price: $(this).parents("tr").find(".price").text(),
                          sales: $(this).parents("tr").find(".sales").text(),
                          score: $(this).parents("tr").find(".score").text()
                        }
                        var s = JSON.stringify(obj)
                        $.ajax({
                          //几个参数需要注意一下
                          type: "POST",//方法类型
                          dataType: "text",//预期服务器返回的数据类型
                          url: "http://localhost:8081/Cart/add",//url
                          data: {info: s},
                          success: function (data) {
                            //根据返回值进行状态显示
                            alert("加入成功");
                          },
                          error: function (data) {
                            alert("异常！");
                          }
                        })
                      }
              )
    }
    )





    // function add() {
    //   //开始发送数据
    //   var obj = {
    //     id: $("#id").text(),
    //     name: $("#name").text(),
    //     brand: $("#brand").text(),
    //     describe: $("#describe").text(),
    //     price:$("#price").text(),
    //     sales:$("#sales").text(),
    //     score:$("#score").text()
    //   }
    //   alert($("#id").text());
    //   var s=JSON.stringify(obj)
    //   $.ajax({
    //     //几个参数需要注意一下
    //     type: "POST",//方法类型
    //     dataType: "text",//预期服务器返回的数据类型
    //     url: "http://localhost:8081/Cart/add" ,//url
    //     data: {info:s},
    //     success: function (data) {
    //       //根据返回值进行状态显示
    //       alert("加入成功");
    //          },
    //     error : function(data) {
    //       alert("异常！");
    //     }
    //   })
    // }
  </script>
  <body>
  <h1 style="text-align:center;">商品列表</h1>
  <div style="text-align:center">
    <form action="queryServlet" method="post">
  商品名称：<input type="text" name="queryname">
  <input type="submit" value="搜索" class="green-int" />

    <a href="CartList.jsp" class="yellow-xt">进入购物车</a>
    </form>
  </div>
  <div class="plist">
  <form action="add" method="post">
  <table style="border: 1px solid #000" class="listView" data-options="checkableOptions">
    <thead>
    <tr style="border: 1px solid #000">
      <th>编号</th>
      <th>名称</th>
      <th>所属品牌</th>
      <th>描述</th>
      <th>价格</th>
      <th>销量</th>
      <th>买家评分</th>
      <th>操作</th>
    </tr>

    </thead>

      <tbody>
      <c:forEach var="s" items="${applicationScope.list}">
      <tr style="border: 1px solid #000">
        <td id="id1" class="id1" name="id1" value="${s.id}">${s.id}</td>
        <td class="name" id="name" name="name" value="${s.name}">${s.name}</td>
        <td class="brand" id="brand" name="brand" value="${s.brand}">${s.brand}</td>
        <td class="describe" id="describe" name="describe" value="${s.describe}">${s.describe}</td>
        <td class="price" id="price" name="price" value="${s.price}">${s.price}</td>
        <td class="sales" id="sales" name="sales" value="${s.sales}">${s.sales}</td>
        <td class="score" id="score" name="score" value="${s.score}">${s.score}</td>
        <td>
          <input type="button"  class="red-xt"  value="加入购物车">
        </td>
      </tr>
      </c:forEach>
      </tbody>

  </table>
  </form>
  </div>
  </body>
</html>

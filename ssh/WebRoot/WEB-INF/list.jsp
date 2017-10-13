<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>员工列表展示</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
  </head>
  
  <body>
   <table border="1" align="center" width="80%" cellpadding="5" cellspacing="0">
   		<tr>
   			<th>序号</th>
   			<th>员工编号</th>
   			<th>员工姓名</th>
   			<th>员工薪水</th>
   			<th>操作</th>
   		</tr>
   		<s:if test="#request.list != null">
   			<s:iterator var="emp" value="#request.list" status="st">
   				<tr>
   					<td> <s:property value="#st.count"/> </td>
   					<td> <s:property value="#emp.id"/> </td>
   					<td> <s:property value="#emp.empName"/> </td>
   					<td> <s:property value="#emp.salary"/> </td>
   					<td>
   						修改	删除
   					</td>
   				</tr>
   			</s:iterator>
   		</s:if>
   		<s:else>
   			<tr>
   				<td colspan="5">没有要找的数据，请先录入。</td>
   			</tr>
   		</s:else>
   </table>
  </body>
</html>

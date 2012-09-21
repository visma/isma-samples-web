<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="form" uri="/struts-tags" %>
<%@ taglib prefix="html" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Amazon-aws product sample</title>
</head>
<body>
<div id="superglobal">
    <div id="global">
        <h1>Isma : page de test de webservices amazon (amazon aws)</h1>
        <s:form action="amazonProduct">
            <s:select name="searchIndex"
                      label="Product type"
                      headerValue="All"
                      headerKey="All"
                      list="searchIndexList"
                      listKey="id"
                      listLabel="label"
                      theme="simple"
                    />
            &nbsp;
            <s:textfield name="searchKeyWords" label="Recherche" theme="simple"/>
            &nbsp;
            <s:submit name="Search" theme="simple"/>
        </s:form>
        <br/>

        <h2>Liste</h2>
        <table border="1">
            <tr>
                <td>Medium image</td>
                <td>Title</td>
                <td>Brand</td>
                <td>Edition</td>
                <td>Genre</td>
                <td>Hardware Platform</td>
                <td>Operating system</td>
                <td>ASIN</td>
            </tr>
            <s:iterator var="product" value="productList" status="stat">
                <tr>
                    <td><img src="<s:property value="#product.mediumImageUrl"/>"/></td>
                    <td><s:property value="#product.title"/></td>
                    <td><s:property value="#product.brand"/></td>
                    <td><s:property value="#product.edition"/></td>
                    <td><s:property value="#product.genre"/></td>
                    <td><s:property value="#product.hardwarePlatform"/></td>
                    <td><s:property value="#product.operatingSystem"/></td>
                    <td><s:property value="#product.asin"/></td>
                </tr>
            </s:iterator>
        </table>
    </div>
</div>
</body>
</html>
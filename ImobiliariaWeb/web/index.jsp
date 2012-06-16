<%-- 
    Document   : index
    Created on : 15/06/2012, 21:48:52
    Author     : Maycon
--%>

<%@page import="DAO.DAOEndereco"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1></h1>
        <select name="selectPais">
        <jsp:useBean id="paises" scope="request" class="DAO.CarregaEnderecoDAO"/>
        <c:forEach items="${paises.carregaPaisList()}" var="pais">
            <option>
                <c:out value="${pais.nome}"/>
            </option>
        </c:forEach>
        
        </select>
        
    </body>
</html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Buscar por CPF</title>
</head>
<body>
<h2>Buscar por CPF</h2>
<c:if test="${not empty LocalizaCPF}">
    <table>
        <tr>
            <td>Token</td>
            <td>${token}</td>
        </tr>
        <tr>
            <td>CPF</td>
            <td>${cpf}</td>
        </tr>
        <tr>
            <td>Data de Nascimento</td>
            <td>${data_nascimento}</td>
        </tr>
        <tr>
            <td>CPF</td>
            <td>${cpf}</td>
        </tr>
    </table>
</c:if>
</body>
</html>

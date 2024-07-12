<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://primefaces.org/ui" prefix="p" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Cadastro de Solicitante</title>
    <link rel="stylesheet" type="text/css" href="#{resource['primeflex/primeflex.css']}" />
</head>
<body>
<f:view>
    <h:form id="formCadastroSolicitante">
        <p:panel header="Cadastro de Solicitante" style="width:300px;">
            <div class="p-field p-col-12 p-md-6">
                <h:outputLabel for="nome" value="Nome:" />
                <p:inputText id="nome" value="#{solicitantesController.solicitante.nome}" required="true" label="Nome"/>
            </div>
            <div class="p-field p-col-12">
                <h:outputLabel for="submit" value="" />
                <p:commandButton id="submit" action="#{solicitantesController.salvarSolicitante}"/>
            </div>
        </p:panel>
    </h:form>
</f:view>
</body>
</html>

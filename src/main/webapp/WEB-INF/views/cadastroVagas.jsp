<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://primefaces.org/ui" prefix="p" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Cadastro de Vagas</title>
    <link rel="stylesheet" type="text/css" href="#{resource['primeflex/primeflex.css']}" />
</head>
<body>
<f:view>
    <h:form id="formCadastroVagas">
        <p:panel header="Cadastro de Vagas" styleClass="p-grid p-fluid">
            <div class="p-field p-col-12 p-md-6">
                <h:outputLabel for="inicio" value="Início:" />
                <p:calendar id="inicio" value="#{vagasController.vaga.inicio}" pattern="dd/MM/yyyy" showButtonPanel="true" />
            </div>
            <div class="p-field p-col-12 p-md-6">
                <h:outputLabel for="fim" value="Fim:" />
                <p:calendar id="fim" value="#{vagasController.vaga.fim}" pattern="dd/MM/yyyy" showButtonPanel="true" />
            </div>
            <div class="p-field p-col-12 p-md-6">
                <h:outputLabel for="quantidade" value="Quantidade:" />
                <p:inputText id="quantidade" value="#{vagasController.vaga.quantidade}" />
            </div>
            <div class="p-field p-col-12">
                <h:outputLabel for="submit" value="" />
                <p:commandButton id="submit" value="Salvar" action="#{vagasController.salvarVagas}" />
            </div>
        </p:panel>
    </h:form>
</f:view>
</body>
</html>
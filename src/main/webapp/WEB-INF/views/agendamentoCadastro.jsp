<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://primefaces.org/ui" prefix="p" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Cadastro de Agendamentos</title>
    <link rel="stylesheet" type="text/css" href="#{resource['primeflex/primeflex.css']}" />
</head>
<body>
<f:view>
    <h:form>
        <p:panel header="Cadastro de Agendamentos" styleClass="p-grid p-fluid">
            <div class="p-field p-col-12 p-md-6">
                <h:outputLabel for="data" value="Data:" />
                <p:calendar id="data" value="#{agendamentosController.agendamento.data}" pattern="dd/MM/yyyy" />
            </div>
            <div class="p-field p-col-12 p-md-6">
                <label for="numero">Número:</label>
                <p:inputText id="numero" value="#{agendamentosController.agendamento.numero}" />
            </div>
            <div class="p-field p-col-12 p-md-6">
                <h:outputLabel for="motivo" value="Motivo:" />
                <p:inputText id="motivo" value="#{agendamentosController.agendamento.motivo}" />
            </div>
            <div class="p-field p-col-12 p-md-6">
                <h:outputLabel for="solicitante" value="Solicitante:" />
                <p:inputText id="solicitante" value="#{agendamentosController.agendamento.solicitante}" />
            </div>
            <div class="p-field p-col-12">
                <h:outputLabel for="submit" value="" />
                <p:commandButton id="submit" value="Salvar" action="#{agendamentosController.salvarAgendamento}" />
            </div>
        </p:panel>
    </h:form>
</f:view>
</body>
</html>

<#include "../base.ftlh">

<#macro page_body>
    <br><br>
    <h2 class="text-center">Create New Invoice</h2>
    <br>

    <div class="container">
        <form action="/invoice/create" method="post">
            <div class="form-group">
                <label for="returnDate">Return Date</label>
                <input class="form-control" id="returnDate" type="date" name="returnDate" min="2020-09-02" required>
            </div>

            <div class="form-group">
                <label for="client">Client</label>
                <select class="form-control" id="client" name="client" required>
                    <option>--- Select ---</option>
                    <#list clients as client>
                        <option value="${client.cedula}">
                            ${client.cedula} - ${client.name} ${client.lastName}
                        </option>
                    </#list>
                </select>
            </div>

            <h3>Returned Equipment</h3>
            <#list equipment as eqp>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" id="equipment" type="checkbox" name="equipment" value="${eqp.id}">
                    <label class="form-check-label" for="equipment">${eqp.name} - ${eqp.category}</label>
                    <img src="data:${eqp.mimeType};base64,${eqp.picture}" class="card-img-top" alt="Equipment's picture" width="auto" height="auto" style="height: 50%; width: 50%; display: block; margin-left: auto; margin-right: auto">
                </div>
            </#list>

            <br>
            <button class="btn btn-primary" type="submit">Save</button><br><br>
        </form>
    </div>
</#macro>

<@display_page/>
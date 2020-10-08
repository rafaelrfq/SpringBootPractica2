<#include "../base.ftlh">

<#macro page_body>
    <br><br>
    <h2 class="text-center">List of Rent</h2><br>
    <div class="container">
        <div>
            <a class="btn btn-outline-primary" href="/rent/create">Create New Rent</a>
        </div>
        <br>
        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Rent Date</th>
                <th scope="col">Due Date</th>
                <th scope="col">Client</th>
                <th scope="col">Equipment</th>
                <th scope="col">Options</th>
            </tr>
            </thead>
            <tbody>
            <#if rent??>
                <#list rent as r>
                    <tr>
                        <th scope="row">${r.rentDate}</th>
                        <td>${r.dueDate}</td>
                        <td>Cedula: ${r.client.cedula}<br>Name: ${r.client.name} ${r.client.lastName}</td>
                        <td>
                            <ul>
                                <#list r.equipment as eqp>
                                    <li>${eqp.name} - ${eqp.category}</li>
                                </#list>
                            </ul>
                        </td>
                        <td>
                            <a class="btn btn-danger" href="#">Delete</a>
                        </td>
                    </tr>
                </#list>
            <#else>
                <tr>
                    <td colspan="6">No rent data was found</td>
                </tr>
            </#if>
            </tbody>
        </table>
    </div>
</#macro>

<@display_page/>
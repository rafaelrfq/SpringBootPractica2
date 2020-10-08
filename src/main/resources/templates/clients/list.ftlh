<#include "../base.ftlh">

<#macro page_body>
    <br><br>
    <h2 class="text-center">List of Clients</h2><br>
    <div class="container">
        <div>
            <a class="btn btn-outline-primary" href="/clients/create">Create New Client</a>
        </div>
        <br>
        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Cedula</th>
                <th scope="col">Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Picture</th>
                <th scope="col">Options</th>
            </tr>
            </thead>
            <tbody>
            <#if clients??>
                <#list clients as client>
                    <tr>
                        <th scope="row">${client.cedula}</th>
                        <td>${client.name}</td>
                        <td>${client.lastName}</td>
                        <td>
                            <img src="data:${client.mimeType};base64,${client.picture}" class="card-img-top" alt="Client's picture" width="auto" height="auto" style="height: 50%; width: 50%; display: block; margin-left: auto; margin-right: auto">
                        </td>
                        <td>
                            <a class="btn btn-danger" href="/clients/delete?cedula=${client.cedula}">Delete</a>
                        </td>
                    </tr>
                </#list>
            <#else>
                <tr>
                    <td colspan="5">No client data was found</td>
                </tr>
            </#if>
            </tbody>
        </table>
    </div>
</#macro>

<@display_page/>
<#include "../base.ftlh">

<#macro page_body>
    <br><br>
    <h2 class="text-center">List of Equipment</h2><br>
    <div class="container">
        <div>
            <a class="btn btn-outline-primary" href="/equipment/create">Create New Equipment</a>
        </div>
        <br>
        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Category</th>
                <th scope="col">Picture</th>
                <th scope="col">Amount</th>
                <th scope="col">Cost Per Day</th>
                <th scope="col">Options</th>
            </tr>
            </thead>
            <tbody>
            <#if inventory??>
                <#list inventory as inv>
                    <tr>
                        <th scope="row">${inv.equipment.name}</th>
                        <td>${inv.equipment.category}</td>
                        <td>
                            <img src="data:${inv.equipment.mimeType};base64,${inv.equipment.picture}" class="card-img-top" alt="Equipment's picture" width="auto" height="auto" style="height: 50%; width: 50%; display: block; margin-left: auto; margin-right: auto">
                        </td>
                        <td>${inv.quantity}</td>
                        <td>${inv.costPerDay}</td>
                        <td>
                            <a class="btn btn-danger" href="/equipment/delete?id=${inv.equipment.id?c}">Delete</a>
                        </td>
                    </tr>
                </#list>
            <#else>
                <tr>
                    <td colspan="6">No equipment data was found</td>
                </tr>
            </#if>
            </tbody>
        </table>
    </div>
</#macro>

<@display_page/>
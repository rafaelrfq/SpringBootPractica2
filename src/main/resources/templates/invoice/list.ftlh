<#include "../base.ftlh">

<#macro page_body>
    <br><br>
    <h2 class="text-center">List of Invoices</h2><br>
    <div class="container">
        <div>
            <a class="btn btn-outline-primary" href="/invoice/create">Create New Invoice</a>
        </div>
        <br>
        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Client</th>
                <th scope="col">Return Date</th>
                <th scope="col">Returned Equipment</th>
                <th scope="col">Remaining Equipment</th>
                <th scope="col">Price</th>
                <th scope="col">Options</th>
            </tr>
            </thead>
            <tbody>
            <#if invoices??>
                <#list invoices as inv>
                    <tr>
                        <th scope="row">Cedula: ${inv.client.cedula}<br>Name: ${inv.client.name} ${inv.client.lastName}</th>
                        <td>${inv.date}</td>
                        <td>
                            <#if inv.returnedEquipment?? && (inv.returnedEquipment?size > 0)>
                                <ul>
                                    <#list inv.returnedEquipment as returned>
                                        <li>${returned.name} - ${returned.category}</li>
                                    </#list>
                                </ul>
                            <#elseif (inv.returnedEquipment?size == 0)>
                                No returned equipment
                            </#if>
                        </td>
                        <td>
                            <#if inv.remainingEquipment?? && (inv.remainingEquipment?size > 0)>
                                <ul>
                                    <#list inv.remainingEquipment as remaining>
                                        <li>${remaining.name} - ${remaining.category}</li>
                                    </#list>
                                </ul>
                            <#elseif (inv.remainingEquipment?size == 0)>
                                No remaining equipment
                            </#if>
                        </td>
                        <td>${inv.totalPrice?c}</td>
                        <td>
                            <a class="btn btn-danger" href="/invoice/delete?id=${inv.id?c}">Delete</a>
                        </td>
                    </tr>
                </#list>
            <#else>
                <tr>
                    <td colspan="6">No invoice data was found</td>
                </tr>
            </#if>
            </tbody>
        </table>
    </div>
</#macro>

<@display_page/>
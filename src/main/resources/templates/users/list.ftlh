<#include "../base.ftlh">

<#macro page_body>
    <br><br>
    <h2 class="text-center">List of Users</h2><br>
    <div class="container">
        <div>
            <a class="btn btn-outline-primary" href="/users/create">Create New User</a>
        </div>

        <br>
        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Username</th>
                <th scope="col">Role(s)</th>
                <th scope="col">Active</th>
                <th scope="col">Options</th>
            </tr>
            </thead>
            <tbody>
            <#if users??>
                <#list users as user>
                    <tr>
                        <th scope="row">${user.name}</th>
                        <td>${user.username}</td>
                        <td>${user.roles}</td>
                        <td>${user.active?string("Yes", "No")}</td>
                        <td>
                            <a class="btn btn-danger" href="/users/toggle?username=${user.username}">Toggle Active State</a>
                        </td>
                    </tr>
                </#list>
            <#else>
                <tr>
                    <td colspan="5">No user data was found</td>
                </tr>
            </#if>
            </tbody>
        </table>
    </div>
</#macro>

<@display_page/>
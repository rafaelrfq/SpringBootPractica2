<#include "../base.ftlh">

<#macro page_body>
    <br><br>
    <h2 class="text-center">Create New User</h2>
    <br>

    <div class="container">
        <form action="/users/create" method="post" modelAttribute="user">
            <div class="form-group">
                <label for="name">Name</label>
                <input class="form-control" id="name" type="text" name="name" required>
            </div>

            <div class="form-group">
                <label for="username">Username</label>
                <input class="form-control" id="username" type="text" name="username" required>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input class="form-control" id="password" type="password" name="password" required>
            </div>

            <div class="form-group">
                <label for="role">Role</label>
                <select class="form-control" id="role" name="role" required>
                    <option value="0">--- Select ---</option>
                    <option value="ADMIN">Admin</option>
                    <option value="USER">User</option>
                </select>
            </div>

            <br>
            <button class="btn btn-primary" type="submit">Save</button>
        </form>
    </div>

</#macro>

<@display_page/>
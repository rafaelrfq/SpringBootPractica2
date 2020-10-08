<#include "../base.ftlh">

<#macro page_body>
    <br><br>
    <h2 class="text-center">Create New Client</h2>
    <br>

    <div class="container">
        <form action="/clients/create" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="cedula">Cedula</label>
                <input class="form-control" id="cedula" type="text" name="cedula" required>
            </div>

            <div class="form-group">
                <label for="name">Name</label>
                <input class="form-control" id="name" type="text" name="name" required>
            </div>

            <div class="form-group">
                <label for="lastname">Last Name</label>
                <input class="form-control" id="lastname" type="text" name="lastname" required>
            </div>

            <div class="form-group">
                <label for="picture">Picture</label>
                <input class="form-control" id="picture" type="file" name="picture">
            </div>

            <br>
            <button class="btn btn-primary" type="submit">Save</button>
        </form>
    </div>

</#macro>

<@display_page/>
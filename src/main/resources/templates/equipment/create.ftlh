<#include "../base.ftlh">

<#macro page_body>
    <br><br>
    <h2 class="text-center">Create New Equipment</h2>
    <br>

    <div class="container">
        <form action="/equipment/create" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">Name</label>
                <input class="form-control" id="name" type="text" name="name" required>
            </div>

            <div class="form-group">
                <label for="category">Category</label>
                <input class="form-control" id="category" type="text" name="category" required>
            </div>

            <div class="form-group">
                <label for="picture">Picture</label>
                <input class="form-control" id="picture" type="file" name="picture" required>
            </div>

            <div class="form-group">
                <label for="amount">Amount</label>
                <input class="form-control" id="amount" type="number" name="amount" min="1" required>
            </div>

            <div class="form-group">
                <label for="cost">Cost per day</label>
                <input class="form-control" id="cost" type="number" name="cost" min="1" required>
            </div>

            <br>
            <button class="btn btn-primary" type="submit">Save</button>
        </form>
    </div>

</#macro>

<@display_page/>
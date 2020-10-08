<#ftl encoding="utf-8">
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rent it</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/"><img src="/img/rent_it.jpg" width="75" height="25"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item inline">
                <a class="nav-link" href="/users/list"><@spring.message "nav_users" /></a>
            </li>
            <li class="nav-item inline">
                <a class="nav-link" href="/clients/list"><@spring.message "nav_clients" /></a>
            </li>
            <li class="nav-item inline">
                <a class="nav-link" href="/equipment/list"><@spring.message "nav_equipment" /></a>
            </li>
            <li class="nav-item inline">
                <a class="nav-link" href="/rent/list"><@spring.message "nav_rent" /></a>
            </li>
            <li class="nav-item inline">
                <a class="nav-link" href="/invoice/list"><@spring.message "nav_invoice" /></a>
            </li>
            <#if user??>
                <li class="nav-item inline">
                    <p class="nav-link"><@spring.message "greeting" /> ${user.getName()}!</p>
                </li>
                <li class="nav-item inline">
                    <a class="nav-link" href="/logout"><@spring.message "nav_logout" /></a>
                </li>
            <#else>
                <li class="nav-item inline">
                    <a class="nav-link" href="/login"><@spring.message "nav_login" /></a>
                </li>
            </#if>
        </ul>
    </div>
</nav>

<br><br>
<h1 class="text-center"><@spring.message "welcome" /></h1>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
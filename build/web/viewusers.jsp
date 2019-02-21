<%@include file="template/header.jsp" %>
<%    
    // If the user is not logged in => redirection to the registration page
    if (session.getAttribute("session_username") == null) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ajouter.jsp");
        dispatcher.forward(request, response);
    }
%>
<div class="jumbotron">
    <h1 class="text-center">Users List</h1>  
</div>
<div class="container">
    <table class="table table-hover text-center">
        <thead class="thead-dark">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Password</th>
                <th>Email</th>
                <th>Sex</th>
                <th>Country</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <%
                /**
                 * Browse the list of users, The update button redirects to the
                 * edit page
                 */
                List<Users> list = (List<Users>) request.getAttribute("list");
                for (Users users : list) {
                    out.println(
                            "<tr>"
                                + "<td>" + users.getId() + "</td>"
                                + "<td>" + users.getName() + "</td>"
                                + "<td>" + users.getPassword() + "</td>"
                                + "<td>" + users.getEmail() + "</td>"
                                + "<td>" + users.getSex() + "</td>"
                                + "<td>" + users.getCountry() + "</td>"
                                + "<td><a href='Servlet?get_id=" + users.getId() + "' class='btn btn-secondary'>Modifier</a></td>"
                                + "<td>"
                                    + "<form method='post' action='Servlet'>"
                                        + "<input type='hidden' name='id' value='" + users.getId() + "'>"
                                        + "<button type='submit' name='delete' class='btn btn-warning'>Supprimer</button>"
                                    + "</form>"
                                + "</td>"
                            + "</tr>"
                    );
                }
            %>
        </tbody>
    </table>
</div>
<%@include file="template/footer.jsp" %>
<script>
    // Adds a class for the table when the screen size is less than 800px
    if($(window).width() < 800){
        $('table').addClass("table-responsive");
    }
</script>
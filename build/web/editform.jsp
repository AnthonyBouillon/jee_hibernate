<%@include file="template/header.jsp" %>
<%    
    // If the user is not logged in => redirection to the registration page
    if (session.getAttribute("session_username") == null) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ajouter.jsp");
        dispatcher.forward(request, response);
    }

    // Retrieves data from a user
    Users users = (Users) request.getAttribute("users");

%>
<div class="jumbotron">
    <h1 class="text-center">Edit Users</h1> 
</div>
<div class="container">
    <form action="Servlet" method="post" class="block-center">

        <div class="form-group col-6">
            <label for="name">Name</label>
            <input type="text" name="name" class="form-control" id="name" value="<%= users.getName()%>">
        </div>

        <div class="form-group col-6">
            <label for="password">Password</label>
            <input type="text" name="password" class="form-control" id="password" value="<%= users.getPassword()%>">
        </div>

        <div class="form-group col-6">
            <label for="email">Email</label>
            <input type="text" name="email" class="form-control" id="email" value="<%= users.getEmail()%>">
        </div>

        <div class="form-group col-6">
            <label for="">Sex : </label>

            <%
                /**
                 * Depending on the option chosen, the fields change
                 */
                if (users.getSex() != null && users.getSex().equals("Male")) {
            %>
                    <input type="radio" name="sex" id="male" value="Male" checked><label for="male">&nbsp;Male</label>
                    <input type="radio" name="sex" id="female" value="Female"><label for="female">&nbsp;Female</label>
            <%
                } else if (users.getSex() != null && users.getSex().equals("Female")) {
            %>
                    <input type="radio" name="sex" id="male" value="Male"><label for="male">&nbsp;Male</label>
                    <input type="radio" name="sex" id="female" value="Female" checked><label for="female">&nbsp;Female</label>
            <%
                } else {
            %>
                    <input type="radio" name="sex" id="male" value="Male"><label for="male">&nbsp;Male</label>
                    <input type="radio" name="sex" id="female" value="Female" checked><label for="female">&nbsp;Female</label>
            <%
                }
            %>

        </div>

        <div class="form-group col-6">
            <label for="country">Country</label>
            <select class="form-control" name="country">
                <!-- The user's country will be selected first -->
                <option value="<%= users.getCountry()%>" selected><%= users.getCountry()%></option>
                <option value="india">India</option>
                <option value="france">France</option>
            </select>
        </div>
        <input type="hidden" name="id" value="<%= users.getId()%>">
        <div class="form-group col-6">
            <input type="submit" class="btn btn-success btn-block" id="submit" name="edit" value="Edit User">
        </div>

    </form>
</div>
<%@include file="template/footer.jsp" %>
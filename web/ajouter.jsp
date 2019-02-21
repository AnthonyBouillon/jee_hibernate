<%@include file="template/header.jsp" %>
<% 
    // If the user is logged in => redirection to the list page
    if (session.getAttribute("session_username") != null) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Servlet");
        dispatcher.forward(request, response);
    }
%>
<div class="jumbotron">
    <h1 class="text-center">Add New User</h1> 
</div>
<div class="container">
    <form action="Servlet" method="post" class="block-center">

        <div class="form-group col-6">
            <label for="name">Name</label>
            <input type="text" name="name" class="form-control" id="name">
        </div>

        <div class="form-group col-6">
            <label for="password">Password</label>
            <input type="password" name="password" class="form-control" id="password">
        </div>

        <div class="form-group col-6">
            <label for="email">Email</label>
            <input type="text" name="email" class="form-control" id="email">
        </div>

        <div class="form-group col-6">
            <label for="">Sex : </label>
            <input type="radio" name="sex" id="male" value="Male"> <label for="male">Male</label>
            <input type="radio" name="sex" id="female" value="Female"> <label for="female">Female</label>
        </div>

        <div class="form-group col-6">
            <label for="country">Country</label>
            <select class="form-control" name="country">
                <option value="india">India</option>
                <option value="france">France</option>
            </select>
        </div>

        <div class="form-group col-6">
            <input type="submit" class="btn btn-success btn-block" id="submit" name="add" value="Add User">
        </div>

    </form>
</div>
<%@include file="template/footer.jsp" %>
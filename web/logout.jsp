<%@include file="template/header.jsp" %>

<div class="jumbotron">
    <h1 class="text-center">Logout</h1>  
</div>
<div class="container">
    <%        
        // If the user is not logged in => redicrection to the registration page
        if (session.getAttribute("session_username") == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ajouter.jsp");
            dispatcher.forward(request, response);
        }
        /**
         * Destroy the sessions, redirects (with s "redirige" without
         * "rediriger") to the login page
         */
        session.invalidate();
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.sendRedirect("login.jsp");
    %>
</div>
<%@include file="template/footer.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Management</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>
        body { background-color: #f4f6f9; }

        .nav-tiles {
            width: 100%;
            background: #ffffff;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            padding: 14px 0;
        }

        .nav-tile {
            display: flex;
            align-items: center;
            gap: 8px;
            padding: 8px 14px;
            border-radius: 8px;
            background: #f8f9fa;
            text-decoration: none;
            color: #333;
            font-weight: 500;
        }

        .nav-tile:hover {
            background: #e9ecef;
        }

        .page-content {
            margin-top: 30px;
        }

        .form-card {
            background: #ffffff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 6px 18px rgba(0,0,0,0.08);
        }
    </style>
</head>

<body>

<!-- 🔹 NAV BAR -->
<div class="nav-tiles">
    <div class="container">
        <div class="row g-2 justify-content-center">

            <div class="col-auto">
                <a href="${pageContext.request.contextPath}/dashboard" class="nav-tile">🏠 Dashboard</a>
            </div>

            <div class="col-auto">
                <a href="${pageContext.request.contextPath}/student/add" class="nav-tile">➕ Add</a>
            </div>

            <div class="col-auto">
                <a href="${pageContext.request.contextPath}/student/find" class="nav-tile">🔍 Find</a>
            </div>

            <div class="col-auto">
                <a href="${pageContext.request.contextPath}/student/edit" class="nav-tile">✏️ Update</a>
            </div>

            <div class="col-auto">
                <a href="${pageContext.request.contextPath}/student/delete" class="nav-tile">🗑️ Delete</a>
            </div>

        </div>
    </div>
</div>

<!-- 🔹 PAGE CONTENT -->
<div class="container page-content">

    <h4 class="mb-4">${pageTitle}</h4>

    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="form-card">

                <!-- CONTENT JSP LOADS HERE -->
                <jsp:include page="${contentPage}" />

            </div>
        </div>
    </div>

</div>

</body>
</html>
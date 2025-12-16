<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Management Dashboard</title>

    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>
        body {
            background-color: #f4f6f9;
        }

        .dashboard-title {
            font-weight: 600;
        }

        .dashboard-card {
            height: 100%;
            border-radius: 12px;
            transition: all 0.25s ease-in-out;
            cursor: pointer;
        }

        .dashboard-card:hover {
            transform: translateY(-6px);
            box-shadow: 0 12px 24px rgba(0,0,0,0.15);
        }

        .icon-circle {
            width: 70px;
            height: 70px;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 34px;
            margin: 0 auto 15px;
        }

        .icon-add { background: #e8f7ef; color: #198754; }
        .icon-find { background: #e9f2ff; color: #0d6efd; }
        .icon-edit { background: #fff4e5; color: #fd7e14; }
        .icon-delete { background: #fdeaea; color: #dc3545; }
    </style>
</head>

<body>

<div class="container mt-5">

    <!-- Header -->
    <div class="text-center mb-5">
        <h2 class="dashboard-title">Student Management Dashboard</h2>
        <p class="text-muted">Manage student profiles from one place</p>
    </div>

    <!-- Dashboard Cards -->
    <div class="row g-4">

        <!-- ADD STUDENT -->
        <div class="col-lg-3 col-md-6">
            <a href="${pageContext.request.contextPath}/student/add"
               class="text-decoration-none text-dark">
                <div class="card dashboard-card text-center p-4">
                    <div class="icon-circle icon-add">+</div>
                    <h5>Add Student</h5>
                    <p class="text-muted mb-0">Create a new student profile</p>
                </div>
            </a>
        </div>

        <!-- FIND STUDENT -->
        <div class="col-lg-3 col-md-6">
            <a href="${pageContext.request.contextPath}/student/find"
               class="text-decoration-none text-dark">
                <div class="card dashboard-card text-center p-4">
                    <div class="icon-circle icon-find">🔍</div>
                    <h5>Find Student</h5>
                    <p class="text-muted mb-0">Search student by ID</p>
                </div>
            </a>
        </div>

        <!-- UPDATE STUDENT -->
        <div class="col-lg-3 col-md-6">
            <a href="${pageContext.request.contextPath}/student/edit"
               class="text-decoration-none text-dark">
                <div class="card dashboard-card text-center p-4">
                    <div class="icon-circle icon-edit">✏️</div>
                    <h5>Update Student</h5>
                    <p class="text-muted mb-0">Edit existing student details</p>
                </div>
            </a>
        </div>

        <!-- DELETE STUDENT -->
        <div class="col-lg-3 col-md-6">
            <a href="${pageContext.request.contextPath}/student/delete"
               class="text-decoration-none text-dark">
                <div class="card dashboard-card text-center p-4">
                    <div class="icon-circle icon-delete">🗑️</div>
                    <h5>Delete Student</h5>
                    <p class="text-muted mb-0">Remove a student record</p>
                </div>
            </a>
        </div>

    </div>

</div>

</body>
</html>
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
        .card {
            transition: transform 0.2s ease, box-shadow 0.2s ease;
            cursor: pointer;
        }
        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 20px rgba(0,0,0,0.15);
        }
        .card-icon {
            font-size: 40px;
        }
    </style>
</head>

<body>

<div class="container mt-5">

    <!-- Header -->
    <div class="text-center mb-5">
        <h2 class="dashboard-title">Student Management Dashboard</h2>
        <p class="text-muted">Manage student profiles from one place</p>
    </div>

    <!-- Cards -->
    <div class="row g-4">

        <!-- ADD STUDENT -->
        <div class="col-md-4">
            <a href="student/form"
               class="text-decoration-none text-dark">
                <div class="card text-center p-4">
                    <div class="card-icon text-success mb-3">➕</div>
                    <h5>Add Student</h5>
                    <p class="text-muted">Create a new student profile</p>
                </div>
            </a>
        </div>

        <!-- FIND STUDENT -->
        <div class="col-md-4">
            <a href="student/find"
               class="text-decoration-none text-dark">
                <div class="card text-center p-4">
                    <div class="card-icon text-primary mb-3">🔍</div>
                    <h5>Find Student</h5>
                    <p class="text-muted">Search student by ID or name</p>
                </div>
            </a>
        </div>

        <!-- UPDATE STUDENT -->
        <div class="col-md-4">
            <a href="${pageContext.request.contextPath}/student/update"
               class="text-decoration-none text-dark">
                <div class="card text-center p-4">
                    <div class="card-icon text-warning mb-3">✏️</div>
                    <h5>Update Student</h5>
                    <p class="text-muted">Edit existing student details</p>
                </div>
            </a>
        </div>

        <!-- DELETE STUDENT -->
        <div class="col-md-4">
            <a href="${pageContext.request.contextPath}/student/delete"
               class="text-decoration-none text-dark">
                <div class="card text-center p-4">
                    <div class="card-icon text-danger mb-3">🗑️</div>
                    <h5>Delete Student</h5>
                    <p class="text-muted">Remove a student record</p>
                </div>
            </a>
        </div>

        <!-- MICROMANAGE STUDENT -->
        <div class="col-md-4">
            <a href="${pageContext.request.contextPath}/student/manage"
               class="text-decoration-none text-dark">
                <div class="card text-center p-4">
                    <div class="card-icon text-info mb-3">⚙️</div>
                    <h5>MicroManage Student</h5>
                    <p class="text-muted">
                        Addresses, Courses, Caretakers, IDs
                    </p>
                </div>
            </a>
        </div>

    </div>

</div>

</body>
</html>
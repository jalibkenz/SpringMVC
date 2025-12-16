<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Digital Diary</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>
        /* Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Segoe UI", Arial, sans-serif;
        }

        /* Full screen background */
        body {
            height: 100vh;
            background-image: url("${pageContext.request.contextPath}/images/digital-diary.jpg");
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;

            display: flex;
            align-items: center;
            justify-content: center;
        }

        /* Overlay for readability */
        .overlay {
            background: rgba(0, 0, 0, 0.55);
            width: 100%;
            height: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        /* Content card */
        .content {
            text-align: center;
            padding: 40px 30px;
            background: rgba(255, 255, 255, 0.1);
            border-radius: 12px;
            backdrop-filter: blur(6px);
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.4);
        }

        .content h1 {
            color: #ffffff;
            font-size: 2.2rem;
            margin-bottom: 30px;
            letter-spacing: 1px;
        }

        /* Button */
        .btn-save {
            display: inline-block;
            padding: 14px 36px;
            font-size: 1.1rem;
            font-weight: 600;
            color: #ffffff;
            background: linear-gradient(135deg, #4CAF50, #2E7D32);
            border: none;
            border-radius: 30px;
            cursor: pointer;
            text-decoration: none;
            transition: transform 0.2s ease, box-shadow 0.2s ease;
        }

        .btn-save:hover {
            transform: translateY(-3px);
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.4);
        }

        /* Responsive */
        @media (max-width: 600px) {
            .content h1 {
                font-size: 1.6rem;
            }

            .btn-save {
                width: 100%;
                padding: 14px;
            }
        }
    </style>
</head>

<body>
<div class="overlay">
    <div class="content">
        <h1>Digital Diary</h1>

        <a href="dashboard" class="btn-save">
            ENTER
        </a>
    </div>
</div>
</body>
</html>
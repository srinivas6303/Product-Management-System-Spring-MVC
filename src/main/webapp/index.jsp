<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Management Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 0;
            background-color: #f4f4f4;
            text-align: center;
        }
        h1 {
            margin-bottom: 20px;
            color: #333;
        }
        .container {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 20px;
            width: 90%;
            margin: auto;
        }
        .form-container {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .form-container.add {
            background: #e3f2fd; /* Light blue for add forms */
        }
        .form-container.get {
            background: #e8f5e9; /* Light green for get forms */
        }
        .form-container.delete {
            background: #ffebee; /* Light red for delete forms */
        }
        .form-container.update {
            background: #fff3e0; /* Light orange for update forms */
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            font-weight: bold;
            margin-top: 10px;
            text-align: left;
        }
        input, select {
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            margin-top: 15px;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            color: white;
        }
        button.add {
            background: #2196f3; /* Blue for add buttons */
        }
        button.get {
            background: #4caf50; /* Green for get buttons */
        }
        button.delete {
            background: #f44336; /* Red for delete buttons */
        }
        button.update {
            background: #ff9800; /* Orange for update buttons */
        }
        button:hover {
            opacity: 0.9;
        }
        @media (max-width: 768px) {
            .container {
                grid-template-columns: 1fr;
            }
        }
    </style>
</head>
<body>
    <h1>Product Management System</h1>
    <div class="container">

        <!-- Add Product Form -->
        <div class="form-container add">
            <form action="/add" method="POST">
                <h2>Add Product</h2>
                <label>Product Name:</label>
                <input type="text" name="name" required>

                <label>Type:</label>
                <input type="text" name="type" required>

                <label>Place:</label>
                <input type="text" name="place" required>

                <label>Warranty (Years):</label>
                <input type="number" name="warrenty" required>

                <button type="submit" class="add">Add Product</button>
            </form>
        </div>

        <!-- Update Product Form -->
        <div class="form-container update">
            <form action="/updateProduct" method="POST">
                <h2>Update Product</h2>
                <label>Product Name:</label>
                <input type="text" name="name" required>

                <label>Type:</label>
                <input type="text" name="type" required>

                <label>Place:</label>
                <input type="text" name="place" required>

                <label>Warranty (Years):</label>
                <input type="number" name="warrenty" required>

                <button type="submit" class="update">Update Product</button>
            </form>
        </div>

        <!-- Get All Products Form -->
        <div class="form-container get">
            <form action="/getAll" method="GET">
                <h2>View All Products</h2>
                <button type="submit" class="get">View All</button>
            </form>
        </div>

        <!-- Get Product By Name Form -->
        <div class="form-container get">
            <form action="/getByName" method="GET">
                <h2>Find Product by Name</h2>
                <label>Product Name:</label>
                <input type="text" name="name" required>
                <button type="submit" class="get">Search</button>
            </form>
        </div>

        <!-- Get Product By Place Form -->
        <div class="form-container get">
            <form action="/getByPlace" method="GET">
                <h2>Find Products by Place</h2>
                <label>Product Place:</label>
                <input type="text" name="place" required>
                <button type="submit" class="get">Search</button>
            </form>
        </div>

        <!-- Find Products by Substring Form -->
        <div class="form-container get">
            <form action="/findSubString" method="GET">
                <h2>Find Products by Text</h2>
                <label>Search Text:</label>
                <input type="text" name="text" required>
                <button type="submit" class="get">Search</button>
            </form>
        </div>

        <!-- Out of Warranty Products Form -->
        <div class="form-container get">
            <form action="/outWarrenty" method="GET">
                <h2>Out of Warranty Products</h2>
                <label>Year:</label>
                <input type="number" name="year" required>
                <button type="submit" class="get">Search</button>
            </form>
        </div>

        <!-- Delete Product By Name Form -->
        <div class="form-container delete">
            <form action="/deleteByName" method="POST">
                <h2>Delete Product by Name</h2>
                <label>Product Name:</label>
                <input type="text" name="name" required>
                <button type="submit" class="delete">Delete</button>
            </form>
        </div>

        <!-- Delete All Products Form -->
        <div class="form-container delete">
            <form action="/deleteAll" method="POST">
                <h2>Delete All Products</h2>
                <button type="submit" class="delete">Delete All</button>
            </form>
        </div>

    </div>
</body>
</html>